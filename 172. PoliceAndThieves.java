
class Solution {
    public int catchThieves(char[] arr, int k) {
        List<Integer> police = new ArrayList<>();
        List<Integer> thieves = new ArrayList<>();
        
        // Store indices of police and thieves separately
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'P') police.add(i);
            else thieves.add(i);
        }
        
        int i = 0, j = 0, count = 0;
        
        // Use two pointers to match thieves with police
        while (i < police.size() && j < thieves.size()) {
            if (Math.abs(police.get(i) - thieves.get(j)) <= k) {
                count++; // Match found
                i++;
                j++;
            } else if (police.get(i) < thieves.get(j)) {
                i++; // Move to next police
            } else {
                j++; // Move to next thief
            }
        }
        
        return count;
    }
}
