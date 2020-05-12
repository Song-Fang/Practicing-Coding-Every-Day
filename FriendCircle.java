package com.algorimthms;

public class FriendCircle {

}

class FriendCircleSolution {
    private int [] mRoot;
    private int count;
    public int findCircleNum(int[][] M) {
        if(M==null||M.length==0||M[0].length==0) return 0;
        int m = M.length;
        int n = M[0].length;
        mRoot = new int[m];
        count = m;
        for(int i =0;i<m;i++){
            mRoot[i] = i;
        }
        
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(i!=j&&M[i][j]==1){
                    union(i,j);
                }
            }
        }
        return count;
    }
    
    private int find(int x){
        if(x==mRoot[x]){
            return x;
        }
        
        return mRoot[x] = find(mRoot[x]);
    }
    
    private void union(int a, int b){
        int a_root = find(a);
        int b_root = find(b);
        
        if(a_root!=b_root){
            mRoot[a_root] = mRoot[b_root];
            count--;
        }
    }
}
