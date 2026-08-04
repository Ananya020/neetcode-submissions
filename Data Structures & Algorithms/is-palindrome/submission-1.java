class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder std = new StringBuilder();
        for (char c: s.toCharArray()){
            if (alphaNum(c)){
                std.append(Character.toLowerCase(c));
            }
        }
        String str = std.toString();
        int left = 0, right = str.length() -1;
        while(left<right){
            if (str.charAt(left)!= str.charAt(right)) return false;
            left++; 
            right--;
        }
        return true;
    }

    public boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }
}
