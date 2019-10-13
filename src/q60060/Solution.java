package q60060;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
/* ¹Ì±¸Çö*/
public class Solution {
	public int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];

		Words root = init(words);

		for (int i = 0; i < queries.length; i++) {
			answer[i] = bfs(root, words, queries[i]);
		}
		return answer;
	}

	private int bfs(Words iter, String[] words, String query) {
		Queue<Words> que = new ArrayDeque<>();
		que.add(iter);

		int state = 0;
		int length = 1;
		int nextLength = 1;

		while (!que.isEmpty() && state < query.length()) {
			length = nextLength;
			nextLength = 0;
			for (int i = 0; i < length; i++) {
				iter = que.poll();
				System.out.println(iter.value);
				if (query.charAt(state) == '?') {
					nextLength = iter.next.size();
					for (char next : iter.next.keySet()) {
						que.add(iter.next.get(next));
					}
				}
				if (iter.next.containsKey(query.charAt(state))) {
					nextLength++;
					que.add(iter.next.get(query.charAt(state)));
				}
			}
			state++;
		}

		return nextLength;
	}

	private Words init(String[] words) {
		Words root = new Words(' ');

		for (String word : words) {
			Words iterator = root;
			for (int i = 0; i < word.length(); i++) {
				if (!iterator.next.containsKey(word.charAt(i))) {
					iterator.next.put(word.charAt(i), new Words(word.charAt(i)));
				}
				iterator = iterator.next.get(word.charAt(i));
				iterator.addCount();
				if (i == word.length() - 1) {
					iterator.end = true;
				}
			}
		}
		return root;
	}

	public static void main(String[] args) {
		String[] words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
		String[] queries = { "fro??", "????o", "fr???", "fro???", "pro?" };
		Solution solution = new Solution();
		int[] result = solution.solution(words, queries);
		for (int r : result) {
			System.out.println(r);
		}
		System.out.println();
	}

	class Words {
		char value;
		int count = 0;
		boolean end = false;
		Map<Character, Words> next = new HashMap<>();

		public int getCount() {
			return count;
		}

		public int isEnd() {

			return end ? 1 : 0;
		}

		public char getValue() {
			return value;
		}

		public Words(char value) {
			this.value = value;
		}

		public void addCount() {
			this.count++;
		}

	}

}
