package com.algorimthms;

/*
 * number 1 means block
 * number 0 means road that can be accessed
 * number 2 means the right way to the destination
 * number 3 means the wrong way
 * start point is (2,2)
 * destination point is (7,6)
 * Strategies: down, right, up, left
 */
public class Maze {
	public static void main(String[] args) {
		int [][] maze = new int[8][7];
		for(int i =0;i<7;i++) {
			maze[0][i] = 1;
			maze[7][i] = 1;
		}
		for(int i = 0;i<8;i++) {
			maze[i][0] = 1;
			maze[i][6] = 1;
		}
		
		maze[2][1] = 1;
		maze[2][2] = 1;
		
		//print the initial maze
		for(int i =0;i<8;i++) {
			for(int j = 0;j<7;j++) {
				System.out.print(maze[i][j]+" ");
			}
			System.out.println();
		}
		
		getWay(maze,1,1);
		System.out.println("---------------------");
		
		for(int i =0;i<8;i++) {
			for(int j =0;j<7;j++) {
				System.out.print(maze[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	
	private static boolean getWay(int [][] map, int i, int j) {
		if(map[6][5]==2) {
			return true;
		}else {
			if(map[i][j]==0) {
				map[i][j] =2;
				if(getWay(map,i+1,j)){
					return true;
				}else if(getWay(map,i,j+1)) {
					return true;
				}else if(getWay(map,i-1,j)) {
					return true;
				}else if(getWay(map,i,j-1)){
					return true;
				}else {
					map[i][j]=3;
					return false;
				}		
			}else {
				return false;
			}
		}
	}
	
}
