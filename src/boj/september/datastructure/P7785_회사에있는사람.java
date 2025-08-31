package boj.september.datastructure;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class P7785_회사에있는사람 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<String> tset = new TreeSet<>(Comparator.reverseOrder());
        sc.nextLine();
        for(int i = 0; i<n; i++){
            String x = sc.nextLine();
            String name = x.split(" ")[0];
            String state = x.split(" ")[1];

            if(state.equals("enter")){
                tset.add(name);
            }else{
                if(tset.contains(name)){
                    tset.remove(name);
                }
            }
        }

        for(String x : tset){
            System.out.println(x);
        }
    }
}
