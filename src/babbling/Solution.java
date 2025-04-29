package babbling;

class Solution {
    public int solution(String[] babbling) {
        int count = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        for (String babble : babbling) {
            String remaining = babble;
            String lastWord = "";
            boolean possible = true;
            while (!remaining.isEmpty()) {
                boolean found = false;
                for (String word : words) {
                    if (remaining.startsWith(word) && !word.equals(lastWord)) {
                        remaining = remaining.substring(word.length());
                        lastWord = word;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    possible = false;
                    break;
                }
            }
            if (possible && remaining.isEmpty()) {
                count++;
            }
        }
        return count;
    }
}