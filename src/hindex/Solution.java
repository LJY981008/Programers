package hindex;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        for (int h = n; h >= 0; h--) {
            int count = 0;
            for (int citation : citations) {
                if (citation >= h) {
                    count++;
                }
            }
            if (count >= h) {
                return h;
            }
        }
        return 0;
    }
}