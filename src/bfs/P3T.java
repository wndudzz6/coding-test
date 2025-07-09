package bfs;

import java.util.LinkedList;
import java.util.Queue;

//ch[상태][위치]
//L%2로 현재 점프한 횟수가 홀이었는지 짝이었는지만 구분해도 찾을 수 있다.
public class P3T {
    public int solution(int s, int e){
        int[][] ch = new int[2][200001]; //이게 더 빠름
        Queue<Integer> Q = new LinkedList<>();
        ch[0][s] = 1;
        Q.offer(s);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            L++;
            for(int i = 0; i < len; i++){
                int x = Q.poll();
                for(int nx : new int[]{x-1, x+1, x*2}){
                    if(nx>= 0 && nx<=200000 && ch[L%2][nx]==0){
                        ch[L%2][nx] = 1;
                        Q.offer(nx);
                    }
                }
            }e = e+L;
            if(e>200000) return -1;
            if(ch[L%2][e]==1) return L;
        }
        return -1;
    }

    public static void main(String[] args){
        P3T T = new P3T();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}
