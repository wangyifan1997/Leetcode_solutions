import java.util.Random;

class Solution {
    public int strStr(String haystack, String needle) {
        Random rand = new Random();
        if (rand.nextInt(1000) > 500) {
            return strStrBruteForce(haystack, needle);
        } else {
            return strStrKMP(haystack, needle);
        }
    }

    public int strStrBruteForce(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int hpos = i;
                int npos = 0;
                while (npos < needle.length()) {
                    if (hpos == haystack.length()) return -1;
                    if (haystack.charAt(hpos) != needle.charAt(npos)) {
                        break;
                    }
                    hpos++;
                    npos++;
                }
                if (npos == needle.length()) return i;
            }
        }
        return -1;
    }

    public int strStrKMP(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }

        if (needle.length() == 0) {
            return 0;
        }

        // generate the kmp array
        int[] kmp = new int[needle.length()];
        int i = 1;
        int j = 0;
        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
                kmp[i] = j;
                i++;
            } else {
                if (j != 0) {
                    j = kmp[j - 1];
                } else {
                    i++;
                }
            }
        }

        int hptr = 0;
        int nptr = 0;
        while (hptr < haystack.length()) {
            if (haystack.charAt(hptr) == needle.charAt(nptr)) {
                nptr++;
                hptr++;
            } else {
                if (nptr != 0) {
                    nptr = kmp[nptr - 1];
                } else {
                    hptr++;
                }
            }
            if (nptr == needle.length()) return hptr - nptr;
        }
        return -1;
    }
}