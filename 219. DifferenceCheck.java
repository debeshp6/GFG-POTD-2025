import java.util.Arrays;

class Solution {
    public int minDifference(String[] arr) {
        int n = arr.length;
        int[] seconds = new int[n];

        // Convert each time string to seconds
        for (int i = 0; i < n; i++) {
            String[] timeParts = arr[i].split(":");
            int hours = Integer.parseInt(timeParts[0]);
            int minutes = Integer.parseInt(timeParts[1]);
            int secondsPart = Integer.parseInt(timeParts[2]);
            seconds[i] = hours * 3600 + minutes * 60 + secondsPart;
        }

        Arrays.sort(seconds);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, seconds[i] - seconds[i - 1]);
        }

        minDiff = Math.min(minDiff, (seconds[0] + 86400) - seconds[n - 1]);

        return minDiff;
    }
}
