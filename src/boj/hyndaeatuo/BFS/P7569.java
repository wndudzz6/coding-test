package boj.hyndaeatuo.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//토마토 ~ 위 아래 방향도 영향을 끼치는데 대충 보고 구현함
public class P7569 {
    static int[][] box;
    static int[][] dist;
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    //지금 넣은 방향에서 막힐 때까지 탐색
    static void BFS(int x, int y){
        Queue<int[]> Q = new LinkedList<>();
        dist[x][y] = 0;
        Q.offer(new int[] {x, y});
        int L = 1; //처음에 익고나서 추가하니까 1부터

        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0; i<len; i++){
                int[] cur = Q.poll();
                for(int k = 0; k<4; k++){
                    int nx = cur[0]+dx[k];
                    int ny = cur[1]+dy[k];

                    if(nx>=0 && nx<n && ny>=0 && ny<m){
                        if(box[nx][ny] == 0 && dist[nx][ny] > L ){
                            box[nx][ny] = 1;
                            dist[nx][ny] =L;

                            Q.offer(new int[]{nx,ny});
                        }
                    }
                }
            }L++;
        }

    }

    static int solution(){
        dist = new int[n][m];
        for(int[] x : dist) Arrays.fill(x,Integer.MAX_VALUE);
        boolean flag = true;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(box[i][j] == 0){
                    flag = false; //처음에 익지않은 토마토가 있음
                }
                if(box[i][j] == 1){
                    BFS(i,j);
                }
            }
        }
        if(flag) return 0;

        int max = 0;
        for(int i = 0; i<n; i++){
            for(int j= 0; j<m; j++){
                if(box[i][j] == 0 ) return -1; //안 익은 토마토가 있음
                if(dist[i][j] > max) max = dist[i][j];
            }
        }
        return max;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        n = sc.nextInt();
        m = sc.nextInt();
        int h = sc.nextInt();//상자 수
        box= new int[n][m];
        for(int i = 0; i<h; i++){
            for(int j = 0; j<n; j++){
                for(int k = 0; k<m; k++){
                    box[j][k] = sc.nextInt();
                }
                int x = solution();
                if(x == -1) { //한 박스라도 다 익을 수 없다면 -1
                    answer = -1;
                    break;
                }
                else{
                    answer = Math.max(x, answer);
                }

            }
        }sc.close();
        System.out.println(answer);
    }

}
