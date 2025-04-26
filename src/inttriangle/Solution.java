package inttriangle;

class Solution {
    int[][] max = new int[500][500];
    public int solution(int[][] triangle) {
        int answer = dp(triangle, 0, 0);
        return answer;
    }
    public int dp(int[][] triangle, int x, int y) {
        if(x == triangle.length - 1) return triangle[x][y];
        if(max[x][y] != 0) return max[x][y];
        int result = Math.max(
                triangle[x][y] + dp(triangle, x+1, y),
                triangle[x][y] + dp(triangle, x+1, y+1)
        );
        max[x][y] = result;
        return result;
    }
}