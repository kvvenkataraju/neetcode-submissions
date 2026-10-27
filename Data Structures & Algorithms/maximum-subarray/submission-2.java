class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum=nums[0];
        int currsum=0;
        int i=0;
        while(i<nums.length){
            currsum+=nums[i];
            maxsum= Math.max(currsum,maxsum) ;
            if(currsum < 0){
                currsum =0;
            }
            i++;
        }
        return maxsum;
    }
}
