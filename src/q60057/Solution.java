package q60057;

class Solution {
	public int solution(String s) {
		int answer = Integer.MAX_VALUE;
		int i, j;
		if (s.length() <= 1) {
			return s.length();
		}
		for (i = 1; i <= s.length() / 2; i++) {
			int value = 0;
			String temp = s.substring(0, i);
			String temp2 = "";
			int count = 1;
			for (j = i; j < s.length(); j += i) {
				if (j + i >= s.length()) {
					temp2 = s.substring(j, s.length());
				} else {
					temp2 = s.substring(j, j + i);
				}
				if (temp.equals(temp2)) {
					count++;
				} else {
					if (count == 1) {
						value += temp.length();
					} else {
						value += (temp.length() + String.valueOf(count).length());
					}
					temp = temp2;
					count = 1;
				}
			}
			if (count != 1) {
				value += (temp.length() + String.valueOf(count).length());
			} else {
				value += (temp.length());
			}
			answer = Math.min(answer, value);

		}

		return answer;
	}

	public static final void main(String[] args) {
		Solution solution = new Solution();
		System.out.println("°ª");
		System.out.println(solution.solution("aaaaaaaaaa"));
	}
}