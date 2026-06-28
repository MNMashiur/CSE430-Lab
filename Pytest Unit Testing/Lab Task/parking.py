class ParkingFeeCalculator:
    def __init__(self, hourly_rate=20):
        self.hourly_rate = hourly_rate
    def calculate_fee(self, hours):
        if hours < 0:
            raise ValueError("Hours cannot be negative.")
        if hours == 0:
            return 0
        full_hours = int(hours) + (1 if hours % 1 > 0 else 0)
        return full_hours * self.hourly_rate
