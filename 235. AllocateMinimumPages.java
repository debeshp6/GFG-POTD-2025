

class Solution {
    public static int findPages(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return -1; // Not enough books for students

        int low = arr[0], high = 0;
        for (int pages : arr) {
            low = Math.max(low, pages); // Minimum possible allocation
            high += pages;             // Maximum possible allocation
        }

        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2; // Midpoint of search range
            if (canAllocate(arr, k, mid)) {
                result = mid; // Store the valid allocation
                high = mid - 1; // Try for a smaller maximum
            } else {
                low = mid + 1; // Increase the maximum to make allocation feasible
            }
        }

        return result;
    }

    private static boolean canAllocate(int[] arr, int k, int maxPages) {
        int students = 1, currentPages = 0;
        for (int pages : arr) {
            if (currentPages + pages > maxPages) {
                students++;       // Assign to a new student
                currentPages = pages; // Start with the current book
                if (students > k) return false; // Too many students needed
            } else {
                currentPages += pages; // Assign the book to the current student
            }
        }
        return true;
    }
}
