

// User function Template for Java
class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        int maxTime = 0;

        // For ants moving to the left
        for (int pos : left) {
            maxTime = Math.max(maxTime, pos);  // Time for this ant to fall off is its position
        }

        // For ants moving to the right
        for (int pos : right) {
            maxTime = Math.max(maxTime, n - pos);  // Time for this ant to fall off is n - position
        }

        return maxTime;
    }
}


