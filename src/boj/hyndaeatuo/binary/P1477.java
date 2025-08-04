package boj.hyndaeatuo.binary;

import java.util.Arrays;
import java.util.Scanner;

//휴게소 세우기
public class P1477 {

    //dist보다 작게 유지하려면 휴게소가 cnt는 추가로 필요해
    static int can(int dist, int[] pos){
        int cnt = 0;
        for(int i = 1; i < pos.length; i++){
            int d = pos[i] - pos[i-1];
            cnt += (d - 1) / dist; //이거 기억하기
        }
        return cnt;
    }

    static int solution(int n, int m, int l, int[] arr){
        int answer = 0;
        int[] pos = new int[n+2]; //이게 무조건 필요 휴게소~휴게소가 아니라 끝점확인
        for(int i = 0; i<n; i++) pos[i+1] = arr[i];
        pos[0] = 0;
        pos[n+1] = l;

        int lt = 1;
        int rt = l;
        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(can(mid, pos) <= m){ //추가로 지어야하는 휴게소 개수
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
        int l = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(arr);
        System.out.println(solution(n, m, l, arr));
    }
}
