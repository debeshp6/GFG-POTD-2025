// User function Template for Java

class Solution {
    public String multiplyStrings(String s1, String s2) {
        return (new BigInteger(s1)).multiply(new BigInteger(s2)).toString();
    }
}
