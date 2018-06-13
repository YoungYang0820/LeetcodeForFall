class Solution:
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        return len(s.rstrip().split(" ")[-1]) if len(s.rstrip()) > 0 else 0
