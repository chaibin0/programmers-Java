package q72413;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

    private int[] aDistance;
    private int[] bDistance;
    private int[] sDistance;
    private int[][] path;
    private static int INFINITE = Integer.MAX_VALUE - 100000;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INFINITE;
        this.path = new int[n][n];

        for (int[] fare : fares) {
            path[fare[0] - 1][fare[1] - 1] = fare[2];
            path[fare[1] - 1][fare[0] - 1] = fare[2];
        }

        this.aDistance = dijkstra(n, a);
        this.bDistance = dijkstra(n, b);
        this.sDistance = dijkstra(n, s);


        for (int i = 0; i < n; i++) {
            if (sDistance[i] == INFINITE) {
                continue;
            }

            answer = Math.min(answer, this.sDistance[i] + aDistance[i] + bDistance[i]);
        }
        return answer;
    }

    public int[] dijkstra(int n, int current) {

        boolean[] visited = new boolean[n];
        int[] distance = new int[n];

        Arrays.fill(distance, INFINITE);

        distance[current - 1] = 0;
        visited[current - 1] = true;

        Deque<Integer> d = new ArrayDeque<>();
        d.addFirst(current - 1);
        while (!d.isEmpty()) {
            int location = d.pollFirst();
            int maxFare = Integer.MAX_VALUE;
            int nextLocation = -1;

            for (int i = 0; i < n; i++) {
                if (visited[i] || this.path[location][i] == 0) {
                    continue;
                }
                distance[i] = Math.min(distance[i], distance[location] + this.path[location][i]);
            }

            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }

                if(maxFare == Integer.MAX_VALUE || maxFare > distance[i]){
                    maxFare = distance[i];
                    nextLocation = i;
                }
            }

            if (nextLocation != -1) {
                visited[nextLocation] = true;
                d.addFirst(nextLocation);
            }
        }

        return distance;
    }

//    public static void main(String[] args) {
//        // 6 4 6 2 [[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]
//        int n = 6;
//        int s = 4;
//        int a = 6;
//        int b = 6;
//        int[][] fares = {
//                {4, 1, 10},
//                {3, 5, 24},
//                {5, 6, 2},
//                {3, 1, 41},
//                {5, 1, 24},
//                {4, 6, 50},
//                {2, 4, 66},
//                {2, 3, 22},
//                {1, 6, 25}
//        };
//
//        System.out.println(new Solution().solution(n, s, a, b, fares));
//    }

    public static void main(String[] args) {
        // 6 4 6 2 [[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]
        int n = 7;
        int s = 3;
        int a = 4;
        int b = 1;
        int[][] fares = {
                {5, 7, 9},
                {4, 6, 4},
                {3, 6, 1},
                {3, 2, 3},
                {2, 1, 6}
        };

        System.out.println(new Solution().solution(n, s, a, b, fares));
    }
}
