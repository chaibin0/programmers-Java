package q12947;

class Solution {
	public boolean solution(int x) {
		boolean answer = true;
		String value = String.valueOf(x);
		int harshad = getHarshad(value);
		answer = x % harshad == 0 ? true : false;
		return answer;

	}

	private int getHarshad(String value) {
		int harshad = 0;
		for (int i = 0; i < value.length(); i++) {
			harshad += Character.getNumericValue(value.charAt(i));
		}
		return harshad;
	}
}