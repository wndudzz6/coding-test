package boj.hyndaeatuo.graph;

import java.util.Arrays;
import java.util.Scanner;

//단어 수학 ~ 위상정렬로 풀라다가 조짐
//좀 바로 이해하기 어려움 다시 풀기
public class P1339 {

    static void solution(int n, String[] words){
        int[] arr = new int[26];
        for(int i = 0; i<n; i++){
            int temp = (int)Math.pow(10, words[i].length()-1);
            for(int j = 0; j<words[i].length(); j++){
                arr[(int)(words[i].charAt(j) - 'A')] += temp;
                temp/=10;
            }
        }
        Arrays.sort(arr);
        int index = 9;
        int sum = 0;
        for(int i = arr.length-1; i>=0; i--){
            if(arr[i] == 0) break;
            sum+= arr[i] * index;
            index--;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] words = new String[n];
        for(int i = 0; i<n; i++){
            words[i] = sc.nextLine();
        }
        sc.close();
        solution(n, words);
    }
}
