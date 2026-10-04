class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        HashMap<Integer,Integer> prefixSumMap= new HashMap<>();
        prefixSumMap.put(0,1);
     for (int i=0;i<nums.length;i++)   {
        currentSum+=nums[i];
        if(prefixSumMap.get(currentSum-k) != null){
            count+= prefixSumMap.get(currentSum - k);
        }
        prefixSumMap.put(currentSum,prefixSumMap.getOrDefault(currentSum,0)+1);
     }
     return count;
    }
}