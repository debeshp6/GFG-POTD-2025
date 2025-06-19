class Solution {
    public boolean validgroup(int[] arr, int k) {
        if (arr.length % k != 0)
            return false;

        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int num : arr)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        while (!freq.isEmpty()) {
            int first = freq.firstKey();
            for (int i = 0; i < k; i++) {
                int num = first + i;
                if (!freq.containsKey(num))
                    return false;
                freq.put(num, freq.get(num) - 1);
                if (freq.get(num) == 0)
                    freq.remove(num);
            }
        }
        return true;
    }
}

