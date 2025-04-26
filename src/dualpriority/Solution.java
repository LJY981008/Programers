package dualpriority;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> descQueue = new PriorityQueue<>();
        PriorityQueue<Integer> ascQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (String str : operations) {
            String[] order = str.split(" ");
            String o = order[0];
            int val = Integer.parseInt(order[1]);
            switch (o) {
                case "I": {
                    descQueue.offer(Integer.parseInt(order[1]));
                    ascQueue.offer(Integer.parseInt(order[1]));
                    break;
                }
                case "D": {
                    if (!ascQueue.isEmpty()) {
                        if (val == 1) {
                            if (!ascQueue.isEmpty()) {
                                int value = ascQueue.poll();
                                descQueue.remove(value);
                            }
                        } else if (val == -1) {
                            if (!descQueue.isEmpty()) {
                                int value = descQueue.poll();
                                ascQueue.remove(value);
                            }
                        }
                    }
                    break;
                }
            }
        }

        if (ascQueue.isEmpty()) return new int[]{0, 0};
        return new int[]{ascQueue.peek(), descQueue.peek()};
    }
}