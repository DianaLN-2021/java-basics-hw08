/*
  Regular expressions.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {

    /**
     * Get IP address from text.
     *
     * @param text text to parse
     * @return String with IP address
     */

    public static String getIpAddress(String text) {
        // TODO fill in code here for extracting IP address using Regular Expression

        String patternString = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
        String result = "";

        Pattern pattern = Pattern.compile(patternString);

        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result = matcher.group();
            String[] arr1 = result.split("\\.");
            int[] arr2 = new int[4];
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = Integer.parseInt(arr1[i]);
            }
            for (int number : arr2) {
                if (number > 255) {
                    result = "";
                    break;
                }
            }
        }

        return result;
    }
}