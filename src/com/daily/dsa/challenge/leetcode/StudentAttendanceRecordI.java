package src.com.daily.dsa.challenge.leetcode;

public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int absent = 0;
        int l = 0, r = 0;
        for (int x = 0; x < s.length(); x++) {
            if (s.charAt(x) == 'A') {
                absent++;
            }

            if (absent > 1 || x >= 2 && s.substring(x - 2, x + 1).equals("LLL")) {
                return false;
            }
        }

        return true;
    }
}
