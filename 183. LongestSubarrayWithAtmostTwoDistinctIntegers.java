class Solution {
    public int totalElements(int[] arr) {
        // code here
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLength = 1;
        int length = arr.length;
        while (right < length) {
            int rightNum = arr[right];
            freqMap.put(rightNum, freqMap.getOrDefault(rightNum, 0) + 1);
            if (freqMap.size() > 2) {
                int leftNum = arr[left];
                freqMap.put(leftNum, freqMap.get(leftNum) - 1);
                if (freqMap.get(leftNum) == 0) {
                    freqMap.remove(leftNum);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
