package com.algorimthms;

public class RedundantConnection {

}

class RedundantConnectionSolution {
    
    int [] mRoot;
    public int[] findRedundantConnection(int[][] edges) {
        int [] result = new int[2];
        if(edges==null||edges.length==0||edges[0].length==0) return result;
        
        int m = edges.length;
        int n = edges[0].length;
        mRoot = new int[m+1];
        
        for(int i =1;i<=m;i++){
            mRoot[i] = i;
        }
        
        for(int i =0;i<m;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            if(!union(a,b)){
                result[0] = a;
                result[1] = b;
            }
        }
        return result;
    }
    
    private int find(int x){
        if(x==mRoot[x]) return x;
        return mRoot[x] = find(mRoot[x]);
    }
    
    private boolean union(int a,int b){
        int a_root = find(a);
        int b_root = find(b);
        
        if(a_root!=b_root){
            mRoot[a_root] = mRoot[b_root];
            return true;
        }
        return false;
    }
}
