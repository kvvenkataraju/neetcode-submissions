class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int right=0;
        int maxLength=0;
        int maxFrequency = 0;

         int[] counts = new int[26];
        while(right<s.length()){
           char currentChar= s.charAt(right);
            counts[currentChar - 'A']++;
            maxFrequency = Math.max(maxFrequency,counts[currentChar - 'A']);

            if(right-left+1 - maxFrequency > k){
                counts[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }
        return maxLength;
    }
}
