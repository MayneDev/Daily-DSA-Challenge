package src.com.daily.dsa.challenge.leetcode;

public class FindTheDuplicateNumber {

    //Use linked list approch
    //value at index is pointer to the next
    //Use fast slow pointer approach
    //intersection point is equidistant to duplicate from the head of the list
    //use 2 slow pointers after to get the
    public int findDuplicate(int[] nums) {
        //[1,3,4,2,2]

        //Get the intersection point
        int slow = 0;
        int fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(fast == slow) break;
        }

        //Use 2 slow pointers to get the duplicate
        int slow2 = 0;
        while(true){
            slow = nums[slow];
            slow2 = nums[slow2];
            if(slow == slow2) break;
        }

        return slow;
    }
}
