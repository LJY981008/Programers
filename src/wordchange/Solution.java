package wordchange;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String[]> queue = new LinkedList<>();
        queue.offer(new String[]{begin, "0"});
        boolean[] visited = new boolean[words.length];

        while (!queue.isEmpty()) {
            String currentWord = queue.peek()[0];
            int changes = Integer.parseInt(queue.poll()[1]);

            if (currentWord.equals(target)) {
                return changes;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canConvert(currentWord, words[i])) {
                    visited[i] = true;
                    queue.offer(new String[]{words[i], String.valueOf(changes + 1)});
                }
            }
        }

        return 0;
    }

    public boolean canConvert(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount == 1;
    }
}