package com.algorimthms;

import java.util.HashMap;
import java.util.Map;

class RedundantConnectionII {
    
    class Item{
        int father;
        int edge;
        
        public Item(int father,int edge){
            this.father = father;
            this.edge = edge;
        }
    }
    
    int [] mRoot;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int [] result = new int[2];
        if(edges==null||edges.length==0||edges[0].length==0){
            return result;
        }
        Map<Integer,Item> map = new HashMap<>();
        int curtEdge = -1;
        int preEdge = -1;
        boolean duplicateFather = false;
        for(int i =0;i<edges.length;i++){
            int [] edge = edges[i];
            if(!map.containsKey(edge[1])){
                
                map.put(edge[1],new Item(edge[0],i));
            }else{
                
                preEdge = map.get(edge[1]).edge;
                curtEdge = i;
                
                duplicateFather = true;
                break;
            }
        }
        
        if(duplicateFather){
            //delete the last
            result = findExtraEdge(edges,curtEdge);
        
            if(result==null){
                return edges[curtEdge];
            }else{
                return edges[preEdge];
            }
        }
        
        return findExtraEdge(edges,-1);
        }
    
    
    private int [] findExtraEdge(int [][]edges, int delete){
        int [] result =null;
        mRoot = new int[edges.length+1];
        for(int i =1;i<edges.length;i++){
            mRoot[i] = i;
        }
        
        for(int i =0;i<edges.length;i++){
            if(i==delete) continue;
            if(!union(edges[i][0],edges[i][1])){
                return edges[i];
            }
        }
        return result;
    }
    
    private int find(int x){
        if(x==mRoot[x]){
            return x;
        }
        return mRoot[x] = find(mRoot[x]);
    }
    
    private boolean union(int a, int b){
        int a_root = find(a);
        int b_root = find(b);
        if(a_root!=b_root){
            mRoot[a_root] = mRoot[b_root];
            return true;
        }
        return false;
    }
    
    }



