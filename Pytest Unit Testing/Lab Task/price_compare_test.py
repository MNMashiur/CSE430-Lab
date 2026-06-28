import pytest

from price_compare import PriceComparator


def test_unit_price():
    comparator = PriceComparator()
    assert comparator.unit_price(10, 4) == pytest.approx(2.5)


def test_unit_price_invalid_quantity():
    comparator = PriceComparator()

    with pytest.raises(ValueError) as err:
        comparator.unit_price(10, 0)

    assert str(err.value) == "Quantity must be positive."


@pytest.mark.parametrize(
    "price_a, qty_a, price_b, qty_b, expected",
    [
        (10, 5, 12, 4, "A"),
        (15, 3, 20, 5, "B"),
        (20, 10, 15, 5, "A"),
        (18, 6, 10, 2, "A"),
        (12, 3, 20, 8, "B"),
    ],
)
def test_cheaper_unit(price_a, qty_a, price_b, qty_b, expected):
    comparator = PriceComparator()

    assert (comparator.cheaper_unit
        (price_a, qty_a, price_b, qty_b) == expected)
    