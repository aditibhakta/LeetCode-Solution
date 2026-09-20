class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> h = new HashMap<Character, Integer>();
        h.put('M',1000);
        h.put('D',500);
        h.put('C',100);
        h.put('L',50);
        h.put('X',10);
        h.put('V',5);
        h.put('I',1);

        int res = 0;

        for(int i = 0; i < s.length(); i++){
            int curr = h.get(s.charAt(i));
            if(i + 1 < s.length() && curr < h.get(s.charAt(i + 1))){
                res -= curr;
            } else {
                res += curr;
            }
        }
        return res;
    }
}