package q12932;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test() {
		Solution solution=new Solution();
		int[] expected= {5,4,3,2,1};

		assertArrayEquals(solution.solution(12345),expected);
	}

}
