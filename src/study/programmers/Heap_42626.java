package study.programmers;

import java.util.PriorityQueue;

// 19분 06초
public class Heap_42626 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 3}, 70));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
//        Arrays.sort(scoville);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(1000000);
        for (int i = 0, len = scoville.length; i < len; i++) {
            priorityQueue.add(scoville[i]);
        }

        while (priorityQueue.size() >= 2) {
            if (priorityQueue.peek() >= K) {
                break;
            }
            answer++;
            int first = priorityQueue.poll();
            int second = priorityQueue.poll();
            int mixed = first + second * 2;
            priorityQueue.add(mixed);
        }
        if (priorityQueue.size() == 1 && priorityQueue.peek() < K) {
            return -1;
        }
        return answer;
    }
}
