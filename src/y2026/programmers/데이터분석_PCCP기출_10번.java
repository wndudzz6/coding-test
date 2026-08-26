package y2026.programmers;

import java.util.*;

public class 데이터분석_PCCP기출_10번 {

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        HashMap<String, Integer> index = new  HashMap<>();
        index.put("code", 0);
        index.put("date", 1);
        index.put("maximum", 2);
        index.put("remain", 3);

        int extIndex = index.get(ext);
        int sortIndex = index.get(sort_by);

        ArrayList<int[]> list = new ArrayList<>();
        for(int[] x : data){
            if(x[extIndex] < val_ext) {
                list.add(x);
            }
        }
        list.sort((a,b) -> Integer.compare(a[sortIndex], b[sortIndex]));

        return list.toArray(new int[list.size()][]);

    }
}


