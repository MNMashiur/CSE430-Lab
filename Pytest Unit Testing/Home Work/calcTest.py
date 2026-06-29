import pytest

from calculator import Calculator

@pytest.fixture(scope="module")
def setup():
    print("i am setup before test")
    calc = Calculator()
    yield calc
    print("i am khalass after test")


def testAdd(setup):
    assert setup.add(5,6) == 11
    assert setup.add(-3, 6) == 3

def testSub(setup):
    assert setup.subtract(5,6) == -1
    assert setup.subtract(-3, 6) == -9
    assert setup.subtract(5,2) == 3

def testMultiply(setup):
    assert setup.multiply(5,2) == 10
    assert setup.multiply(-3, 2) == -6

def testDivide(setup):
    assert setup.divide(12,6) == 2

    with pytest.raises(ValueError) as err:
        setup.divide(5,0)
    assert str(err.value) == "Can't divide by zero"

