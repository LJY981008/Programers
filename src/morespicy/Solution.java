package morespicy;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int n = scoville.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(scoville, n, i);
        }

        while (n >= 2 && scoville[0] < K) {
            int first = scoville[0];
            scoville[0] = scoville[n - 1];
            n--;
            heapify(scoville, n, 0);

            if (n >= 1) {
                int second = scoville[0];
                scoville[0] = first + (second * 2);
                heapify(scoville, n, 0);
                answer++;
            } else {
                return -1;
            }
        }

        if (scoville.length > 0 && scoville[0] < K) {
            return -1;
        }

        return answer;
    }
    void heapify(int[] arr, int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }

        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;

            heapify(arr, n, smallest);
        }
    }
}