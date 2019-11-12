import unittest
import rhymes.RhymingDictionary

class TestGetSounds(unittest.TestCase):
    def test_something(self):
        self.assertEqual(rhymes.RhymingDictionary.getSounds("data/cmudict-0.7b", ""), [], 1)

    def test_something1(self):
        self.assertEqual(rhymes.RhymingDictionary.getSounds("data/cmudict-0.7b", "OSMANTHUS"), [], 2)

    def test_something2(self):
        self.assertEqual(rhymes.RhymingDictionary.getSounds("data/cmudict-0.7b", "ABADIE"), ["AH0", "B", "AE1", "D", "IY0"], 3)


if __name__ == '__main__':
    unittest.main()
