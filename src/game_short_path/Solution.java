package game_short_path;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println("시작");
		int[][] maps ={
				{ 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1 },
				{ 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 1 },
				{ 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 0 },
				{ 1, 1, 1, 1, 1 }
				};
		System.out.println(sol.solution(maps));
	}

	int[] x = { 0, 0, -1, 1 };
	int[] y = { 1, -1, 0, 0 };
	int visit[][];
	public int solution(int[][] maps) {
		int answer = -1;
		visit = new int[maps.length][maps[0].length];
		Deque<Data> position = new ArrayDeque<>();
		Data end = new Data(maps[0].length, maps.length);
		Data start = new Data(0, 0);
		visit[0][0]=1;
		position.add(start);
		while (!position.isEmpty()) {
			Data data = position.pollFirst();
			for (int i = 0; i < 4; i++) {
				if (overflow(data.xpos, x[i], data.ypos, y[i],maps, end)) {	//경계 밖 처리
					Data next=new Data(data.xpos+x[i],data.ypos+y[i]);
					
					if(data.xpos+x[i]==end.xpos-1&&data.ypos+y[i]==end.ypos-1) {	//결과 값
						answer=visit[data.ypos][data.xpos]+1;
						return answer;
					}
					
					if(visit[data.ypos+y[i]][data.xpos+x[i]]==0) {	//방문
						position.addLast(next);
						System.out.println("x="+(data.xpos+x[i])+"  y="+(data.ypos+y[i]));
						visit[data.ypos+y[i]][data.xpos+x[i]]=visit[data.ypos][data.xpos]+1;
					}
					
				}
			}
		}
		return answer;
	}

	public boolean overflow(int x1, int x2, int y1, int y2,int[][] maps, Data end) {
		if (x1 + x2 < 0 || x1 + x2 >= end.xpos) return false;
		if (y1 + y2 < 0 || y1 + y2 >= end.ypos) return false;
		if(maps[y1+y2][x1+x2]==0) return false;
		return true;
	}

}

class Data {
	public int xpos;
	public int ypos;

	public Data(int xpos, int ypos) {
		this.xpos = xpos;
		this.ypos = ypos;
	}
}
