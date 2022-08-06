package interviewProblems.Three_Equal_Parts;
class Solution {
    public int[] threeEqualParts(int[] arr) {
        int[] res = new int[]{-1, -1};
        // Count number of ones
        int totalOnes = 0;
        for (int elem : arr) totalOnes += elem;
        // Check if possible answer, must be divisible by 3
        if (totalOnes % 3 != 0) return res;
        if (totalOnes == 0) return new int[]{0,arr.length - 1};
        int targetOnes = (int) totalOnes / 3;
        // Find solution
        int aStart = -1, aEnd = -1, bStart = -1, bEnd = -1, cStart = -1, cEnd = -1, currentOnes = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                // Add to ones counter and check if we reached target
                currentOnes++;
                if (currentOnes == 1) aStart = i;
                if (currentOnes == targetOnes) aEnd = i;
                if (currentOnes == targetOnes + 1) bStart = i;
                if (currentOnes == 2 * targetOnes) bEnd = i;
                if (currentOnes == 2 * targetOnes + 1) cStart = i;
                if (currentOnes == 3 * targetOnes) cEnd = i;
            }
        }
        // Check if the trailing zeros are ok, if there are more, those can be used as leading
        int trailingZeros = arr.length - cEnd - 1;
        if (trailingZeros > 0 && (bStart - aEnd - 1 < trailingZeros || cStart - bEnd - 1 < trailingZeros))  return res;
        // Check if the solution is good
        String a = getStringRepresentation(arr, aStart, aEnd + trailingZeros), b = getStringRepresentation(arr, bStart, bEnd + trailingZeros), c = getStringRepresentation(arr, cStart, arr.length - 1);
        return equalParts(a,b,c) ? new int[]{aEnd + trailingZeros, bEnd + trailingZeros + 1} : res;
    }

    private String getStringRepresentation(int[] arr, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) sb.append(arr[i]);
        return sb.toString();
    }

    private boolean equalParts(String a, String b, String c) {
        // Remove leading 0s
        if (a.length() > 0 && a.charAt(0) == '0') a = removeLeadingZeros(a);
        if (b.length() > 0 && b.charAt(0) == '0') b = removeLeadingZeros(b);
        if (c.length() > 0 && c.charAt(0) == '0') c = removeLeadingZeros(c);
        return a.equals(b) && a.equals(c);
    }

    private String removeLeadingZeros(String s) {
        char c;
        int index = 0;
        for (; index < s.length() && (c = s.charAt(index)) == '0'; index++);
        return s.substring(index);
    }
}
