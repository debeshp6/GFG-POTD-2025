class Solution {
    
    public int countWays(String digits) {
        // code here
        return f(digits.toCharArray(),0,new Integer[digits.length()]);
    }
    
    public int f(char[] chArr, int i, Integer[] dp){
        if(i == chArr.length) return 1;
        if(dp[i]!=null) return dp[i];
        if( !(chArr[i] > '0' && chArr[i] <= '9')) return dp[i] = 0; 
        int takeOne = f(chArr,i+1,dp);
        int takeTwo=0; 
        if(i+1!=chArr.length){
            int tens=chArr[i]-'0';
            int ones=chArr[i+1]-'0';
            int num=tens*10+ones;
            if(num>=1 &&num<=26){
                takeTwo=f(chArr,i+2,dp);
            }
        }
        return dp[i]=takeOne+takeTwo;
    }
}
