import java.nio.charset.StandardCharsets;

class Solution {
    public String reverseWords(String s) {
        if (s.length() == 1) return s;
        int start = 0, end = s.indexOf(' ');
        byte[] ans = new byte[s.length()];
        while (end != -1) {
            reverse(ans, s, start, end);
            ans[end] = ' ';
            start = end + 1;
            end = s.indexOf(' ', start);
        }
        reverse(ans, s, start, s.length());
        return new String(ans, StandardCharsets.US_ASCII);
    }
    private static void reverse(byte[] ans, String s, int start, int end) {
        int ins = start;
        for (int i = end - 1; i >= start; i--) {
            ans[ins++] = (byte) s.charAt(i);
        }
    }
}
