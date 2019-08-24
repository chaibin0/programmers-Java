package q12933;

import static org.junit.Assert.*;

import org.hamcrest.core.Is;

public class Test {

	@org.junit.Test
	public void test() {
		Solution solution = new Solution();
		assertThat(solution.solution(118372), Is.is(873211L));
	}

}
