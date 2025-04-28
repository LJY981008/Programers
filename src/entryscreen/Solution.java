package entryscreen;

import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        return binary(times, n);
    }
    public long binary(int[] arr, int n){
        long low = 0;
        long high = (long) arr[arr.length - 1] * n;
        long mid;
        long result = Long.MAX_VALUE;
        while (low <= high){
            mid = (low+high) / 2;
            if(isPassed(arr, n, mid)){
                result = Math.min(result, mid);
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return result;
    }
    public boolean isPassed(int[] arr, int n, long mid){
        long amount = 0;
        for(int i = 0; i < arr.length; i++){
            amount += mid / arr[i];
        }
        if(amount >= n) return true;
        return false;
    }
}