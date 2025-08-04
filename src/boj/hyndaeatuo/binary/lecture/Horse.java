package boj.hyndaeatuo.binary.lecture;

import java.util.Arrays;
import java.util.Scanner;

public class Horse {

    static int can(int dist, int[]horse){
        int cnt = 1;
        //dist이상 말을 배치
        int lastPos = horse[0];
        for(int i = 1; i<horse.length; i++){
            if(horse[i] - lastPos >= dist){
                cnt++;
                lastPos = horse[i];
            }
        }
        return cnt;
    }

    static int solution(int n, int c, int[] horse){
        int answer = 0;
        int lt = 0;
        int rt= n;
        Arrays.sort(horse);
        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(can(mid, horse) >= c){
                //적절
                answer = mid;
                lt = mid+1; //dist를 늘려야함
            }else{
                rt = mid-1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] horse = new int[n];
        for(int i = 0; i<n; i++){
            horse[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution(n, c, horse));
    }
}
