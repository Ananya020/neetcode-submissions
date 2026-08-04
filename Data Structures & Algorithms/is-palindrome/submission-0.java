class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder  newStr = new StringBuilder();
        for(char c: s.toCharArray()){
            if (Character.isLetterOrDigit(c)){
                newStr.append(Character.toLowerCase(c));
            }
        }
        String newwStr = newStr.toString();
        String revstr = newStr.reverse().toString();
        return revstr.equals(newwStr);
    }
}
