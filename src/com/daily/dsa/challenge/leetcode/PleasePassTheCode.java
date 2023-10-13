package src.com.daily.dsa.challenge.leetcode;

public class PleasePassTheCode {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 4, 1}));
        System.out.println(solution(new int[]{3, 1, 4, 1, 5, 9}));
    }

    public static int solution(int[] l) {
        return result(l, 0);
    }

    private static int result(int[] options, int current) {
        if (options.length == 0) {
            return current % 3 == 0 ? current : 0;
        }
        int maxVal = 0;
        for (int i = 0; i < options.length; i++) {
            int option = options[i];
            int[] temp = removeElement(options, i);
            maxVal = Math.max(maxVal, Math.max(result(temp, current), result(temp, (current * 10) + option)));
        }
        return maxVal;
    }

    private static int[] removeElement(int[] array, int index) {
        int[] newArray = new int[array.length - 1];
        for (int x = 0; x < array.length; x++) {
            if (x < index) {
                newArray[x] = array[x];
            } else if (x > index) {
                newArray[x - 1] = array[x];
            }
        }
        return newArray;
    }
}
