// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        
        int max_count = 0;
        int count = 0;
        int index = -1;
        
        for(int i = 0; i < arr.length; ++i) {
            for(int j = 0 ; j < arr[i].length; ++j) {
                if(arr[i][j] == 1)
                    count++;
            }
            if(count > max_count) {
                max_count = count;
                index = i;
            }
            count = 0;
        }
        return index;
    }
}
