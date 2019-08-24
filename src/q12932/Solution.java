package q12932;

class Solution {
	public int[] solution(long n) {
		String value = String.valueOf(n);
		int[] answer = new int[value.length()];
		for (int i = value.length() - 1; i >= 0; i--) {
			answer[value.length() - 1 - i] = Character.getNumericValue(value.charAt(i));
		}

		return answer;
	}
}