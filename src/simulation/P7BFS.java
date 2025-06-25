package simulation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class P7BFS {
    static int[] dx = {0,1, 1,1, 0, -1, -1, -1}; //8방향
    static int[] dy = {1,1, 0,-1, -1,-1, 0, 1};

    static class Point{
        int x;
        int y;
        int time;
        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public int solution(int[] keypad, String password){
        int answer = 0;
        int[][] board = new int [3][3];

        Map<Integer, int[]> pos = new HashMap<>();
        int idx = 0;

        //키패드 3x3 구성 및 숫자 위치 저장
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = keypad[idx];
                pos.put(board[i][j], new int[]{i,j});
                idx++;
            }
        }


        for(int i = 1; i<password.length(); i++){
            int from = password.charAt(i-1) -'0';
            int to = password.charAt(i) -'0';

            answer += bfs(board, pos.get(from), to);
        }

        return answer;
    }

    static int bfs(int[][] board, int[] start, int target){
        boolean[][] visited = new boolean[3][3];
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()){
            Point cur = q.poll();
            if(board[cur.x][cur.y] == target){
                return cur.time;
            }

            for(int d= 0; d<8; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(nx>=0 && ny >= 0 && nx < 3 && ny < 3 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny, cur.time+1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        P7BFS T = new P7BFS();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
