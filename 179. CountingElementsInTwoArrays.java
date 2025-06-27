class Solution {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> ans1 = new ArrayList<>();
        
        for(int ele : a)
        ans.add(ele);
        
        Arrays.sort(b);
        int m = b.length;
        int n= a.length;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxi=0, j=0;
        
        Arrays.sort(a);
        
        for(int i=0; i<n; i++){
            int v = a[i];
            
            while(j<m){
                
                if(b[j]<=v){
                    maxi = j+1;
                    j++;
                } else break;
            }
            
            if(!map.containsKey(v)){
            map.put(v, maxi);
            }
        }
        
        for(int i=0; i<n; i++){
            ans1.add(map.get(ans.get(i)));
        }
        
        return ans1;
    }
}







