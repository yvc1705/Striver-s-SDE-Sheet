public class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count = 1;
        StringBuilder sb = new StringBuilder(a);
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }
        if (sb.toString().contains(b)) {
            return count;
        }
        sb.append(a);
        if (sb.toString().contains(b)) {
            return count + 1;
        }
        return -1;
    }
}
