package pulsesequence;

class Solution {
    public long solution(int[] sequence) {
        long answer = Integer.MIN_VALUE;
        long[] dp1 = new long[sequence.length];
        long[] dp2 = new long[sequence.length];
        int[] pulse = {1, -1};

        for (int i = 0; i < sequence.length; i++) {
            if (i == 0) dp1[i] = sequence[i] * pulse[i % 2];
            else {
                dp1[i] = Math.max(sequence[i] * pulse[i % 2], dp1[i - 1] + (sequence[i] * pulse[i % 2]));
            }
        }
        for (int i = 0; i < sequence.length; i++) {
            if (i == 0) dp2[i] = sequence[i] * pulse[(i + 1) % 2];
            else {
                dp2[i] = Math.max(sequence[i] * pulse[(i + 1) % 2], dp2[i - 1] + (sequence[i] * pulse[(i + 1) % 2]));
            }
        }
        for(int i = 0; i < sequence.length; i++){
            answer = Math.max(answer, dp1[i]);
            answer = Math.max(answer, dp2[i]);
        }
        return answer;
    }
}