package clothes;

import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hash = new HashMap<>();

        for(String[] strs : clothes){
            String tag = strs[1];
            hash.put(tag, hash.getOrDefault(tag, 0) + 1);
        }
        for(Integer value : hash.values()){
            answer *= (value + 1);
        }
        answer -= 1;

        return answer;
    }
}