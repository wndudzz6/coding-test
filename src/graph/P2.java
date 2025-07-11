package graph;

import java.util.*;

//역으로 조회하는 식으로 P1이랑 비슷하게 짰다가 틀림
//최소 환승 경로
//GPT보면서 다시 짬
//T 코드가 훨씬 낫다.
public class P2 {
    public int solution(int[][] routes, int s, int e){
        int n = routes.length;
        //역 -> 노선
        Map<Integer, ArrayList<Integer>> stationToLines = new HashMap<>();
        //노선 -> 역
        ArrayList<ArrayList<Integer>> lineToStations = new ArrayList<>();

        for(int i = 0; i<n ; i++){
            ArrayList<Integer> stations = new ArrayList<>();
            for(int station : routes[i]){
                stations.add(station);
                stationToLines.putIfAbsent(station, new ArrayList<>());
                stationToLines.get(station).add(i); //i번 노선
            }
            lineToStations.add(stations); //i번 노선에 포함된 역 목록
        }

        //BFS
        Queue<Integer> Q = new LinkedList<>();
        boolean[] visitedLine = new boolean[n]; //탑승한 노선 체크
        boolean[] visitedStation = new boolean[100001];//중복 역 방문 방지

        //출발역에 있는 노선부터 탐색
        for(int line : stationToLines.getOrDefault(s, new ArrayList<>())){
            Q.offer(line);
            visitedStation[line] = true;
        }
        visitedStation[s] = true;

        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0; i< len; i++){
                int line = Q.poll();
                for(int station : lineToStations.get(line)){
                    if(station == e) return L;
                    if(visitedStation[station]) continue;
                    visitedStation[station] = true;

                    //해당 역을 지나는 다른 노선 추가 탐색
                    for(int nextLine : stationToLines.getOrDefault(station, new ArrayList<>())){
                        if(!visitedLine[nextLine]){
                            visitedLine[nextLine] = true;
                            Q.offer(nextLine);
                        }
                    }
                }
            }
            L++;
        }

        return -1;
    }

    public static void main(String[] args){
        P2 T = new P2();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}
