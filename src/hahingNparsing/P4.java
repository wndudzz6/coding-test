package hahingNparsing;

//음수가 있는 부분 수열 ~ 연속 부분 수열인거 까묵고 그냥 dfs로 짰다
public class P4 {
    static int cnt;

    public void dfs(int[]nums, int l, int sum , int m){
        if(l == nums.length){
            if(sum == m){
                cnt++;
                return;
            }
        }else{
            dfs(nums, l+1, sum+nums[l], m);
            dfs(nums, l+1, sum, m);
        }

    }

    public int solution(int[] nums, int m){
        cnt = 0;
        dfs(nums, 0, 0, m);
        int answer = cnt;

        return answer;
    }

    public static void main(String[] args){
        P4 T = new P4();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}
