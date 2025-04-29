package bestworstlotto;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int zeroCnt = 0;
        int winCnt = 0;

        for (int num : lottos) {
            if (num == 0) {
                zeroCnt++;
            }
        }

        for (int winNum : win_nums) {
            if (Arrays.binarySearch(lottos, winNum) >= 0) {
                winCnt++;
            }
        }

        int bestRank = winCnt + zeroCnt;
        int worstRank = winCnt;

        answer[0] = getRank(bestRank);
        answer[1] = getRank(worstRank);

        return answer;
    }

    private int getRank(int count) {
        switch (count) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            default: return 6;
        }
    }
}