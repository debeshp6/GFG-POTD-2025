class Solution { 
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String str : arr) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            
            map.putIfAbsent(sortedStr, new ArrayList<>());
            map.get(sortedStr).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}
