package com.algorimthms;

public class MaximumSubPalindrom {
	public static void main(String[] args) {
		String str = "cbbd";
		SubPalindromSolution sps = new SubPalindromSolution();
		System.out.println(sps.subPalindrom(str));
	}
}

class SubPalindromSolution {
	public String subPalindrom(String str) {
		if (str==null||str.length() == 0) {
			return str;
		}

		int length = str.length();
		boolean[][] helper = new boolean[length][length];

		int max = 1;
		int index = 0;

		for (int i = 0; i < length; i++) {
			for (int j = 0; j <= i; j++) {
				if (str.charAt(j) == str.charAt(i) && (i - j < 2 || helper[j + 1][i - 1])) {
					helper[j][i] = true;

					if (i - j + 1 > max) {
						max = i - j + 1;
						index = j;
					}
				}
			}
		}
		return str.substring(index, index + max);

	}
}
