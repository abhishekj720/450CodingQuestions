//Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.
//Geeksforgeeks


class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        // code here
        Map<Integer,Integer> mp = new HashMap<Integer,Integer>();
        
        
        for(int i =0; i< n ; i++)
        {
            if(mp.containsKey(arr[i]))
            {   
                mp.put(arr[i],mp.get(arr[i]) + 1);
                
            }
            else
                mp.put(arr[i],1);
              
        }
        
        
        int count  =0;
        for(int i =0; i<n ; i++)
        {
            if(arr[i] == k - arr[i] && (mp.get(arr[i]) > 0))
            {
                count += (mp.get(arr[i])*(mp.get(arr[i]) - 1))/2;
                mp.put(arr[i], 0);
            }
            else if(mp.containsKey(k - arr[i]) && (mp.get(arr[i]) > 0))
            {
                count += mp.get(arr[i])*mp.get(k - arr[i]);
                
                mp.put(arr[i], 0);
                mp.put(k - arr[i], 0);
            }
            
            
        }
        
        return count;
    }
}
