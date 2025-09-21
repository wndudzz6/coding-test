package kakao.시뮬레이션;

import java.util.Arrays;

public class 프렌즈4블록 {

    static int solution(int m, int n, String[] board){
        int answer = 0;
        char[][] B = new char[m][n];
        for(int i = 0; i<m; i++) B[i] = board[i].toCharArray();
        boolean[][] mark = new boolean[m][n];

        while(true){
            for(boolean[] x : mark) Arrays.fill(x, false);

            //4개
            for(int i = 0; i<m-1; i++){
                for(int j = 0; j<n-1; j++){
                    char x = B[i][j];
                    if(x != ' ' && x == B[i][j+1] && x == B[i+1][j] && x == B[i+1][j+1]){
                        mark[i][j] = true;
                        mark[i][j+1] = true;
                        mark[i+1][j] = true;
                        mark[i+1][j+1] = true;
                    }
                }
            }

            int remove = 0;
            for(int i = 0; i<m; i++){
                for(int j = 0; j<n; j++){
                    if(mark[i][j]){
                        remove++;
                        B[i][j] = ' ';
                    }
                }
            }
            answer += remove;
            if(remove == 0) break;


            for(int col = 0; col < n; col++){
                int write = m - 1;
                for(int row = m-1; row >= 0; row--){
                    if(B[row][col] != ' '){
                        if(row != write){
                            B[write][col] = B[row][col];
                            B[row][col] = ' ';
                        }
                        write--;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int m = 4, n = 5;
        String[] board = {
                "CCBDE",
                "AAADE",
                "AAABF",
                "CCBBF"
        };

        System.out.println(solution(m, n, board));
    }
}
