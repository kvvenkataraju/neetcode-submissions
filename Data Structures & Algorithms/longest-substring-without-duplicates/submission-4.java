class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length()==0 ){
            return 0;
        }
        int j=0;
        int maxLength =0;
        HashSet<Character> subSet= new HashSet<Character>();
        for(int i=0;i<s.length();i++){
            while(!subSet.add(s.charAt(i))){
                subSet.remove(s.charAt(j++));
            }
            maxLength = Math.max(maxLength, i - j + 1);
        }
        
        return maxLength;
    }
}
