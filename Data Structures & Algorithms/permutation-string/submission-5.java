class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];
        for (int i =0; i< s1.length(); i++){
            s1Count[s1.charAt(i)-'a']++;
        }
        int l = 0;
        for (int r =0; r<s2.length(); r++){
            windowCount[s2.charAt(r)- 'a']++;

            if (r-l+1> s1.length()){
                windowCount[s2.charAt(l)-'a']--;
                l++;
            }
            if (r-l+1 == s1.length()){
                boolean same = true;
                for (int i =0; i<26; i++){
                    if (s1Count[i]!= windowCount[i]){
                        same = false;
                        break;
                    }
                }
                if (same){
                    return true;
                }
            }
        }
        return false;
    }
}
