import pytest

from parking import ParkingFeeCalculator


@pytest.fixture
def setup():
    return ParkingFeeCalculator(hourly_rate=20)


def test_0_hour(setup):
    assert setup.calculate_fee(0) == 0


def test_2_hours(setup):
    assert setup.calculate_fee(2) == 40


def test_tw_five_hours(setup):
    assert setup.calculate_fee(2.5) == 60


def test_negative_hours(setup):
    with pytest.raises(ValueError) as err:
        setup.calculate_fee(-1)

    assert str(err.value) == "Hours cannot be negative."