public class _443_StringCompression {
    public static void main(String[] args) {
        SOLVE443 object = new SOLVE443() ;
        System.out.println(object.compress(new char[]{
                'a',
                'b',
                'b',
                'b',
                'b',
                'b',
                'b',
                'b',
                'b',
                'b',
                'b',
                'b',
                'b',
                'a',
                'a',
                'c'})
        );
        System.out.println(object.compress(new char[]{
                's',
                'a',
                'a',
                'b',
                'b',
                'c',
                'c',
                'c'})
        );
    }
}
class SOLVE443 {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int index = 0;  // Index to track the current position in the modified array
        int count = 1;  // Counter to track the length of consecutive repeating characters
        for (int i = 1; i <= chars.length; i++) {
            if (i < chars.length && chars[i] == chars[i - 1]) {
                count++;  // Increment the counter for consecutive repeating characters
            } else {
                chars[index] = chars[i - 1];  // Store the current character

                if (count > 1) {
                    String countStr = String.valueOf(count);

                    for (char c : countStr.toCharArray()) {
                        chars[++index] = c;  // Store the count as separate characters
                    }
                }
                index++;  // Move to the next position in the modified array
                count = 1;  // Reset the counter for the next group
            }
        }
        return index;
    }
}