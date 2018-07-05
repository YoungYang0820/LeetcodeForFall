class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int num : nums) {
            if (map.containsKey(num)) continue;
            map.put(num, 1);
            if (map.containsKey(num + 1)) {
                int size = map.get(num + 1);
                map.put(num, size + 1);
                map.put(num + size, size + 1);
                max = Math.max(max, map.get(num));
            }
            if (map.containsKey(num - 1)) {
                int size = map.get(num - 1);
                int size2 = map.get(num);
                map.put(num - 1, size + size2);
                map.put(num - size, size + size2);
                map.put(num + size2 - 1, size + size2);
                max = Math.max(max, map.get(num - 1));
            }
        }
        return max;
    }
}
