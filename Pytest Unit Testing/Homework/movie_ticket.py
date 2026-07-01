class Cinema:
    def __init__(self, total_seats):
        self.total_seats = total_seats
        self.booked = 0

    def book_seats(self, n):
        if n > self.available_seats():
            raise ValueError("Not enough seats available.")
        self.booked += n

    def available_seats(self):
        return self.total_seats - self.booked

    def is_sold_out(self):
        if self.available_seats() == 0:
            return True
        return False

