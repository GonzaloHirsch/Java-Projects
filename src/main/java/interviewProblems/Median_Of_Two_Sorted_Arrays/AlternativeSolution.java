package interviewProblems.Median_Of_Two_Sorted_Arrays;

public class AlternativeSolution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length; int m = nums2.length;
        boolean isEven = (n + m) % 2 == 0;
        int target = (int)Math.floor((n + m)/2.0);

        int ni = 0; int mi = 0; int count = 0; int curr = 0; int prev = 0;
        while ((ni < n || mi < m) && count <= target) {
            prev = curr;
            if (mi >= m || (ni < n && nums1[ni] <= nums2[mi])){
                curr = nums1[ni];
                ni++;
            } else {
                curr = nums2[mi];
                mi++;
            }
            count++;
        }

        if (isEven) {
            return (curr + prev)/2.0;
        } else {
            return curr;
        }
    }
}
