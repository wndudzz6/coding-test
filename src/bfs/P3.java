package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class P3 {
    public int solution(int s, int e){
        int answer = -1;
        Queue<Integer> Q = new LinkedList<>();
        int[] ch = new int[200001];
        int L = 0;
        Q.add(s);
        ch[s] = 1;
        int calfDis = 1;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0; i < len; i++){
                int x = Q.poll();
                if(x == e) return L;
                int ax = x+1;
                int bx = x-1;
                int cx = x*2;
                if(ax<= 200000&& ch[ax]== 0){
                    ch[ax] = 1;
                    Q.add(ax);
                }
                if(bx>=0 && bx<=e && ch[bx]== 0){
                    ch[bx] = 1;
                    Q.add(bx);
                }
                if(cx<=200000&& ch[cx]== 0){
                    ch[cx] = 1;
                    Q.add(cx);
                }
            }
            e += calfDis;
            calfDis++;
            L++;
        }


        return answer;
    }

    public static void main(String[] args){
        P3 T = new P3();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}
