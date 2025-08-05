package boj.hyndaeatuo.greedy;

import java.util.ArrayList;
import java.util.Scanner;

//수학숙제
public class P2870 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            String s = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<s.length(); j++){
                char x = s.charAt(j);
                if(Character.isDigit(x)){
                    sb.append(x);
                }else{
                    if(sb.length()>0){
                        list.add(removeLeadingZeros(sb.toString()));
                        sb.setLength(0);
                    }
                }
            }
            if(sb.length()>0) list.add(removeLeadingZeros(sb.toString()));
        }
        list.sort((a,b)->{
            if(a.length() != b.length()) return a.length()-b.length();
            return a.compareTo(b);
        });
        for(String x : list) System.out.println(x);
    }
    static String removeLeadingZeros(String num){
        String result = num.replaceFirst("^0+", "");
        return result.isEmpty() ? "0" : result;
    }

}
