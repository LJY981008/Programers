package findfrime;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int solution(String numbers) {
        int count = 0;
        char[] numberArray = numbers.toCharArray();
        Queue<String> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for(char number : numberArray){
            queue.offer(String.valueOf(number));
        }
        search(queue, set, "");

        for(Integer num : set){
            count += isPrime(num) ? 1 : 0;
        }

        return count;
    }

    public void search(Queue<String> queue, Set<Integer> set, String number){
        if(queue.isEmpty()) return;
        else{
            String temp = number;
            int length = queue.size();
            for(int i = 0; i < length; i++){
                String num = queue.poll();
                number += num;
                set.add(Integer.parseInt(number));
                search(queue, set, number);
                queue.offer(num);
                number = temp;
            }
        }
    }

    public boolean isPrime(int num){
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
