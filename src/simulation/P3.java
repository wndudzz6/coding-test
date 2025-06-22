package simulation;

//3. 잃어버린 강아지
public class P3 {
    static int[] dx = {0, 1, 0, -1}; //시계방향
    static int[] dy = {1, 0, -1, 0};

    public int solution(int[][] board){
        int answer = 0;
        int n = 10; int d = 3; int d2 = 3; //처음 왼쪽 ? 문제 오류
        int x = 0; int y = 0;
        int x2= 0; int y2 = 0;

        //현수,강아지 위치 초기화
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == 2){
                    x = i;
                    y = j;
                }
                if(board[i][j] == 3){
                    x2 = i;
                    y2 = j;
                }
            }
        }
        while(true){
            if(answer >= 10000) return 0;
            answer++;


            int nx = x+dx[d];
            int ny = y+dy[d];
            int nx2 = x2+dx[d2];
            int ny2 = y2+dy[d2];

            boolean flag1 = true; boolean flag2 = true;

            if(nx<0 || nx>=n || ny<0 || ny>=n || board[nx][ny] ==1){
                d = (d+1)%4;
                flag1 = false;
            }

            if(nx2<0 || nx2>=n || ny2<0 || ny2>=n || board[nx2][ny2] == 1){
                d2 = (d2+1)%4;
                flag2 = false;
            }
            if(flag1){
                x = nx;
                y = ny;
            }
            if(flag2){
                x2 = nx2;
                y2 = ny2;
            }

            if(x==x2 && y==y2) break;
        }

        return answer;
    }

    public static void main(String[] args){
        P3 T = new P3();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}
