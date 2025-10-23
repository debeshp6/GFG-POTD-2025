class Solution {

    public boolean isPossible(int[] arr, int k) {
        
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            if (freq.get(num) == 0) continue; 
            freq.put(num, freq.get(num) - 1);
            if (end.getOrDefault(num - 1, 0) > 0) {
                end.put(num - 1, end.get(num - 1) - 1);
                end.put(num, end.getOrDefault(num, 0) + 1);
            } else {
                boolean canStart = true;
                for (int i = 1; i < k; i++) {
                    if (freq.getOrDefault(num + i, 0) <= 0) {
                        canStart = false;
                        break;
                    }
                }

                if (!canStart) return false;
                for (int i = 1; i < k; i++) {
                    freq.put(num + i, freq.get(num + i) - 1);
                }
                end.put(num + k - 1, end.getOrDefault(num + k - 1, 0) + 1);
            }
        }

        return true;
    }
}
