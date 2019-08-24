package phonecatmon;

import java.util.HashSet;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol=new Solution();
		int[] nums= {3,3,3,2,2,2};
		System.out.println(sol.solution(nums));
	}
	
	public int solution(int[] nums) {
		HashSet<Integer> hash=new HashSet<>();
		for(int num:nums) {
			hash.add(num);
		}
		
		return Math.min(nums.length/2, hash.size());
	}

}
