class Solution {
    public String minWindow(String s, String t) {
        int matched = 0, required = 0;
        char[] targetFreq = new char['z'+1], currWindowFreq = new char['z'+1];
        for(int i=0; i < t.length(); i++){
            char ch = t.charAt(i);
            if (targetFreq[ch] == 0){
                ++required;
            }

            targetFreq[ch]++;
        }

        int[] shortestWindow = new int[] {0, s.length()};
        char ch = '\0';
        for(int left=0, right=0; right < s.length(); right++){
            ch = s.charAt(right);
            currWindowFreq[ch]++;
            if (targetFreq[ch] > 0 && currWindowFreq[ch] == targetFreq[ch]) {
                ++matched;
            }

            // if we got all matched, shrink until we violate the condition
            while(matched >= required) {
                int currLen = right-left+1;
                if (currLen < (shortestWindow[1]-shortestWindow[0]+1) ) {
                    shortestWindow[0] = left;
                    shortestWindow[1] = right;
                } 
                ch = s.charAt(left);
                currWindowFreq[ch]--;
                if (targetFreq[ch] > 0 && currWindowFreq[ch] < targetFreq[ch]) {
                    --matched;
                }
                
                ++left;
            }
        }
        
        if (shortestWindow[1] == s.length()){
            return "";
        }
        return s.substring(shortestWindow[0], shortestWindow[1]+1);
    }
}
