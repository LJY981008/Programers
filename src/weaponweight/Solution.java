package weaponweight;

class Solution {
    public int countDivisorsOptimized(int n) {
        int count = 0;
        int sqrtN = (int) Math.sqrt(n);
        for (int i = 1; i <= sqrtN; i++) {
            if (n % i == 0) {
                if (i * i == n) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }

    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int weight = countDivisorsOptimized(i);
            if (weight > limit) {
                weight = power;
            }
            answer += weight;
        }
        return answer;
    }
}