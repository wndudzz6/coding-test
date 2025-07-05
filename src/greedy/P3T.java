package greedy;

import java.util.Arrays;

public class P3T {
    public int solution(int n, int[] nums){
        int answer = 0;
        int[][] line = new int[nums.length+1][2];
        for(int i = 0; i<=n; i++){
            line[i][0] = Math.max(0, i-nums[i]);
            line[i][1] = Math.min(n, i+nums[i]);
        }
        Arrays.sort(line, (a,b)-> a[0]-b[0]);
        int start = 0, end = 0, i=0;
        while(i<line.length){
            //1단계 : 현재 커버 가능한 구간 내에서 가장 멀리 갈 수 있는 쿨러 찾기
            //정렬만 믿고 덮어쓰기하면 그리디가 안됨
            while(i<line.length && line[i][0] <= start){
                end = Math.max(end, line[i][1]);
                i++;
            }
            //2단계: 스프링쿨러 하나 선택 완료
            answer++;

            //3단계: 전부 덮었는지 확인
            if(end==n) return answer;

            //4단계: 더 이상 진행 불가능한 경우 (공백 발생)
            if(start == end) return -1;

            //5단계: 커버 범위를 다음으로 확장
            start= end;
        }
        return answer;
    }

    public static void main(String[] args){
        P3T T= new P3T();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}
