
class Solution {
    public int[] singleNum(int[] arr) {
        // Code here
        HashSet <Integer> map=new HashSet<>();
        for(int i:arr){
            if(map.contains(i))
                map.remove(i);
            else
                map.add(i);
        }
        
        int[] array=new int[2];
        int i=0;
        for(int val:map){
            array[i]=val;
            i++;
        }
        
        Arrays.sort(array);
        return array;
    }
}
