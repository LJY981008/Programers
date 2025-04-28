package makeprime;

public class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    num = nums[i] + nums[j] + nums[k];
                    if(isPrime(num)) answer++;
                }
            }
        }

        return answer;
    }

    public boolean isPrime(int num) {
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