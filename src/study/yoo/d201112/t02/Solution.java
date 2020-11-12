package study.yoo.d201112.t02;

import java.util.LinkedList;


//캐시
public class Solution {

	public static void main(String[] args) {
		String[] arr = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		String[] arr1 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		String[] arr2 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		System.out.println(solution(3, arr));
		System.out.println(solution(3, arr1));
		System.out.println(solution(3, arr2));
	}
	
    static final int CACHE_HIT = 1; //CPU가 참조하고자 하는 메모리가 캐시에 존재하고 있을 경우
    static final int CACHE_MISS = 5; //CPU가 참조하고자 하는 메모리가 캐시에 존재하지 않을 때
    
    public static int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return 5 * cities.length;
        
        int answer = 0;
        
        LinkedList<String> cache = new LinkedList<>();
        
        for(int i = 0 ; i < cities.length ; ++i){
            String city = cities[i].toUpperCase();
            
            // cache hit
            //기존에 있던 페이지를 지우고 Queue의 가장 처음에 삽입
            if(cache.remove(city)){
                cache.addFirst(city);
                answer += CACHE_HIT;
            
            // cache miss
            // 캐시가 가득 찼으면 맨뒤 페이지 삭제하고 가장 앞에 새 페이지 삽입
            // 캐시에 자리가 있으면 가장 앞에 새 페이지 삽입    
            } else {
                int currentSize = cache.size();
                
                if(currentSize == cacheSize){
                    cache.pollLast();
                }
                
                cache.addFirst(city);
                answer += CACHE_MISS;
            }
        }
        return answer;
    }

}
