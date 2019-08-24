package q12933;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	public long solution(long n) {
		StringBuilder sb = new StringBuilder();

		String data = String.valueOf(n);
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < data.length(); i++) {
			list.add(data.charAt(i));
		}

		Collections.sort(list, Collections.reverseOrder());
		
		for (char element : list) {
			sb.append(element);
		}

		return Long.parseLong(sb.toString());
	}
}