package kakao.시뮬레이션;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

//Deque에서 remove(..)쓰면 중간값도 알아서 찾아서 지워준다고 함
//있는지 없는지는 Set으로 판단
public class 캐시Deque {

    static int solution(int cacheSize, String[] cities){
        if(cacheSize == 0) return cities.length * 5;
        int answer = 0;
        Deque<String> cache = new ArrayDeque<>();
        Set<String> inCache =new HashSet<>();

        for(String city : cities){
            city = city.toLowerCase();

            if(inCache.contains(city)){
                answer++;
                cache.remove(city);
                cache.offerLast(city);
            }else{
                if(cache.size() >= cacheSize){
                    String first = cache.pollFirst();
                    inCache.remove(first);
                }
                cache.offerLast(city);
                inCache.add(city);
                answer += 5;
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
