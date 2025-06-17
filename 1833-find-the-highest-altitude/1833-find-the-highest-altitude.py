class Solution(object):
    def largestAltitude(self, gain):
        """
        :type gain: List[int]
        :rtype: int
        """
        highest = 0
        alt = 0
        for x in gain:
            alt = x + alt
            if alt > highest:
                highest = alt
        return highest
        