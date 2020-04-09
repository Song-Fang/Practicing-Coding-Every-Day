package com.algorimthms;

import java.util.Arrays;
import java.util.Comparator;

public class Compare {
	public static void main(String[] args) {
		String [] str = {"hello","zigzag","eating","training"};
		Arrays.sort(str, new Comparator<String>() {
		
			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				return -s1.compareTo(s2);
			}
		});
			
		System.out.println(Arrays.toString(str));
		
		Goods good1 = new Goods("computer",3000);
		Goods good2 = new Goods("play station",2500);
		Goods good3 = new Goods("laptop",3000);
		Goods [] goods = {good1,good2,good3};
		Arrays.sort(goods);
		System.out.println(Arrays.toString(goods));
		
		
	}
}


class Goods implements Comparable{
	String name;
	double price;
	public Goods(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Goods [name=" + name + ", price=" + price + "]";
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Goods) {
			Goods item = (Goods)o;
			if(this.price==item.price) {
				return this.name.compareTo(item.name);
			}else if(this.price>item.price){
				return 1;
			}else {
				return -1;
			}
		}
		
		throw new RuntimeException("Wrong input parameters!");
	}
	
	
	
	
	
	
}
