class PriceComparator:
    def unit_price(self, total_price, quantity):
        if quantity <= 0:
            raise ValueError("Quantity must be positive.")
        return total_price / quantity
    def cheaper_unit(self, price_a, qty_a, price_b, qty_b):
        unit_a = self.unit_price(price_a, qty_a)
        unit_b = self.unit_price(price_b, qty_b)
        return "A" if unit_a <  unit_b else "B"