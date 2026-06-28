class Book:
    def __init__(self, title):
        self.title = title
        self.is_borrowed = False
    def borrow(self):
        if self.is_borrowed:
            raise RuntimeError("Book is already borrowed.")
        self.is_borrowed = True
    def return_book(self):
        if not self.is_borrowed:
            raise RuntimeError("Book was not borrowed.")
        self.is_borrowed = False