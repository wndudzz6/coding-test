package boj.hyndaeatuo.binary;

import java.util.Arrays;
import java.util.Scanner;

//기타 레슨
public class P2343 {
    static int can(int cap, int[] lecture){
        int cnt = 1;
        int sum = 0;
        for(int x : lecture){
            if(sum+ x>cap){
                cnt++;
                sum = x;
            }else{
                sum+=x;
            }
        }
        return cnt;
    }

    static int solution(int n, int m, int[] lecture){
        int answer = 0;
        int lt = Arrays.stream(lecture).max().getAsInt();
        int rt = Arrays.stream(lecture).sum();
        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(can(mid, lecture) <=m){
                answer = mid;
                rt = mid-1;
            }else{
                lt = mid+1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] lecture = new int[n];
        for(int i = 0; i<n; i++){
            lecture[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution(n, m, lecture));

    }
}
