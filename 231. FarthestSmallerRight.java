class Solution {
    static class Fenwick {
        int[] bit;
        int size;
        
        Fenwick(int n) {
            size = n;
            bit = new int[n + 2];
            Arrays.fill(bit, -1);
        }
        
        void update(int idx, int val) {
            for (; idx <= size; idx += idx & -idx) {
                bit[idx] = Math.max(bit[idx], val);
            }
        }
        
        int query(int idx) {
            int res = -1;
            for (; idx > 0; idx -= idx & -idx) {
                res = Math.max(res, bit[idx]);
            }
            return res;
        }
    }
    
    public ArrayList<Integer> farMin(int[] arr) {
        int n = arr.length;
        int maxVal = 1000000; // given constraint
        Fenwick fenwick = new Fenwick(maxVal);
        
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));
        
        for (int i = n - 1; i >= 0; i--) {
            int val = arr[i];
            // query for max index of value < arr[i]
            int farthest = fenwick.query(val - 1);
            result.set(i, farthest);
            // update current value index
            fenwick.update(val, i);
        }
        return result;
    }
}
