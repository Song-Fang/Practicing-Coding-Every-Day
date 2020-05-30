package com.algorimthms;

import java.util.PriorityQueue;

public class TrappingWater {

}

class TrappingWaterSolution {
    class Ele{
        int row;
        int column;
        int height;
        
        public Ele(int row,int column,int height){
            this.row = row;
            this.column = column;
            this.height = height;
        }
    }
    
    public int trapRainWater(int[][] heightMap) {
        if(heightMap==null||heightMap.length==0||heightMap[0].length==0) return 0;
        int [] dx = {0,0,1,-1};
        int [] dy = {1,-1,0,0};
        PriorityQueue<Ele> heap = new PriorityQueue<>((a,b)->a.height-b.height);
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean [][] visited = new boolean[m][n];
        for(int i =0;i<n;i++){
            visited[0][i] = true;
            visited[m-1][i] = true;
            heap.offer(new Ele(0,i,heightMap[0][i]));
            heap.offer(new Ele(m-1,i,heightMap[m-1][i]));
        }
        
        for(int i =0;i<m;i++){
            visited[i][0] = true;
            visited[i][n-1] = true;
            heap.offer(new Ele(i,0,heightMap[i][0]));
            heap.offer(new Ele(i,n-1,heightMap[i][n-1]));
        }
        int sum = 0;
        while(!heap.isEmpty()){
            Ele ele = heap.poll();
            for(int i =0;i<dx.length;i++){
                int x = ele.row +dx[i];
                int y = ele.column+dy[i];
                if(x>0&&x<m-1&&y>0&&y<n-1&&!visited[x][y]){
                    sum = sum+Math.max(0,ele.height-heightMap[x][y]);
                    visited[x][y] = true;
                    heap.offer(new Ele(x,y,Math.max(heightMap[x][y],ele.height)));
                }
            }
        }
        return sum;
    }
}
