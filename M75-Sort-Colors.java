class Solution {
    public void sortColors(int[] nums) {
        if (nums.length <= 1) return;
        int[] heap = new int[3];
        Arrays.fill(heap, 0);
        for (int num : nums) {
            heap[num]++;
        }
        Arrays.fill(nums, 0, heap[0], 0);
        Arrays.fill(nums, heap[0], heap[0] + heap[1], 1);
        Arrays.fill(nums, heap[0] + heap[1], heap[0] + heap[1] + heap[2], 2);
    }
}
