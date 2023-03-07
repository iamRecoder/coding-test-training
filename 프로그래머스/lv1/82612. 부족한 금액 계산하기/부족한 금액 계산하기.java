class Solution {
    public long solution(int price, int money, int count) {
        long need =  ((long)price*count*(count+1)/2) - money;
        return need > 0 ? need : 0;
    }
}