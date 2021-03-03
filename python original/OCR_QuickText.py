# icon downloaded from flaticon.com/authors/freepik, author's website: freepik.com

import time
import cv2
import tkinter as tk
import tkinter.font
from PIL import Image, ImageGrab, ImageTk



class ImageSelecter:
    """
     Создает мини окошко, которое проверяет, нажат ли <space>.
     При нажатии, убивает класс и все.
    """

    def __init__(self, master):
        self.next_window = False
        self.master = master
        master.title("OCR QuickText")
        master.geometry("{}x{}".format(350, 60))
        master.resizable(0, 0)
        self.my_font = tkinter.font.Font(family='Rubik', size=14)

        icon = tk.PhotoImage(file='icon.png')
        master.iconphoto(False, icon)

        self.label = tk.Label(master, text="Press <SPACE> to take a screenshot")
        self.label["font"] = self.my_font
        self.label.pack()

        master.bind("<space>", self.take_screen)
        master.mainloop()

    def take_screen(self, event):
        self.next_window = True
        self.master.destroy()
        time.sleep(0.15)  # wait for master is hidden, then next class can take screenshot


class ImageCutter:
    def __init__(self, master):
        """
        Делает скриншот, выводит скриншот на кансас.
        Создается объетк rectangle, полупрозрачный квадрат. Координаты углов: (0, 0), (0, 0)
        При клике обновляется его верхний угол, туда передаются координаты клика.
        При движении мыши обновляется нижний угол, туда передаются координаты последнего движения.
        Бинд <space> сохраняет область и убивает класс.
        """

        self.next_window = False
        self.topx, self.topy, self.botx, self.boty = 0, 0, 0, 0
        self.img_pil = ImageGrab.grab(all_screens=False)  # TBA
        self.img_tk = ImageTk.PhotoImage(self.img_pil)

        self.master = master
        master.attributes('-fullscreen', True)

        self.canvas = tk.Canvas(master,
                                width=self.img_tk.width(), height=self.img_tk.height(),
                                highlightthickness=10, highlightbackground="#0099bf", cursor="plus")
        self.canvas.pack()
        self.canvas.create_image(0, 0, image=self.img_tk, anchor=tk.NW)

        self.selected_id = self.canvas.create_rectangle(self.topx, self.topy, self.botx, self.boty, dash=(5, 2, 2, 1),
                                                        fill='#0099bf', outline='black', stipple="gray12")

        self.canvas.bind("<Button-1>", self.get_mouse_pos)
        self.canvas.bind("<B1-Motion>", self.update_selected_area)

        master.bind("<space>", self.crop_image)
        master.bind("<Escape>", lambda event: master.destroy())

        master.mainloop()

    def get_mouse_pos(self, event):
        self.topx, self.topy = event.x, event.y

    def update_selected_area(self, event):
        self.botx, self.boty = event.x, event.y
        self.canvas.coords(self.selected_id, self.topx, self.topy, self.botx, self.boty)

    def crop_image(self, event):
        crop_area = (self.topx, self.topy, self.botx, self.boty)
        if abs(self.topx - self.botx) and abs(self.topy - self.boty) > 20:
            self.img_crop_pil = self.img_pil.crop(crop_area)
            self.img_crop_pil.save("selected_area.png", format="PNG")

            self.next_window = True
            self.master.destroy()


class ImageProcesser:
    """
    Отоброжает и обрабатывает изображение в лейбле. При движении мыши с зажатым кликом, забирает значение трекбара,
    передает значение в трешхолд cv2, обнавляет с помощью этой картинки изображение в лейбле.
    p.s. Eсли двигать зажатую мышь, изображение будет трешхолдится, но результат не изменится (трэкбар же не двигается).
    """
    def __init__(self, master):
        self.cv2_image = cv2.imread("selected_area.png")[:, :, ::-1]  # RGB to BRG
        self.cv2_image = cv2.cvtColor(self.cv2_image, cv2.COLOR_BGR2GRAY)
        ret, self.cv2_image_thresh = cv2.threshold(self.cv2_image, 150, 255, cv2.THRESH_BINARY)
        self.img_tk = ImageTk.PhotoImage(Image.fromarray(self.cv2_image_thresh))

        self.next_window = False
        self.master = master
        master.title("OCR QuickText")
        master.configure(bg="white")
        icon = tk.PhotoImage(file='icon.png')
        master.iconphoto(False, icon)

        self.trackbar = tk.Scale(master, from_=0, to=255, orient=tk.HORIZONTAL, length=self.img_tk.width())
        self.trackbar.set(150)
        self.trackbar.pack(side=tk.TOP)

        self.label = tk.Label(master, width=self.img_tk.width(), height=self.img_tk.height(), image=self.img_tk)
        self.label.pack()

        master.bind("<space>", self.show_text)
        master.bind("<Escape>", lambda event: master.destroy())
        master.bind("<B1-Motion>", self.threshhold_image)

        master.mainloop()

    def show_text(self, event):
        self.next_window = True
        self.master.destroy()

    def threshhold_image(self, event):
        trackbar_value = self.trackbar.get()

        img = self.cv2_image.copy()

        ret, img = cv2.threshold(img, trackbar_value, 255, cv2.THRESH_BINARY)
        img_pil = Image.fromarray(img)
        img_tk = ImageTk.PhotoImage(img_pil)

        self.label.configure(image=img_tk)
        self.label.image = img_tk

    def return_text(self):
        text = "Тут распознаный текст, но похуй"
        return text


class ImageReturner:
    """
    Просто окно для отображения результирующего текста с картинки.
    """
    def __init__(self, master, text):
        self.master = master
        master.title("OCR QuickText | Text output")
        master.configure(bg="white")
        icon = tk.PhotoImage(file='icon.png')
        master.iconphoto(False, icon)

        self.box = tk.Text(master, relief=tk.FLAT)
        self.box.insert(tk.INSERT, text)
        self.box.pack(expand=1, anchor=tk.NW)

        master.mainloop()


"""
Проверки нужны для того, чтобы понять, закрыто ли окно (убит  ли класс) биндом <space> (продолжить),
или закрыт пользователем крестом или <ESC>.  Почти у каждого класса есть поле bool next_window, и только при True, 
программа вызывает следующий класс.
"""


root0 = tk.Tk()
ImageSelecter = ImageSelecter(root0)

if ImageSelecter.next_window:
    root1 = tk.Tk()
    ImageCutter = ImageCutter(root1)

    if ImageCutter.next_window:
        root2 = tk.Tk()
        ImageProcesser = ImageProcesser(root2)

        if ImageProcesser.next_window:
            text_output = ImageProcesser.return_text()
            if "" in text_output:
                text_output = text_output.replace('', '')

            root3 = tk.Tk()
            ImageReturner(root3, text_output)
