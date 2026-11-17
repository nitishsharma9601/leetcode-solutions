
class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
            }
            else if (c == '+' || c == '-') {
                // Sign is allowed only at the beginning
                // or immediately after e/E
                if (i > 0 && s.charAt(i - 1) != 'e'
                          && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }
            else if (c == '.') {
                // Dot cannot appear more than once
                // or after the exponent
                if (seenDot || seenExp) {
                    return false;
                }
                seenDot = true;
            }
            else if (c == 'e' || c == 'E') {
                // Exponent must appear only once
                // and must have a digit before it
                if (seenExp || !seenDigit) {
                    return false;
                }

                seenExp = true;
                seenDigit = false;
            }
            else {
                return false;
            }
        }

        return seenDigit;
    }
}
