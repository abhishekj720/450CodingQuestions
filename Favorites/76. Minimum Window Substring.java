//Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

//The testcases will be generated such that the answer is unique.

//A substring is a contiguous sequence of characters within the string.

 
 
class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> dicT = new HashMap<>();
        
        for(int i=0; i < t.length(); i++)
        {
            dicT.put(t.charAt(i), dicT.getOrDefault(t.charAt(i),0)+1);
        }
        
        Map<Character,Integer> wc = new HashMap<>();
        
        int r=0,l=0;
        int[] ans = {-1,0,0};
        int formed =0;
        int required = dicT.size();
        
        while(r < s.length())
        {
            char c = s.charAt(r);
            wc.put(c, wc.getOrDefault(c,0)+1);
            
            if(dicT.containsKey(c) && dicT.get(c).intValue() == wc.get(c).intValue())
            {
                formed++;
            }
            
            while(l <= r && formed == required)
            {
                
                c = s.charAt(l);
                wc.put(c, wc.get(c)-1);
                if(ans[0] == -1 || r-l+1 < ans[0])
                {
                    ans[0] = r-l+1;
                    ans[1] = l;
                    ans[2] = r;
                }
                
                if(dicT.containsKey(c) && wc.get(c).intValue() < dicT.get(c).intValue())
                {
                    formed--;
                }
                
                l++;
            }
           r++;
        }
        
        
        return ans[0] == -1 ? "" : s.substring(ans[1],ans[2]+1);
        
    }
}
