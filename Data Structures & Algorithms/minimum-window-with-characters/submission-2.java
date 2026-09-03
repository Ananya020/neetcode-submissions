class Solution {
    public String minWindow(String s, String t) {
        int sn = s.length();
        int tn = t.length();

        if (sn < tn) {
            return "";
        }

        Map<Character, Integer> mpp = new HashMap<>();

        for (int i = 0; i < tn; i++) {
            char temp = t.charAt(i);
            mpp.put(temp, mpp.getOrDefault(temp, 0) + 1);
        }

        int r = 0;
        int l = 0;
        int count = 0;
        int res = Integer.MAX_VALUE;
        int minl = 0;
        int minr = -1;

        while (r < sn) {
            char valr = s.charAt(r);

            if (mpp.containsKey(valr)) {
                mpp.put(valr, mpp.get(valr) - 1);
                if (mpp.get(valr) == 0) {
                    count++;
                }
            }

            while (count == mpp.size()) {
                if (res > (r - l + 1)) {
                    res = (r - l + 1);
                    minl = l;
                    minr = r;
                }
                char val = s.charAt(l);
                if (mpp.containsKey(val)) {
                    if (mpp.get(val) == 0) {
                        count--;
                    }
                    mpp.put(val, mpp.get(val) + 1);
                }
                l++;
            }

            r++;
        }
        return minr == -1 ? "" : s.substring(minl, minr + 1);
    }
}
