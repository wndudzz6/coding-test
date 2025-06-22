package simulation;

import java.util.Arrays;

//청소
public class P2T {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int[] solution(int[][] board, int k){
        int[] answer = new int[2];
        int cnt = 0;
        int d = 1; //(1,0)이 처음 방향
        int n = board.length;
        int x = 0; int y = 0;
        while(cnt < k){ //while 단위 : 초(청소 or 방향바꾸기)
            cnt++;
            int nx = x +dx[d];
            int ny = y +dy[d];
            if(nx<0 || nx>=n || ny<0 || ny>=n || board[nx][ny]==1){
                d = (d+1)%4;
                continue; //방향 바꾸고 while 다음 턴
            }
            x = nx;
            y = ny;
        }
        answer[0]= x;
        answer[1] = y;
        return answer;
    }

    public static void main(String[] args){
        P2T T = new P2T();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}
