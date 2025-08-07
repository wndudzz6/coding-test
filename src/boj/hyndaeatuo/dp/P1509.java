package boj.hyndaeatuo.dp;

import java.util.Arrays;
import java.util.Scanner;

//팰린드롬 분할
public class P1509 {
    static String x;
    static int solution(){
        int n = x.length();
        int[] dp = new int[n]; //0~i까지의 최소 분할 수
        boolean[][] isPalindrome = new boolean[n][n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                isPalindrome[i][j] = palindrome(i,j);
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<= i; j++){
                //팰린드롬일 때만
                if(isPalindrome[j][i]){
                    if(j==0) dp[i] = 1;
                    else dp[i] = Math.min(dp[i], dp[j-1]+1);
                }
            }
        }
        return dp[n-1];
    }

    static boolean palindrome(int lt, int rt){
        if(lt == rt) return true;
        while(lt<rt){
            if(x.charAt(lt++) != x.charAt(rt--)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x = sc.nextLine();
        sc.close();
        System.out.println(solution());
    }
}
