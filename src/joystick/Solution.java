package joystick;

class Solution {
    public int solution(String name) {
        int n = name.length();
        int ans = 0;

        // 위아래 이동 횟수 계산
        for (char c : name.toCharArray()) {
            int diff = Math.min(c - 'A', 'Z' - c + 1);
            ans += diff;
        }

        // 좌우 이동 횟수 계산
        int move = n - 1;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && name.charAt(j) == 'A') {
                j++;
            }
            int left_move = i;
            int right_move = n - j;
            move = Math.min(move, left_move + right_move + Math.min(left_move, right_move));
        }

        return ans + move;
    }
}