package boj.hyndaeatuo.simulation;

import java.util.Deque;
import java.util.LinkedList;

import java.util.Scanner;

//회전하는 큐
public class P1021 {

    static int[] index;
    static Deque<Integer> dq;

    static int solution(int n, int m){
        int answer = 0;
        dq = new LinkedList<>();
        for(int i = 1; i<=n; i++){
            dq.offer(i);
        }

        for(int x : index){
            int leftCnt = left(x);
            int rightCnt = right(x);

            if (leftCnt <= rightCnt) {
                while (dq.peekFirst() != x) {
                    dq.offerLast(dq.pollFirst());
                    answer++;
                }
                dq.pollFirst();
            } else {
                while (dq.peekFirst() != x) {
                    dq.offerFirst(dq.pollLast());
                    answer++;
                }
                dq.pollFirst();
            }
        }

        return answer;
    }

    static int left(int x){
        int cnt = 0;
        Deque<Integer> tmp = new LinkedList<>(dq);
        while(!tmp.isEmpty()){
            int cur = tmp.poll();
            if(cur == x) break;
            tmp.offer(cur);
            cnt++;
        }
        return cnt;
    }

    static int right(int x){
        int cnt = 0;
        Deque<Integer> tmp = new LinkedList<>(dq);
        while(!tmp.isEmpty()){
            int cur = tmp.pollLast();
            if(cur == x) break;
            tmp.offerFirst(cur);
            cnt++;
        }
        return cnt;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        index = new int[m];
        for(int i = 0; i<m; i++){
            index[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution(n, m));
    }
}
