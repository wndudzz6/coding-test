package simulation;

import java.util.Arrays;

//비밀번호
public class P7T {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public int solution(int[] keypad, String password) {
        int answer = 0;
        int[][] pad = new int[3][3];
        int[][] dist = new int[10][10];

        for(int i = 0 ; i<3; i++){
            for(int j = 0; j<3; j++){
                pad[i][j] = keypad[i*3+j];
            }
        }

        for(int i = 0; i<10; i++){
            Arrays.fill(dist[i], 2);
        }

        for(int i = 0; i<10; i++){
            dist[i][i] = 0; // 자기 자신 0
        }

        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                int from = pad[i][j];
                for(int k = 0; k<8; k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(nx>=0 && nx<3 && ny>=0 && ny<3){
                        int to = pad[nx][ny];
                        dist[from][to] = 1;
                    }
                }
            }
        }

        for(int i = 0; i<password.length()-1; i++){
            int from = password.charAt(i)-'0';
            int to = password.charAt(i+1)-'0';
            answer+= dist[from][to];
        }


        return answer;
    }

    public static void main(String[] args){
        P7T T = new P7T();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
