package leetcode;

// https://leetcode.com/problems/validate-ip-address/description/
// 468. Validate IP Address

public class ValidateIPAddress {
    public String validIPAddress(String IP) {
        if (IP == null)
            return "Neither";

        if (IP.indexOf('.') >= 0) {
            return checkV4(IP) ? "IPv4" : "Neither";
        } else if (IP.indexOf(':') >= 0) {
            return checkV6(IP) ? "IPv6" : "Neither";
        }

        return "Neither";
    }

    private boolean checkV4(String IP) {
        int numDots = 0;
        for (int i = 0; i < IP.length(); i++)
            if (IP.charAt(i) == '.')
                numDots++;

        if (numDots != 3)
            return false;

        String[] parts = IP.split("\\.");

        if (parts.length != 4)
            return false;

        for (String part : parts)
            if (!oneV4(part))
                return false;

        return true;
    }

    private boolean oneV4(String part) {
        // "" or "1234"
        if (part.length() == 0 || part.length() > 3)
            return false;

        // "01" or "012"
        if (part.length() > 1 && part.charAt(0) == '0')
            return false;

        // check if non-numberic
        for (int i = 0; i < part.length(); i++) {
            char c = part.charAt(i);
            if (c < '0' || c > '9')
                return false;
        }

        int val = Integer.parseInt(part);
        return val < 256;
    }

    private boolean checkV6(String IP) {
        int numColons = 0;
        for (int i = 0; i < IP.length(); i++)
            if (IP.charAt(i) == ':')
                numColons++;

        if (numColons != 7)
            return false;

        String[] parts = IP.split("\\:");

        if (parts.length != 8)
            return false;

        for (String part : parts)
            if (!oneV6(part))
                return false;

        return true;
    }

    private boolean oneV6(String part) {
        // "" or "12345"
        if (part.length() == 0 || part.length() > 4)
            return false;

        // check if non-alphaNumberic
        for (int i = 0; i < part.length(); i++) {
            char c = part.charAt(i);

            boolean isNum = c >= '0' && c <= '9';
            boolean isLower = c >= 'a' && c <= 'f';
            boolean isUpper = c >= 'A' && c <= 'F';

            if (!(isNum || isLower || isUpper))
                return false;
        }

        return true;
    }
}
