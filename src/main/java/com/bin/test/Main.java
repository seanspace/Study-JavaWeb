package com.bin.test;

public class Main {

	public static void main(String[] args) {
		try {
			throw new NullPointerException("哈哈") ;
		} catch (Exception e) {
			System.err.println("" + e.getMessage());
//			e.printStackTrace();
		} 
	}

}
