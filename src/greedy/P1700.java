package greedy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//멀티탭 스케줄링
public class P1700 {
    static int solution(int n, int k, int[] order){
        HashMap<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.putIfAbsent(order[i], new LinkedList<>());
            map.get(order[i]).offer(i);
        }

        int[] tab = new int[n];
        boolean[] plugged = new boolean[101]; //전기 용품 최대 개수 100
        int size = 0; // 현재 꽂힌 개수
        int cnt = 0;  // 뽑은 횟수

        for (int i = 0; i < k; i++) {
            int cur = order[i];
            map.get(cur).poll(); // 현재 사용 시점 제거

            if(plugged[cur]) continue;

            if (size < n) {
                tab[size++] = cur; // 빈 자리에 꽂기
                plugged[cur] = true;
            } else {
                // 뺄 물건 찾기
                int idxToRemove = -1;
                int farthest = -1; // 다음 사용 시점
                for (int t = 0; t < n; t++) {
                    Queue<Integer> q = map.get(tab[t]);
                    //nextUse : 이번 슬롯의 개별 측정값
                    int nextUse = q.isEmpty() ? Integer.MAX_VALUE : q.peek();
                    if (nextUse > farthest) {
                        farthest = nextUse; //지금까지 본 최댓값 누적 기록
                        idxToRemove = t;
                    }
                }
                int removed = tab[idxToRemove];
                tab[idxToRemove] = cur;
                plugged[removed] = false;
                plugged[cur] = true;
                cnt++;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] order = new int[k];
        for(int i = 0; i<k; i++){
            order[i] = sc.nextInt();
        }

        System.out.println(solution(n, k, order));
    }
}
