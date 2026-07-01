import pytest
from movie_ticket import Cinema

@pytest.fixture(scope="module")
def setup():
    print("i am setup before test")
    cinema = Cinema(10)
    yield cinema
    print("i am done after test")

def test_normal_booking(setup):
    setup.book_seats(3)
    assert setup.available_seats() == 7

def test_exact_sellout():
    cinema = Cinema(5)
    cinema.book_seats(5)
    assert cinema.available_seats() == 0
    assert cinema.is_sold_out() is True

def test_overbooking():
    cinema = Cinema(4)
    with pytest.raises(ValueError) as err:
        cinema.book_seats(6)
    assert str(err.value) == "Not enough seats available."

def test_booking_zero_seats():
    cinema = Cinema(8)
    cinema.book_seats(0)
    assert cinema.available_seats() == 8
    assert cinema.is_sold_out() is False

def test_multiple_booking():
    cinema = Cinema(12)
    cinema.book_seats(2)
    cinema.book_seats(4)
    assert cinema.available_seats() == 6
    assert cinema.is_sold_out() is False

def test_book_one_seat():
    cinema = Cinema(7)
    cinema.book_seats(1)
    assert cinema.available_seats() == 6
    assert cinema.is_sold_out() is False

def test_book_remaining_seats():
    cinema = Cinema(6)
    cinema.book_seats(2)
    cinema.book_seats(4)
    assert cinema.available_seats() == 0
    assert cinema.is_sold_out() is True

def test_overbooking_after_partial_booking():
    cinema = Cinema(5)
    cinema.book_seats(3)
    with pytest.raises(ValueError) as err: cinema.book_seats(3)
    assert str(err.value) == "Not enough seats available."

