import pytest

from playlist import Playlist

def test_play_next_returns_first_track():
    playlist = Playlist()
    playlist.add_track("Song 1")
    playlist.add_track("Song 2")
    assert playlist.play_next() == "Song 1"
    assert playlist.play_next() == "Song 2"


def test_track_count():
    playlist = Playlist()
    assert playlist.track_count() == 0
    playlist.add_track("Song 1")
    playlist.add_track("Song 2")
    assert playlist.track_count() == 2

    playlist.play_next()
    assert playlist.track_count() == 1
    playlist.play_next()
    assert playlist.track_count() == 0


def test_play_next_empty_playlist():
    playlist = Playlist()
    with pytest.raises(IndexError) as err:
        playlist.play_next()
    assert str(err.value) == "Playlist is empty."


def test_multiple_assertions():
    playlist = Playlist()
    playlist.add_track("Track a")
    playlist.add_track("Track b")
    assert playlist.track_count() == 2
    assert playlist.play_next() == "Track a"
    assert playlist.track_count() == 1
    assert playlist.play_next() == "Track b"
    assert playlist.track_count() == 0