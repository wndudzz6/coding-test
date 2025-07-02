package sortingNthingking.again;

import java.util.Arrays;

//P6. 멀티태스킹  ~ 뭉텅이 시간복잡도
public class TieredProcessing {
    public int solution(int[] tasks, long k) {
        int[] st = new int[tasks.length+1];
        for(int i = 1; i<=tasks.length; i++) st[i] = tasks[i-1];
        Arrays.sort(st);
        int rest = tasks.length;
        for(int i = 1; i<= st.length; i++){
            long time = ((long)rest * (st[i] - st[i-1]));
            if(time > k){
                long idx = k%rest;
                for(int j = 0, cnt =0; j<tasks.length; j++){
                    if(tasks[j] >= st[i]){ //이 조건 필수 st[i-1]까지가 뭉텅이로 처리한 작업이라서 st[i]보다 크거나 같아야 남은 작업임
                        if(cnt == idx) return j+1;
                        cnt++;
                    }
                }
            }else{
                k-=time;
                rest--;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        TieredProcessing T = new TieredProcessing();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}
