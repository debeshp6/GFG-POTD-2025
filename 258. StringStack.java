class Solution {
    public boolean stringStack(String pat, String tar) {
        
    int i = pat.length() - 1;
    int j = tar.length() - 1;
    int count = 0;

    while (i >= 0 && j >= 0) {
        if (pat.charAt(i) == tar.charAt(j)) {
            if (count % 2 == 0) {
                i--;
                j--;
            } else {
                i--;
                count++;
            }
        } else {
            i--;
            count++;
        }
    }
        return j == -1;
    }
}
