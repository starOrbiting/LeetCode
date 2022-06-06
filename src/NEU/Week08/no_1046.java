package NEU.Week08;

import java.util.PriorityQueue;

public class no_1046 {
    public int lastStoneWeight(int[] stones) {
        // 思路：优先队列
        // 根据什么比较
        // 大顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            // 因为是大顶堆，a>=b
            if (a > b){
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
