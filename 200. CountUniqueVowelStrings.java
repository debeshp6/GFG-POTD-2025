class Solution {
    public int vowelCount(String s) {
        
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' ||ch=='o' ||ch=='u'){
                if(map.containsKey(ch)){
                    map.put(ch,map.get(ch)+1);
                }
                else map.put(ch,1);
            }
        }
        
        int size = map.size();
        if(map.size()==0) return 0;
        int ans = 1;
        while(size>0){
            ans = ans*size;
            size--;
        }
        
        for(char key:map.keySet()){
            ans = ans*map.get(key);
        }
        
        return ans;
    }
}
