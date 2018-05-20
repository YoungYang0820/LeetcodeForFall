class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                //update dp
                if(nums[i] > nums[j])dp[i] = Math.max(dp[i], dp[j] + 1);
                
            }
            //System.out.println(dp[i]);
        }
        int max = 1;
        for(int i : dp){
            max = Math.max(i, max);
        }
        return max;
        
    }
}
