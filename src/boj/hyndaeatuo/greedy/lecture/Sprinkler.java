package boj.hyndaeatuo.greedy.lecture;

public class Sprinkler {
    public int solution(int n, int[] nums){
        int answer = 0;
        //0~n 까지니까 n+1
        int[][] line = new int[n+1][2];
        for(int i = 0; i<=n; i++){
            int s = i-nums[i];
            int e = i+nums[i];
            if(s<0) s = 0;
            if(e>n) e = n;
            line[i][0] = s;
            line[i][1] = e;
        }

        //언제 갱신할건가? 시작점이 같으면 교체 달라지면 추가?
        int cs = 0; int ce = 0; int i = 0;
        while(i<line.length){
            while(i<line.length && line[i][0] <= cs){
                ce = Math.max(ce, line[i][1]);
                i++;
            }
            answer++;
            if(ce == n) return answer;
            if(cs == ce) return -1;

            cs = ce;
        }

        return answer;
    }

    public static void main(String[] args){
        Sprinkler T = new Sprinkler();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}
