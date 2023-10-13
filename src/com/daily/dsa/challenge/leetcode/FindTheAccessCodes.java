package src.com.daily.dsa.challenge.leetcode;

public class FindTheAccessCodes {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1,1}));
    }

    public static int solution(int[] l) {
        // Your code here
        int codes = 0;
        for (int i = 0; i < l.length - 2; i++) {
            for (int j = i+1; j < l.length - 1; j++) {
                for (int k = j+1; k < l.length; k++) {
                    if (l[j] % l[i] == 0 && l[k] % l[j] == 0){
                        codes ++;
                    }
                }
            }
        }
        return codes;
    }

    private static int getCodes(int[] l, int index, int curr, int size) {

        if (index > l.length) return 0;
        int counts = 0;
        for (int x = index; x < l.length; x++) {
            if (l[x] % curr == 0) {
                if (size == 2) {
                    return 1;
                } else {
                    index += 1;
                    counts += getCodes(l, index, l[x], size++);
                }
            } else {
                index += 1;
                counts += getCodes(l, index, curr, size);
            }
        }
        return counts;
    }
}
