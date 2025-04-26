package wayschool;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];

        dp[n - 1][m - 1] = 1;

        for (int[] puddle : puddles) {
            if (puddle[1] - 1 < n && puddle[0] - 1 < m) {
                dp[puddle[1] - 1][puddle[0] - 1] = -1;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                if (j + 1 < m && dp[i][j + 1] != -1) {
                    dp[i][j] = (dp[i][j] + dp[i][j + 1]) % 1000000007;
                }

                if (i + 1 < n && dp[i + 1][j] != -1) {
                    dp[i][j] = (dp[i][j] + dp[i + 1][j]) % 1000000007;
                }

                if (i == 0 && j == 0) {
                    continue;
                }
            }
        }

        return dp[0][0];
    }
}