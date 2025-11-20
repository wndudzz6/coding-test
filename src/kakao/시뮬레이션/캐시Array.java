package kakao.시뮬레이션;

import java.util.*;

public class 캐시Array {
    static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int ciFull = cacheSize-1;

        if(cacheSize == 0) return cities.length * 5; //까먹지말기 ㅠㅠ

        String[] cache = new String[cacheSize]; //0based

        for(int i = 0; i<cities.length; i++) {
            String cur = cities[i].toLowerCase();
            int hitIndex = -1;
            for (int j = 0; j < cacheSize; j++) {
                if (cache[j] != null && cache[j].equals(cur)) {
                    hitIndex = j;
                    answer++; //hit

                    if (hitIndex != ciFull) {
                        for (int k = hitIndex + 1; k <= ciFull; k++) {
                            cache[k - 1] = cache[k];
                        }
                        cache[ciFull] = cur;
                    }
                    break; //일단 hit했으니까 break. 필수
                }
            }

            if (hitIndex == -1) {
                answer += 5;
                for (int k = 1; k <= ciFull; k++) {
                    cache[k - 1] = cache[k];
                }
                cache[ciFull] = cur;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // 테스트 케이스
        int cacheSize = 3;
        String[] cities = {
                "Jeju", "Pangyo", "Seoul", "NewYork", "LA",
                "Jeju", "Pangyo", "Seoul", "NewYork", "LA"
        };
        int result = solution(cacheSize, cities);
        System.out.println("실행 결과: " + result); //50
    }
}
