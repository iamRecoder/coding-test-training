class Solution {
    public String solution(int n) {
        String answer = "";
        for(int i=0; i<n; i++){
            String str = (i % 2 == 0) ? "수" : "박";
            answer += str;
        }
        return answer;
    }
}