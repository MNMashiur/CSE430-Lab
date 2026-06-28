import pytest

from grade_classifier import GradeClassifier


@pytest.fixture(scope="module")
def setup():
    print("i am setup before test")
    classifier = GradeClassifier()
    yield classifier
    print("i am done after test")


def test_grade_A(setup):
    assert setup.letter_grade(90) == "A"
    assert setup.letter_grade(95) == "A"
    assert setup.letter_grade(100) == "A"


def test_grade_B(setup):
    assert setup.letter_grade(80) == "B"
    assert setup.letter_grade(85) == "B"
    assert setup.letter_grade(89) == "B"


def test_grade_C(setup):
    assert setup.letter_grade(70) == "C"
    assert setup.letter_grade(75) == "C"
    assert setup.letter_grade(79) == "C"


def test_grade_D(setup):
    assert setup.letter_grade(60) == "D"
    assert setup.letter_grade(65) == "D"
    assert setup.letter_grade(69) == "D"


def test_grade_F(setup):
    assert setup.letter_grade(0) == "F"
    assert setup.letter_grade(50) == "F"
    assert setup.letter_grade(59) == "F"


def test_invalid_scores(setup):
    with pytest.raises(ValueError) as err:
        setup.letter_grade(-1)
    assert str(err.value) == "Score must be between 0 and 100."

    with pytest.raises(ValueError) as err:
        setup.letter_grade(101)
    assert str(err.value) == "Score must be between 0 and 100."