import pytest

from library import Book


@pytest.fixture(scope="module")
def setup():
    print("i am setup before test")
    book = Book("Book")
    yield book
    print("i am done after test")


def testBorrow(setup):
    setup.borrow()
    assert setup.is_borrowed is True


def testBorrowAlreadyBorrowed(setup):
    with pytest.raises(RuntimeError) as err:
        setup.borrow()
    assert str(err.value) == "Book is already borrowed."


def testReturnBorrowedBook(setup):
    setup.return_book()
    assert setup.is_borrowed is False


def testReturnBookNotBorrowed(setup):
    with pytest.raises(RuntimeError) as err:
        setup.return_book()
    assert str(err.value) == "Book was not borrowed."