import unittest

class MathDojo:
    def __init__(self):
        self.result = 0
    def add(self, *nums):
        sum=0
        for e in nums:
            sum+=e
        self.result+=sum
        return self
    
    def subtract(self,*nums):
        sum=0
        for e in nums:
            sum-=e
        self.result+=sum
        return self
    


class test_MathDojo(unittest.TestCase):

    def setUp(self):
        self.md=MathDojo()
    def test_add(self):
        self.assertEqual(self.md.add(1,2,2).add(-5).result,0)

    def test_sub(self):
        self.assertEqual(self.md.subtract(-5).subtract(5).result,0)

    


if __name__ == '__main__':
    unittest.main()