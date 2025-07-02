package sortingNthingking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//5. 모임 장소
//완전 탐색 접근 & BFS(레벨은 while문 단위에서 증가, ch배열 첫 장소 체크 잊지말기)
public class P5 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int distBfs(Point s, Point e, int[][] board) {
        Queue<Point> q = new LinkedList<>();
        int n = board.length;
        int[][] ch = new int[n][n];
        int dist = 0;
        q.offer(s);
        ch[s.x][s.y] = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point p = q.poll();
                if(p.x == e.x && p.y == e.y) {
                    return dist;
                }
                for (int k = 0; k < 4; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];
                    if(nx>= 0 && nx<n && ny>= 0 && ny<n && ch[nx][ny]==0){
                        ch[nx][ny] = 1;
                        q.add(new Point(nx,ny));
                    };
                }
            }
            dist++;
        }
        return n*n;
    }

    public int solution(int[][] board){
        int answer=Integer.MAX_VALUE;
        int n = board.length;
        int[][] dist = new int[n][n];
        ArrayList<Point> student = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                    student.add(new Point(i,j));
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int sum = 0;
                for(Point p : student){
                    sum += distBfs(p, new Point(i, j), board);
                }
                answer = Math.min(answer,sum);
            }
        }

        return answer;
    }

    public static void main(String[] args){
        P5 T = new P5();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}
