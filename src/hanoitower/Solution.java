package hanoitower;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<int[]> moves = new ArrayList<>();

    public List<int[]> solution(int n) {
        hanoi(n, 1, 3, 2);
        return moves;
    }

    public void hanoi(int num, int start, int end, int temp) {
        if (num == 1) {
            moves.add(new int[]{start, end});
            return;
        }

        hanoi(num - 1, start, temp, end);
        moves.add(new int[]{start, end});
        hanoi(num - 1, temp, end, start);
    }
}