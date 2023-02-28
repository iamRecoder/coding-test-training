class Solution {
    public long solution(int a, int b) {
        long n = (a < b) ? (b - a + 1) : (a - b + 1);
        return n * (a + b) / 2;
    }
}