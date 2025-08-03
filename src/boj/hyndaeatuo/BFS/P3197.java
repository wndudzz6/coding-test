package boj.hyndaeatuo.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백조의 호수
public class P3197 {
    static int[][] days;
    static char[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, 1};
    static int day;


    static void BFS(int[] s){
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(s);
        int L = day;
        while(Q.isEmpty()){

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        board = new char[r][c];
        days = new int[r][c];
        for(int i = 0; i<r; i++){
            Arrays.fill(days[i], Integer.MAX_VALUE);
        }
        int[] swan1; int[] swan2;
        boolean flag = false;
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                char x = sc.next().charAt(0);
                board[i][j] = x;
                if(x == '.') days[i][j] = 0;
                if(x=='L'){
                    swan1 = new int[]{i, j};
                    flag = true;
                }
                if(x=='L' && flag){
                    swan2 = new int[]{i, j};
                }

            }
        }
    }
}
