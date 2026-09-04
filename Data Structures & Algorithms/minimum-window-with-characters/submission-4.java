class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> count = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for (char c : t.toCharArray()){
            count.put(c,count.getOrDefault(c,0)+1);
        }
        //set have(stores the total count of characters that are in both t and s),l=0;
        int have =0;int l=0;
        //set res[]={-1,-1} , reslen= Integer.max_value , need = count.size();
        int [] res = {-1,-1}; int resLen =  Integer.MAX_VALUE; int need = count.size();
        //for every character starting from r=0 to r<s.length():
        for (int r=0;r<s.length();r++){
            char c = s.charAt(r);
            //Add the current character and its count in the window;
            if(count.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                //if this character is in count and its frequency is same in both count and window:
                 if(window.get(c).equals(count.get(c))){
                have++;
            }
            }
            
            
           
            //while have == need:(window is valid if have == need=>we have find all the characters needed in substring):
            while(have==need){
                //check if current window length is less than reslen:
                //if yes then set reslen to r-l+1(curr window length),res[0] to l and res[1] to r
                if((r-l+1) < resLen){
                    resLen = r-l+1;
                    res[0]=l;
                    res[1]=r;
                }
                //remove the leftmost character by reducing its count in the map to check if the lengtht can be reduced further
                if(count.containsKey(s.charAt(l))){
                    window.put(s.charAt(l),window.get((s.charAt(l)))-1);
                     //check if this character is required and if its count is less than the required:
                      if( window.get(s.charAt(l)) < count.get(s.charAt(l))){
                    //decrement have
                    have--;
                }
                }
                l++;//to move to the next character on left
            }
        }
        //return the length of the substring
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0],res[1]+1);
        
    }
}
