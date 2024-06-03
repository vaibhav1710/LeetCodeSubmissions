class Solution {
    public int minimumDifference(int[] nums, int k) {
        /*
        k = 3
        01 , 10 , 100, 101 
        k = 11
      
        */
        
        SegmentTree sg = new SegmentTree(nums);
        int ans = Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++){
            
            int left = i;
            int right = nums.length-1;
            
            while(left<=right){
                int mid = (left+right)/2;
                int suband = sg.query(i,mid);
                
                int diff = Math.abs(suband-k);
                ans = Math.min(ans,diff);
                
                if(suband>=k){
                    left = mid+1;
                }else{
                    right=mid-1;
                }
            }
            
        }
        return ans;
    }
    
}

class SegmentTree {
    private int[] tree;
    private int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 0, 0, n - 1);
    }

    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;
            build(arr, leftChild, start, mid);
            build(arr, rightChild, mid + 1, end);
            tree[node] = tree[leftChild] & tree[rightChild];
        }
    }

    public int query(int L, int R) {
        return query(0, 0, n - 1, L, R);
    }

    private int query(int node, int start, int end, int L, int R) {
        if (R < start || end < L) {
            return ~0; // Return all bits set (for AND operation it acts as neutral element)
        }
        if (L <= start && end <= R) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;
        int leftResult = query(leftChild, start, mid, L, R);
        int rightResult = query(rightChild, mid + 1, end, L, R);
        return leftResult & rightResult;
    }
}