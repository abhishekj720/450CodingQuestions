//Given a string s, find the length of the longest substring without repeating characters.

 class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() == 1)
            return 1;
        Map<Character,Integer> map = new HashMap<>();
        int j=0;
        int max =0;
        
        for(int i=0; i < s.length(); i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
               max = Math.max(max, i-j) ;
               if(j <= map.get(s.charAt(i)))
                    j = map.get(s.charAt(i)) + 1;
               map.put(s.charAt(i),i);
            }
            else
            {
                map.put(s.charAt(i),i);
            }
        }
        max = Math.max(max, s.length()-j);
        if(map.size() == s.length())
            return s.length();
        
        return max;
    }
}
