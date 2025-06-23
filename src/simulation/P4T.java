package simulation;

import java.util.Arrays;

//왼쪽 아래 1,1 시작 -> 내가 아는 배열을 90도로 돌려서 만든다
//문제좌표계 != 배열 좌표계 (문제좌표계에서 90도 회전)
//x의 범위, y의 범위를 어떻게 잡아야하는가? -회전했으니까 세로범위가 가로 범위고 가로 범위가 세로 범위다.
//x범위 0~c-1(행의 개수, 즉 세로범위) y범위(열의 개수, 즉 가로 범위)
public class P4T {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public int[] solution(int c, int r, int k){
        int[] answer = new int[2];
        if(k>c*r) return new int[] {0,0};
        int[][] board = new int[c][r];
        int x = 0; int y = 0; int d = 0; int cnt = 1;
        while(cnt<k){ //방향을 바꾸거나 앉히거나
            int nx = x+dx[d];
            int ny = y+dy[d];
            if(nx<0 || nx>= c || ny <0 || ny>= r || board[nx][ny] > 0){
                d = (d+1)%4;
                continue;
            }
            board[x][y] = cnt; //누가 앉았나
            cnt++;
            x = nx;
            y = ny;
        }
        answer[0] = x+1;
        answer[1] = y+1;
        return answer;
    }

    public static void main(String[] args){
        P4T T = new P4T();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
