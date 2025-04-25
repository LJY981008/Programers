package dnf;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < dungeons.length; i++){
            queue.offer(dungeons[i]);
        }
        answer = search(queue, k, 0);
        return answer;
    }
    public int search(Queue<int[]> queue, int k, int count){
        if(queue.isEmpty()) return count;
        int length = queue.size();
        int inCount = count;
        int inK = k;
        for(int i = 0; i < length; i++) {
            int[] dungeon = queue.poll();
            if(inK >= dungeon[0]) {
                inK -= dungeon[1];
                inCount = Math.max(inCount, search(queue, inK, count + 1));
            }
            queue.offer(dungeon);
            inK = k;
        }
        return inCount;
    }

}