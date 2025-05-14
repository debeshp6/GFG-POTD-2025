

class Solution {
    public String countAndSay(int n) {
    // code here
    if (n == 1) return "1";
    String ans = "";
    String prev = countAndSay(n - 1);
    int currCount = 1;
    for (int i = 0; i < prev.length() - 1; i++) {
        if (prev.charAt(i) == prev.charAt(i + 1)) {
            currCount++;
        } else {
            ans += currCount;
            ans += prev.charAt(i);
            currCount = 1;
        }
    }
        ans += currCount;
        ans += prev.charAt(prev.length() - 1);
        return ans;
    }
}
