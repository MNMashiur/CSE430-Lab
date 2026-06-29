import pytest

from calculator import Calculator

@pytest.mark.parametrize(
    "a, b ,expected",
    [
        (7,3,10),
        (-3,3,0),
        (0,0,0),
        (100,200,300),
    ],
)
def test_add_parametrized(a, b, expected):
    calc = Calculator()
    assert calc.add(a, b) == expected