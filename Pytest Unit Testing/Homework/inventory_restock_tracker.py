class InventoryItem:
    def __init__(self, quantity, reorder_level):
        self.quantity = quantity
        self.reorder_level = reorder_level

    def restock(self, amount):
        self.quantity += amount

    def sell(self, amount):
        if amount > self.quantity:
            raise ValueError("Not enough stock available.")

        self.quantity -= amount

    def needs_reorder(self):
        if self.quantity <= self.reorder_level:
            return True
        return False

