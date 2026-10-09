class Solution {
    public String simplifyPath(String path) {

        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();

        for(String part : components){
            if(part.equals("") || part.equals(".")){
                continue;
            } else if(part.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(part);
            }
        }
        return "/" + String.join("/", stack);
    }
}