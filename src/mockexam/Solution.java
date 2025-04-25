package mockexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class AnswerToScore {
    int key;
    int value;

    public AnswerToScore(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class Solution {
    public int[] solution(int[] answers) {
        AnswerToScore[] answerToScores = {new AnswerToScore(1, 0), new AnswerToScore(2, 0), new AnswerToScore(3, 0)};
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int length1 = pattern1.length;
        int length2 = pattern2.length;
        int length3 = pattern3.length;

        for (int i = 0; i < answers.length; i++) {
            int type1 = i % length1;
            int type2 = i % length2;
            int type3 = i % length3;

            if (answers[i] == pattern1[type1]) answerToScores[0].value++;
            if (answers[i] == pattern2[type2]) answerToScores[1].value++;
            if (answers[i] == pattern3[type3]) answerToScores[2].value++;
        }

        Arrays.sort(answerToScores, new Comparator<AnswerToScore>() {
            @Override
            public int compare(AnswerToScore o1, AnswerToScore o2) {
                return o2.value - o1.value;
            }
        });

        ArrayList<Integer> answersList = new ArrayList<>();
        int maxScore = answerToScores[0].value;

        for (AnswerToScore scoreInfo : answerToScores) {
            if (scoreInfo.value == maxScore) {
                answersList.add(scoreInfo.key);
            } else {
                break;
            }
        }

        int[] answer = new int[answersList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answersList.get(i);
        }

        return answer;
    }
}