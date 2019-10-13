package q60058;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	public String solution(String p) {
		String answer = "";
		if (p.isEmpty()) {
			return "";
		}

		if (isCollectedString(p)) {
			return p;
		}

		int split = getIndexBalancedString(p);
		String u = p.substring(0, split + 1);
		String v;
		if (split == 0) {
			v = "";
		} else {
			v = p.substring(split + 1, p.length());
		}

		StringBuilder temp;

		if (!isCollectedString(u)) {
			temp = new StringBuilder("(");
			temp.append(solution(v));
			temp.append(")");

			temp.append(translateString(u));
		} else {
			temp = new StringBuilder(u).append(solution(v));
		}

//		System.out.println("v = " + v + "  u = " + u);
//		System.out.println("temp : " + temp.toString());
		answer = temp.toString();
		return answer;
	}

	private StringBuilder translateString(String u) {
		StringBuilder sb = new StringBuilder("");
		for (int i = 1; i < u.length() - 1; i++) {
			if (u.charAt(i) == '(') {
				sb.append(')');
			}
			if (u.charAt(i) == ')') {
				sb.append('(');
			}
		}
		return sb;
	}

	private int getIndexBalancedString(String p) {
		int count = 0;
		if (p.isEmpty()) {
			return 1;
		}
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') {
				count++;
			}

			if (p.charAt(i) == ')') {
				count--;
			}

			if (count == 0) {
				return i;
			}
		}

		return 0;
	}

	public boolean isCollectedString(String p) {
		Deque<Boolean> dq = new ArrayDeque<>();

		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') {
				dq.addLast(true);
			}

			if (p.charAt(i) == ')') {
				if (dq.pollLast() == null) {
					return false;
				}
			}
		}

		return dq.isEmpty();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution("()))((()"));
	}

}
