class Calculator:

    def add(self, a, b):
        return a + b

    def subtract(self, a, b):
        return a - b

    def multiply(self, a, b):
        return a * b

    def divide(self, a, b):
        if (b==0):
            raise ValueError("Can't divide by zero")
        return a / b

c = Calculator()
print(c.add(5,2))
print(c.subtract(5,2))
print(c.multiply(5,2))
print(c.divide(5,2))