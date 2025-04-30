package baekjoon14923;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sizeX = Integer.parseInt(st.nextToken());
        int sizeY = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken()) - 1;
        int startY = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        int targetX = Integer.parseInt(st.nextToken()) - 1;
        int targetY = Integer.parseInt(st.nextToken()) - 1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int[][] map = new int[sizeX][sizeY];
        for (int i = 0; i < sizeX; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < sizeY; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (map[startX][startY] == 1) {
            bw.write("-1");
        } else {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{startX, startY, 0, 0});
            boolean[][][] visited = new boolean[sizeX][sizeY][2];
            visited[startX][startY][0] = true;
            int result = -1;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int currentX = current[0];
                int currentY = current[1];
                int distance = current[2];
                int brokenCount = current[3];

                if (currentX == targetX && currentY == targetY) {
                    result = distance;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nextX = currentX + dx[i];
                    int nextY = currentY + dy[i];

                    if (nextX >= 0 && nextX < sizeX && nextY >= 0 && nextY < sizeY) {
                        if (map[nextX][nextY] == 0 && !visited[nextX][nextY][brokenCount]) {
                            visited[nextX][nextY][brokenCount] = true;
                            queue.offer(new int[]{nextX, nextY, distance + 1, brokenCount});
                        }
                        if (map[nextX][nextY] == 1 && brokenCount == 0 && !visited[nextX][nextY][1]) {
                            visited[nextX][nextY][1] = true;
                            queue.offer(new int[]{nextX, nextY, distance + 1, 1});
                        }
                    }
                }
            }
            bw.write(String.valueOf(result));
        }

        br.close();
        bw.flush();
        bw.close();
    }
}