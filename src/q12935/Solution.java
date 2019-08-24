package q12935;

class Solution {
	public int[] solution(int[] arr) {
		int[] answer;
		if (arr.length <= 1) {
			answer = new int[1];
			answer[0] = -1;
			return answer;
		}

		int min = Integer.MAX_VALUE;
		for (int value : arr) {
			if (min > value)
				min = value;
		}
		answer = new int[arr.length - 1];

		boolean isMin = false;
		int index = 0;
		for (int value : arr) {
			if (value == min && !isMin) {
				isMin = true;
				continue;
			}
			answer[index++] = value;
		}

		return answer;
	}
}