package src.com.daily.dsa.challenge.leetcode;

public class SparseVector {
    int[] vec1;

    // Constructor for sparseVector.
    SparseVector(int[] nums) {
        // Write your code here.
        vec1 = nums;
    }

    // Function to compute dot Product.
    int dotProduct(SparseVector vec) {
        // Write your code here.
        int res = 0;
        for (int x = 0; x < vec.vec1.length; x++) {
            res += vec1[x] * vec.vec1[x];
        }
        return res;
    }
}
