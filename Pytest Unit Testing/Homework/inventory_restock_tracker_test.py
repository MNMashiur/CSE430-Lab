import pytest

from inventory_restock_tracker import InventoryItem

@pytest.fixture(scope="module")
def setup():
    print("i am setup before test")
    item = InventoryItem(50, 10)
    yield item
    print("i am done after test")

def test_restock_item(setup):
    setup.restock(20)
    assert setup.quantity == 70

def test_sell_item(setup):
    setup.sell(15)
    assert setup.quantity == 55

def test_sell_more_than_available():
    item = InventoryItem(20, 5)
    with pytest.raises(ValueError) as err:
        item.sell(25)
    assert str(err.value) == "Not enough stock available."

def test_needs_reorder_true():
    item = InventoryItem(8, 10)
    assert item.needs_reorder() is True

def test_needs_reorder_false():
    item = InventoryItem(25, 10)
    assert item.needs_reorder() is False

@pytest.mark.parametrize(
    "start_qty, reorder_level, restock_amt, sell_amt, expected_qty",
    [
        (30, 5, 10, 15, 25),
        (20, 5, 5, 10, 15),
        (15, 5, 20, 25, 10),
        (40, 10, 0, 20, 20),
    ]
)
def test_restock_sell_combinations(
        start_qty, reorder_level, restock_amt, sell_amt, expected_qty):
    item = InventoryItem(start_qty, reorder_level)
    item.restock(restock_amt)
    item.sell(sell_amt)
    assert item.quantity == expected_qty