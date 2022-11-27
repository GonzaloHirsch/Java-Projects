package interviewProblems.Find_The_Index_Of_The_First_Occurrence_In_A_String;


/* NOTE: It's quite a cheaty solution, I'd argue the KMP algorithm exists, but if it was up to me in production
* I'd do this because it's far more optimized than what I can come up with in 45 mins. The KMP algorithm is made
* for this, but at the moment I don't remember it.
*  */
class Solution {
    public int strStr(String haystack, String needle) {
        // With the standard library
        return haystack.indexOf(needle);
    }
}