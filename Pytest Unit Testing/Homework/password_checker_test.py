import pytest

from password_checker import PasswordChecker

@pytest.fixture(scope="module")
def setup():
    print("i am setup before test")
    checker = PasswordChecker()
    yield checker
    print("i am done after test")

@pytest.mark.parametrize(
    "password, expected",
    [
        ("Mashiur183", True),
        ("Niran18", False),
        ("mashiur183", False),
        ("RahamanMollah", False),
        ("", False),
    ]
)
def test_password_strength(
        setup, password, expected):
    assert setup.is_strong(password) == expected

def test_strong_password(setup):
    assert setup.is_strong("MollahNiran183") is True

def test_too_short(setup):
    assert setup.is_strong("M183") is False

def test_no_digit(setup):
    assert setup.is_strong("MashiurRahaman") is False

def test_no_uppercase(setup):
    assert setup.is_strong("niranmollah183") is False

