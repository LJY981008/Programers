package itempeek;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int scaledCharacterX = characterX * 2;
        int scaledCharacterY = characterY * 2;
        int scaledItemX = itemX * 2;
        int scaledItemY = itemY * 2;
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        boolean[][] map = new boolean[102][102];

        for (int[] rect : rectangle) {
            mappingRoad(rect, map);
        }
        for (int[] rect : rectangle) {
            mappingBlock(rect, map);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{scaledCharacterX, scaledCharacterY, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int distance = current[2];

            if (currentX == scaledItemX && currentY == scaledItemY) {
                return distance / 2;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX >= 0 && nextX < 102 && nextY >= 0 && nextY < 102 && map[nextX][nextY]) {
                    map[nextX][nextY] = false;
                    queue.offer(new int[]{nextX, nextY, distance + 1});
                }
            }
        }

        return -1;
    }

    public void mappingRoad(int[] coordinate, boolean[][] map) {
        int x1 = coordinate[0] * 2;
        int y1 = coordinate[1] * 2;
        int x2 = coordinate[2] * 2;
        int y2 = coordinate[3] * 2;

        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (i >= 0 && i < 102 && j >= 0 && j < 102) {
                    map[i][j] = true;
                }
            }
        }
    }

    public void mappingBlock(int[] coordinate, boolean[][] map) {
        int x1 = coordinate[0] * 2;
        int y1 = coordinate[1] * 2;
        int x2 = coordinate[2] * 2;
        int y2 = coordinate[3] * 2;

        for (int i = x1 + 1; i < x2; i++) {
            for (int j = y1 + 1; j < y2; j++) {
                if (i > 0 && i < 101 && j > 0 && j < 101) {
                    map[i][j] = false;
                }
            }
        }
    }
}