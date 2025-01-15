class Solution {
    public int longestSubarray(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0, -1);
        int size=0;
        int n=arr.length;
        int sum=0;        
        for(int i=0;i<n;i++) {
        	sum+=arr[i];
        	if(!map.containsKey(sum))map.put(sum,i);
        	if(map.containsKey(sum-k)) {
        		int temp=i-map.get(sum-k);
        		size=Math.max(size,temp);
        	}
        }        
    	return size;
    }
}
