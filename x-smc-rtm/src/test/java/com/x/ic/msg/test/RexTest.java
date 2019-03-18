package com.x.ic.msg.test;

public class RexTest {

	public static void main(String[] args) {
		String str = "aaa[*]";
		String patt = ".*.";
		boolean b = str.matches(patt);
		System.out.println(b);
	}

}
