package p12930;

import java.util.StringJoiner;

class Solution {
	public String solution(String s) {
		String[] st = s.split(" ",-1);
		StringJoiner sj = new StringJoiner(" ");

		for (String sentence : st) {
			boolean odd = true;
			StringBuilder data = new StringBuilder("");
			for (int i = 0; i < sentence.length(); i++) {
				if (odd) {
					data.append(Character.toUpperCase(sentence.charAt(i)));
				} else {
					data.append(Character.toLowerCase(sentence.charAt(i)));
				}
				odd = odd ? false : true;
			}

			sj.add(data.toString());
		}

		return sj.toString();
	}
}