package boj.hyndaeatuo.simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//마법사 상어와 비바라기 ~ 구름이 4칸짜리 한 덩어리라고 착각한 ver
//이해하는 데에만 10분 걸림 ㅎㅎ 잘못이해함 한시간은 고민하면서 짠듯
public class P21610V0 {
    static int n, m;
    static int[][] board, cmd;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};//대각선 1 3 5 7
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int solution(){
        int answer = 0;
        int[][] ch = new int[n+1][n+1];
        Queue<int[][]> cloudQ = new LinkedList<>();
        cloudQ.offer(new int[][]{{n, 1}, {n, 2},{n-1, 1}, {n-1,2}});
        for(int i = 0; i<m; i++){
            int d = cmd[i][0];
            int dis = cmd[i][1];
            int[][] cloud = cloudQ.poll();
            for(int j = 0; j<4; j++){
                int nx = cloud[j][0]+(dis * dx[d]);
                int ny = cloud[j][1]+(dis * dy[d]);
                if(nx<=0) nx =n+nx;
                if(nx>n) nx=nx-n;
                if(ny<=0) ny = n+ny;
                if(ny>n) ny = ny-n;
                board[nx][ny]++;
                //대각선 물 복사
                for(int k = 1; k<=7; k+=2){
                    int dnx = nx+dx[k];
                    int dny = ny+dy[k];
                    if (dnx > 0 && dnx <= n && dny > 0 && dny <= n) {
                        if(board[dnx][dny]>=1) board[nx][ny]++;
                    }
                }
                ch[nx][ny] = 1;

            }


        }


        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n+1][n+1];
        cmd = new int[m][2];
        //보드
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                board[i][j] = sc.nextInt();
            }
        }
        //명령
        for(int i = 0; i<m; i++){
            cmd[i][0] = sc.nextInt();
            cmd[i][1] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution());
    }
}
