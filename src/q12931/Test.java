package q12931;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test() {
		Solution solution=new Solution();
		assertEquals(solution.solution(123), 6);
	}
	
	@org.junit.Test
	public void test2() {
		Solution solution=new Solution();
		assertEquals(solution.solution(987), 24);
	}

}
