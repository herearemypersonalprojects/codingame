/**
 * Created by quocanh on 15/01/2017.
 *
 * A3B2d97 => AAABBddddddd....
 */
public class TextCompress {

    private static String zip(String s) {
        if (s == null || s.length() < 1)
            return "";

        StringBuilder out = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int num = i;
            while (i < s.length() && s.charAt(i) == c) {
                i++;
            }
            out.append(c);
            out.append(String.valueOf(i-num));
        }
        return out.toString();
    }

    private static String unzip(String s) {
        if (s == null || s.length() < 2)
            return "";

        StringBuilder out = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            i++;
            int tmp = i;
            while (i < s.length() && '0' < s.charAt(i) && s.charAt(i) < '9') {
                i++;
            }
            int num = Integer.valueOf(s.substring(tmp, i));
            for (int j = 0; j < num; j++) {
                out.append(c);
            }
        }
        return out.toString();
    }

    public static void main(String[] args) {
        String input = "AAABBddddddd";
        String output = "A3B12d7";
        //System.out.println(zip(input));
        System.out.println(unzip(output));
    }
}
