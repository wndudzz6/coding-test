package sortingNthingking;

import java.util.LinkedList;
import java.util.Queue;

//6. 멀티태스킹 내가 푼거 그냥 큐랑 객체 씀 15분 안씀
//k범위가 무지막지하기 때문에 long타입으로 써야하는거 체크안했고
//time limited 코드
public class P6 {
    static class Operation{
        int num;
        int s;
        Operation(int num, int s) {
            this.num = num; this.s = s; }
    }

    public int solution(int[] tasks, long k) {
        Queue<Operation> q = new LinkedList<>();
        int idx = 1;
        for(int x : tasks){
            q.offer(new Operation(idx++,x));
        }

        int cnt = 0;
        while(!q.isEmpty()){
            if(cnt == k){
                return q.poll().num;
            }
            Operation o = q.poll();
            o.s--;
            cnt++;
            if(o.s >0) q.offer(o);
        }
        return -1;
    }

    public static void main(String[] args){
        P6 T = new P6();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}
