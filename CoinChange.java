package com.algorimthms;

public class CoinChange {
	public static void main(String [] args) {
		int [] coins = {1,2,5};
		CoinChangeSolution ccs = new CoinChangeSolution();
		System.out.println(ccs.coinChange(4,coins));
	}
}
class CoinChangeSolution{
	public int coinChange(int amount, int [] coins) {
		if(coins==null||coins.length==0) {
			return -1;
		}
		
		int [] minAmount = new int[amount+1];
		minAmount[0] = 0;
		for(int i =1;i<=amount;i++) {
			minAmount[i] = Integer.MAX_VALUE;
			for(int j = 0;j<coins.length;j++) {
				if(i>=coins[j]&&minAmount[i-coins[j]]!=Integer.MAX_VALUE) {
					minAmount[i] = Math.min(minAmount[i-coins[j]]+1, minAmount[i]);
				}
			}
		}
		if(minAmount[amount]==Integer.MAX_VALUE) {
			return -1;
		}
		return minAmount[amount];
	}
}
