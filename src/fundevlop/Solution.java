package fundevlop;

import java.util.*;

public class Solution {
    public Queue<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();

        int length = 0;
        int count = 0;
        while(length < progresses.length){
            if(progresses[length] >= 100){
                count++;
                length++;
                if(length < progresses.length) continue;
            }
            if(count != 0){
                queue.offer(count);
                count = 0;
            }
            for(int i = length; i < progresses.length; i++){
                progresses[i] += speeds[i];
            }
        }

        return queue;
    }
}
