package interviewProblems.Fraction_To_Recurrind_Decimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();

        // Handle the sign
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) sb.append("-");

        // Keep abs values
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        // Add the integer section
        sb.append(num / den);

        // Check the remainder
        num = num % den;
        if (num == 0) return sb.toString();
        sb.append(".");

        // Iterate and divide, check if the remainder was seen and at what index
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length());
        while (num != 0) {
            num *= 10;
            sb.append(num / den);
            num %= den;
            // Check if the remainder was seen
            if (map.containsKey(num)) {
                int index = map.get(num);
                sb.insert(index, "(");
                sb.append(")");
                break;
            } else map.put(num, sb.length());
        }

        return sb.toString();
    }
}