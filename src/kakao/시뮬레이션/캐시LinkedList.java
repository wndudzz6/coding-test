package kakao.시뮬레이션;

import java.util.LinkedList;

public class 캐시LinkedList {

    static int solution(int cacheSize, String[] cities){
        int answer = 0;
        if(cacheSize == 0) return cities.length * 5;
        LinkedList<String> cache = new LinkedList<>();

        for(String city : cities){
            city = city.toLowerCase();

            if(cache.contains(city)){
                cache.remove(city);
                cache.add(city);
                answer++; //hit
            }else{ //miss
                if(cache.size() >= cacheSize){
                    cache.remove(0);
                }
                cache.add(city);
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
