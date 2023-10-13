package src.com.daily.dsa.challenge.leetcode;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching().isMatch("aba","aba"));
        System.out.println(new RegularExpressionMatching().isMatch("aba","a*a"));
        System.out.println(new RegularExpressionMatching().isMatch("aba","a.a"));
        System.out.println(new RegularExpressionMatching().isMatch("a","ab*"));
        System.out.println(new RegularExpressionMatching().isMatch("aab","c*a*b"));
    }
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    public boolean isMatch(String s, String p, int sIndex, int pIndex) {
        if (pIndex == p.length() && sIndex == s.length() || (sIndex == s.length() && pIndex == p.length() - 1 && p.charAt(pIndex) == '*')) {
            return true;
        } else if (pIndex == p.length() || sIndex == s.length()) {
            return false;
        }

        char sChar = s.charAt(sIndex);
        char pChar = p.charAt(pIndex);

        if (sChar == pChar || pChar == '.') {
            return isMatch(s, p, sIndex + 1, pIndex + 1);
        }else if (pChar == '*'){
            return isMatch(s,p, sIndex,pIndex+1) ||
                    (p.charAt(pIndex - 1) == sChar || p.charAt(pIndex - 1) == '.')  && isMatch(s,p, sIndex + 1,pIndex)
                    || isMatch(s,p,sIndex - 1,pIndex+1);
        }else{
            return isMatch(s, p, sIndex, pIndex + 1);
        }
      //  return false;
    }

}
