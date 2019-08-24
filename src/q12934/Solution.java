package q12934;

class Solution {
	public long solution(long n) {
		long answer=0;
		double sqrt = Math.sqrt(n);
		System.out.println(sqrt);
		if (sqrt - (long) sqrt != 0.0) {
			return -1;
		}
		answer=(long)sqrt+1;
		return answer*answer;
	}
}