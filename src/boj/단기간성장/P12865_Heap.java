package boj.단기간성장;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P12865_Heap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 최대 힙: 중간 이하 값
        PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
        // 최소 힙: 중간 초과 값
        PriorityQueue<Integer> right = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            left.offer(num);

            // Step 1: left가 right보다 2개 이상 많으면 조정
            if (left.size() > right.size() + 1) {
                right.offer(left.poll());
            }

            // Step 2: peek 값 비교해서 정렬 어긋나면 swap
            if (!right.isEmpty() && left.peek() > right.peek()) {
                left.offer(right.poll());
                right.offer(left.poll());
            }

            sb.append(left.peek()).append("\n");
        }

        System.out.print(sb);
    }
}
