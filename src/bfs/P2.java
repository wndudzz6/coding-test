package bfs;

import java.util.LinkedList;
import java.util.Queue;

//2. 집으로 이동
//체크배열에서 앞으로 왔는지 뒤로 왔는지를 체크해야 한다.
public class P2 {
    public int solution(int[] pool, int a, int b, int home){
        int answer = -1;
        int[] jump = {a, -b};
        Queue<Integer> Q = new LinkedList<>();
        int[][] ch = new int[10001][2];
        Q.offer(0);
        ch[0][0] = 1;
        ch[0][1] = 1;
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0; i < len; i++){
                int x = Q.poll();
                for(int j = 0; j<pool.length; j++){
                    if(x == pool[j]) continue;
                }
                if(x == home) return L;
                int ax = x+jump[0];
                int bx = x+jump[1];
                if(ax <= home && ch[ax][0] == 0){
                    ch[ax][0] = 1;
                    Q.offer(ax);
                }
                if(bx>=0 &&bx <= home && ch[bx][1] == 0 && ch[x][1]==0){
                    ch[bx][1] = 1;
                    Q.offer(bx);
                }
            }L++;
        }

        return answer;
    }

    public static void main(String[] args){
        P2 T = new P2();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}
