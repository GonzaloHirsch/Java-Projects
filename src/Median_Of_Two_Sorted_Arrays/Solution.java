package Median_Of_Two_Sorted_Arrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] all = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while(i < nums1.length || j < nums2.length){
            if (i >= nums1.length){
                all[k++] = nums2[j++];
            } else if (j >= nums2.length){
                all[k++] = nums1[i++];
            } else if (nums1[i] <= nums2[j]){
                all[k++] = nums1[i++];
            } else {
                all[k++] = nums2[j++];
            }
        }
        if (all.length % 2 == 0){
            return (all[all.length / 2] + all[all.length / 2 - 1])/2.0;
        } else {
            return all[all.length / 2];
        }
    }
}
