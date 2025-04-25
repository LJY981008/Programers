package truck;

import java.util.LinkedList;
import java.util.Queue;

class Truck {
    int weight;
    int distance;

    public Truck(int weight, int distance) {
        this.weight = weight;
        this.distance = distance;
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck> onBridge = new LinkedList<>();
        int currentWeight = 0;
        int truckIndex = 0;

        while (truckIndex < truck_weights.length || !onBridge.isEmpty()) {
            answer++;

            // 다리 위의 트럭들 이동
            for (Truck truck : onBridge) {
                truck.distance--;
            }

            // 다리에서 나가는 트럭 처리
            if (!onBridge.isEmpty() && onBridge.peek().distance == 0) {
                currentWeight -= onBridge.poll().weight;
            }

            // 새로운 트럭 다리에 올리기
            if (truckIndex < truck_weights.length && currentWeight + truck_weights[truckIndex] <= weight) {
                Truck newTruck = new Truck(truck_weights[truckIndex], bridge_length);
                onBridge.offer(newTruck);
                currentWeight += truck_weights[truckIndex];
                truckIndex++;
            }
        }

        return answer;
    }
}