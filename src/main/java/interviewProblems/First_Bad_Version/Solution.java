package interviewProblems.First_Bad_Version;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n, mid = 0;
        while (l < r) {
            // Avoids overflow
            mid = l + (r - l) / 2;
            if (this.isBadVersion(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}