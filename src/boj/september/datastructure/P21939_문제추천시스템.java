package boj.september.datastructure;

import java.util.*;

public class P21939_문제추천시스템 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //난이도 -> 그 난이도의 문제번호(오름차)
        TreeMap<Integer, TreeSet<Integer>> difToProblems = new TreeMap<>();
        //문제 번호 -> 난이도
        Map<Integer, Integer> problemToDif = new HashMap<>();

        for(int i = 0; i<n; i++){
            int p = sc.nextInt();
            int l = sc.nextInt();

            problemToDif.put(p,l);
            difToProblems.computeIfAbsent(l, k->new TreeSet<>()).add(p);
        }

        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<m; i++){
            String cmd = sc.next();

            if(cmd.equals("add")){
                int p = sc.nextInt();
                int l = sc.nextInt();

                //기존에 존재하던 문제라면 이전 난이도 그룹에서 제거
                Integer old = problemToDif.get(p);
                if(old != null){
                    TreeSet<Integer> set = difToProblems.get(old);
                    if(set != null){
                        set.remove(p);
                        if(set.isEmpty()) difToProblems.remove(old);
                    }
                }

                problemToDif.put(p,l);
                difToProblems.computeIfAbsent(l, k->new TreeSet<>()).add(p);
            }else if(cmd.equals("recommend")){
                int x = sc.nextInt();
                if(x == 1){
                    int maxDif = difToProblems.lastKey();
                    int p = difToProblems.get(maxDif).last();
                    sb.append(p).append("\n");
                }else{ //x==-1
                    int minDif = difToProblems.firstKey();
                    int p = difToProblems.get(minDif).first();
                    sb.append(p).append("\n");
                }
            }else if(cmd.equals("solved")){
                int p = sc.nextInt();
                Integer l = problemToDif.remove(p); //매핑부터 제거
                if(l != null){
                    TreeSet<Integer> set = difToProblems.get(l);
                    if(set != null){
                        set.remove(p);
                        if(set.isEmpty()) difToProblems.remove(l);
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}
