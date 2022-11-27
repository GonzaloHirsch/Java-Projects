package interviewProblems.Defanging_An_IP_Address;

import java.util.Arrays;

class Solution {
    public String defangIPaddr(String address) {
        return String.join("[.]", Arrays.asList(address.split("\\.")));
    }
}
