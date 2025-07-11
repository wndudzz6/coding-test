package graph.again;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//지하철 최소 환승 횟수
public class Subway {
    public int solution(int[][] routes, int s, int e){
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        int n = routes.length;
        int[] ch = new int[n];
        for(int i = 0; i < n; i++){
            for(int x: routes[i]){
                graph.putIfAbsent(x, new HashSet<>());
                graph.get(x).add(i);
            }
        }
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0; i < len; i++){
                int now = Q.poll(); //현재 역
                //현재 노선에서 다른 역 다 톺아보고 이동
                //역으로 노선 조회
                for(int line : graph.get(now)){//line이 노선
                    if(ch[line] == 0){
                        ch[line] = 1;
                        for(int x : routes[line]){ //노선에 있는 역
                            if(x == e) return L;
                            Q.offer(x);
                        }
                    }

                }
            }L++;
        }
        return -1;

    }

    public static void main(String[] args){
        Subway T = new Subway();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}
