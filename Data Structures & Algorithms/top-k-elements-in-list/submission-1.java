class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int cCount = map.getOrDefault(nums[i],0);
            map.put(nums[i],cCount+1);
        }
        
         PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.getValue(), b.getValue())
        );

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
          
            if (maxHeap.size() > k) {
                maxHeap.poll(); 
            }
        }
        int[] topK = new int[k];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            topK[i] = maxHeap.poll().getKey();
            i++;
        }
        return topK;
        
    }
}
