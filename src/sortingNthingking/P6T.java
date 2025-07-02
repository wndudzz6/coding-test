package sortingNthingking;

import java.util.Arrays;

//뭉텅이 이해하기 어려움
public class P6T {
    public int solution(int[] tasks, long k) {
        int[] sT = new int[tasks.length+1];
        System.arraycopy(tasks, 0, sT, 1, tasks.length); //tasks의 내용 복사 sT[1]~sT[n]에 저장
        Arrays.sort(sT);
        int rest = tasks.length; //남은 작업 개수
        for(int i = 1; i<sT.length; i++){
            long time = ((long)rest * (sT[i]-sT[i-1])); //이번 계층으로 올라가는데 필요한 시간
            if(k<time){
                long idx = k%rest;
                int cnt = 0;
                for(int j = 0; j<tasks.length; j++){
                    if(tasks[j] >= sT[i]){
                        if(cnt == idx) return j+1;
                        cnt++;
                    }
                }
            }
            else{ ///다음 계층으로
                k-= time;
                rest--;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        P6T T = new P6T();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}
