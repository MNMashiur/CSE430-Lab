class GradeClassifier:
    def letter_grade(self, score):
        if score < 0 or score > 100:
            raise ValueError("Score must be between 0 and 100.")
        if score >= 90:
            return "A"
        if score >= 80:
            return "B"
        if score >= 70:
            return "C"
        if score >= 60:
            return "D"
        return "F"