import java.util.*;
class Solution {
    class Food{
        int time;
        int idx;
        Food(int t, int i){
            time = t;
            idx = i;
        }
    }
    
    Comparator<Food> CompareTime = new Comparator<Food>(){
        public int compare(Food a, Food b) {
            return a.time - b.time;
        }
    };
    
    Comparator<Food> CompareIdx = new Comparator<Food>() {
        public int compare(Food a, Food b){
            return a.idx - b.idx;
        }
    };
    
    public int solution(int[] food_times, long k) {
        List<Food> foods = new LinkedList<Food>();
        int n = food_times.length;  // 남은 음식의 개수
        for(int i = 0; i < n; i++){
            foods.add(new Food(food_times[i], i+1));
        }
        foods.sort(CompareTime);
        
        int preTime = 0;
        int i = 0;
        for(Food f : foods) {
            long diff = f.time - preTime;
            if(diff != 0){
                long spend = diff * n;
                if(spend <= k) {
                    k -= spend;
                    preTime = f.time;
                }else {
                    k %= n;  // k를 남은 음식의 개수로 나눈 나머지 구하기
                    foods.subList(i, food_times.length).sort(CompareIdx);
                    return foods.get(i + (int) k ).idx;
                }
            }
            ++i;
            --n;
        }
        
        return -1;
    }
}