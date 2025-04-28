package gamemap;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int[][] maps) {
        int rows = maps.length;
        int cols = maps[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int[][] distance = new int[rows][cols];
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        distance[0][0] = 1;



        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            int dist = current[2];

            if (y == rows - 1 && x == cols - 1) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if (nextY >= 0 && nextY < rows && nextX >= 0 && nextX < cols
                        && maps[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    distance[nextY][nextX] = dist + 1;
                    queue.offer(new int[]{nextY, nextX, dist + 1});
                }
            }
        }

        return -1;
    }
}