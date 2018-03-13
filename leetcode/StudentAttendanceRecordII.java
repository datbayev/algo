package leetcode;

// https://leetcode.com/problems/student-attendance-record-ii/description/
// 552. Student Attendance Record II

public class StudentAttendanceRecordII {
    public int checkRecord(int n) {
        long a0l0 = 1, a0l1 = 0, a0l2 = 0;
        long a1l0 = 0, a1l1 = 0, a1l2 = 0;

        long mod = 1000000007;

        for (int i = 0; i < n; i++) {
            long next_a0l0 = (a0l0 + a0l1 + a0l2) % mod;
            long next_a0l1 = a0l0;
            long next_a0l2 = a0l1;

            long next_a1l0 = (a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % mod;
            long next_a1l1 = a1l0;
            long next_a1l2 = a1l1;

            a0l0 = next_a0l0;
            a0l1 = next_a0l1;
            a0l2 = next_a0l2;
            a1l0 = next_a1l0;
            a1l1 = next_a1l1;
            a1l2 = next_a1l2;
        }

        return (int)((a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % mod);
    }
}
