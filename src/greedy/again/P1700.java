package greedy.again;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1700 {

    static int solution(int n, int k, int[] order){
        int cnt = 0;

        //map : 전자제품 번호 - 사용순서 큐
        HashMap<Integer, Queue<Integer>> map = new HashMap<>();
        for(int i = 0; i<k; i++){
            map.putIfAbsent(order[i],new LinkedList<Integer>());
            map.get(order[i]).offer(i);
        }

        int size = 0;
        for(int i = 0; i<k; i++){

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
        sc.close();
        System.out.println(solution(n, k, order));
    }
}
