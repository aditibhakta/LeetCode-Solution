class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");

        if(pattern.length() != arr.length){
            return false;
        }

        HashMap<Character, String> hm = new HashMap<>();
        Set<String> set = new HashSet<>();

        for(int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            String word = arr[i];

            if(hm.containsKey(ch)){
                if(!hm.get(ch).equals(word)){
                    return false;
                }
            }else{
                if(set.contains(word)){
                    return false;
                }else{
                    hm.put(ch, word);
                    set.add(word);
                }
            }
        }
        return true;
    }
}