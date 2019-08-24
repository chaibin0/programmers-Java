package q12931;

public class Solution {
	public int solution(int n) {
		int answer = 0;
		String value = String.valueOf(n);
		for (int i = 0; i < value.length(); i++) {
			answer += Character.getNumericValue(value.charAt(i));
		}
		
		return answer;
	}
}