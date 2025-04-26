package n_expression;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {


    public int solution(int N, int number) {
        if(N == number) return 1;

        List<Set<Integer>> list = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            list.add(new HashSet<>());
        }
        list.get(1).add(N);
        for(int i = 2; i <= 8; i++){
            int num = 0;
            for(int j = 1; j <= i; j++){
                num = num * 10 + N;
                if(num > number) break;
            }
            list.get(i).add(num);

            for(int j = 1; j < i; j++){
                Set<Integer> op1 = list.get(j);
                Set<Integer> op2 = list.get(i-j);

                for(int value1 : op1){
                    for(int value2 : op2){
                        list.get(i).add(value1 + value2);
                        list.get(i).add(value1 - value2);
                        list.get(i).add(value1 * value2);
                        if(value2 != 0)
                            list.get(i).add(value1 / value2);
                    }
                }
            }
            if(list.get(i).contains(number)) return i;
        }

        return -1;
    }
}