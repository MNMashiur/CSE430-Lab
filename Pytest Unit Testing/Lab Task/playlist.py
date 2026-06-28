class Playlist:
    def __init__(self):
        self.tracks = []
    def add_track(self, name):
        self.tracks.append(name)
    def play_next(self):
        if not self.tracks:
            raise IndexError("Playlist is empty.")
        return self.tracks.pop(0)
    def track_count(self):
        return len(self.tracks)