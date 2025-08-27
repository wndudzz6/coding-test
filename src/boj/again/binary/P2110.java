package boj.again.binary;
import java.util.Arrays;
import java.util.Scanner;

//공유기 설치
public class P2110 {

    static int can(long dist, long[] home){
        int cnt = 1;
        long pos = home[0];
        for(long x : home){
            if(x-pos >= dist){
                cnt++;
                pos = x;
            }
        }
        return cnt;
    }

    static long solution(int n, int c, long[] home){
        Arrays.sort(home);
        long answer = 0;
        long lt = 1;
        long rt = home[n-1];

        while(lt<=rt){
            long mid = lt+(rt-lt)/2;
            if(can(mid,  home) >= c){
                answer = mid;
                lt = mid+1;
            }else{
                rt = mid-1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //집 개수
        int c = sc.nextInt(); //공유기 개수
        long[] home = new long[n];
        for(int i = 0; i<n; i++){
            home[i] = sc.nextInt();
        }
        sc.close();

        System.out.println(solution(n, c, home));
    }
}