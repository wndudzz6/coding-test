package boj.hyndaeatuo.simulation;

import java.util.Scanner;
import java.util.Stack;

//미네랄 막대기 던지기
public class P2933 {
    static int r, c, n;
    static char[][] cave;
    static int[] h;

    //떨어지는 거
    static void change(int[] a, int[] b){
        int x1 = a[0], y1 = a[1];
        int x2 = b[0], y2 = b[1];
        char tmp = cave[x1][y1];
        cave[x1][y1] = cave[x2][y2];
        cave[x2][y2] = tmp;
    }

    static void solution(){
        boolean flag = true; //왼쪽이 true;
        for(int h : h){
            int i = r-h;
            if(flag){
                flag = false;
                for(int j= 0; j<c; j++){
                    if(cave[i][j] == 'x'){
                        cave[i][j] = '.';
                        break;
                    }
                }
            }
            else{
                for(int j = c-1; j>=0; j--){
                    flag = true;
                    if(cave[i][j] == 'x'){
                        cave[i][j] = '.';
                        flag = true;
                        break;
                    }
                }
            }
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();
        cave = new char[r][c];
        for(int i = 0; i<r; i++){
            String x = sc.nextLine();
            for(int j = 0; j<c; j++){
                cave[i][j] = x.charAt(j);
            }
        }
        n = sc.nextInt(); //막대기를 던진 횟수
        h = new int[n];
        for(int i = 0; i<n; i++){
            h[i] = sc.nextInt();
        }
        sc.close();
        solution();
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                System.out.print(cave[i][j]);
            }
            System.out.println();
        }
    }
}
