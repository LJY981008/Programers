package minsquare;

class Solution {
    public int solution(int[][] citations) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int[] citation : citations) {
            int width = Math.max(citation[0], citation[1]);
            int height = Math.min(citation[0], citation[1]);

            maxWidth = Math.max(maxWidth, width);
            maxHeight = Math.max(maxHeight, height);
        }

        return maxWidth * maxHeight;
    }
}