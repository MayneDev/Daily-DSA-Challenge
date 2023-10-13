package src.com.daily.dsa.challenge.leetcode;

public class SmallestRectangleEnclosingBlackPixels {

    public static void main(String[] args) {
        System.out.println(minArea(new int[][]{
                        {0, 1, 0, 0},
                        {0, 1, 1, 0},
                        {0, 1, 0, 0}},
                0, 2));
    }

    public static int minArea(int[][] image, int x, int y) {
        if (image.length == 0) return 0;

        int top = 0;
        int bottom = image.length - 1;
        int right = image[0].length - 1;
        int left = 0;

        //Get left
        int high = y;
        while (left < high) {
            int mid = left + (high - left) / 2;
            if (isBlackCol(image, mid)) {
                high = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);

        //Get right
        int low = y;
        while (low < right) {
            int mid = low + (right - low) / 2;
            if (isBlackCol(image, mid)) {
                low = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);

        //Get top
        int ref = x;
        while (top < ref) {
            int mid = top + (ref - top) / 2;
            if (isBlackRow(image, mid)) {
                ref = mid - 1;
            } else {
                top = mid + 1;
            }
        }

        System.out.println(top);

        //Get bottom
        ref = x;
        while (ref < bottom) {
            int mid = ref + (bottom - ref) / 2;
            if (isBlackRow(image, mid)) {
                ref = mid + 1;
            } else {
                bottom = mid - 1;
            }
        }


        System.out.println(bottom);

        return (right - left + 1) * (bottom - top + 1);

    }

    private static boolean isBlackRow(int[][] image, int i) {
        for (int[] ints : image) {
            if (ints[i] == 1) return true;
        }
        return false;
    }

    private static boolean isBlackCol(int[][] image, int i) {
        for (int x = 0; x < image[0].length; x++) {
            if (image[i][x] == 1) return true;
        }
        return false;
    }
}
