

class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=1; i<arr.length; i++) {
            if(arr[i] == arr[i-1]) {
                if(list.isEmpty() || list.get(list.size() - 1) != arr[i])
                list.add(arr[i]);
            }
        }
        
        return list;
    }
}
