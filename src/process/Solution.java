package process;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++){
            queue.offer(i);
        }

        int count = 0;
        while (!queue.isEmpty()){
            int current = queue.poll();
            boolean isMax = true;
            for(int index : queue){
                if(priorities[index] > priorities[current]){
                    isMax = false;
                    break;
                }
            }
            if(isMax){
                count++;
                if(current == location) return count;
            }else{
                queue.offer(current);
            }
        }



        return count;
    }
}