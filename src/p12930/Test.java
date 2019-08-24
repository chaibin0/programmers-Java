package p12930;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test() {
		String s="try   hello   world";
		String expected="TrY HeLlO WoRlD";
		
		Solution solution=new Solution();
		assertEquals(solution.solution(s),expected);
	}
	

	@org.junit.Test
	public void test1() {
		String s="try hello world strys";
		String expected="TrY HeLlO WoRlD StRyS";
		Solution solution=new Solution();
		assertEquals(solution.solution(s),expected);
	}

	@org.junit.Test
	public void test2() {
		String s="AAAAAAAAAAA A A A A AAAAA AAA";
		String expected="AaAaAaAaAaA A A A A AaAaA AaA";
		Solution solution=new Solution();
		assertEquals(solution.solution(s),expected);
	}
}
