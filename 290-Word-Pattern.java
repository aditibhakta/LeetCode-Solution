class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if(pattern.length() != words.length){
            return false;
        }
        HashMap<Character, String> hm = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            boolean containsKey = hm.containsKey(ch);
            if(hm.containsValue(words[i]) && !containsKey){
                return false;
            } 
            if(containsKey && !hm.get(ch).equals(words[i])){
                return false;
            }
            else{
                hm.put(ch, words[i]);
            }
        }
        return true;
    }
}