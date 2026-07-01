class PasswordChecker:
    def is_strong(self, password):
        if not password:
            return False

        if len(password) < 8:
            return False

        has_digit = False
        has_upper = False

        for ch in password:
            if ch.isdigit():
                has_digit = True
            if ch.isupper():
                has_upper = True

        return has_digit and has_upper
