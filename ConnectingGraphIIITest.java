package com.algorimthms;

public class ConnectingGraphIIITest {

}

class ConnectingGraph3 {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
     
     private int [] graph;
     private int count;
    public ConnectingGraph3(int n) {
        // initialize your data structure here.
        graph = new int[n+1];
        count = n;
        for(int i =1;i<n+1;i++){
            graph[i] = i;
        }
        
    }
    
    public void connect(int a, int b) {
        // write your code here
        int a_root = find(a);
        int b_root = find(b);
        if(a_root!=b_root){
            graph[a_root] = b_root;
            count-=1;
        }
        
    }
    
    private int find(int x){
        if(graph[x]==x){
            return x;
        }
        return graph[x] = find(graph[x]);
    }

    /**
     * @return: An integer
     */
    public int query() {
        // write your code here
        return count;
    }
}
