import java.nio.file.Files;
import java.nio.file.Paths;

public class Problem2 {
    public static void main(String[] args) {
        try {
            String input = new String(Files.readAllBytes(Paths.get("inputs/input2.txt")));

            String reversed = new StringBuilder(input).reverse().toString();

            StringBuilder removed = new StringBuilder();
            for (int i = 0; i < reversed.length(); i++) {
                if ((i + 1) % 3 != 0) {
                    removed.append(reversed.charAt(i));
                }
            }

            StringBuilder shifted = new StringBuilder();
            for (int i = 0; i < removed.length(); i++) {
                shifted.append((char) (removed.charAt(i) + 2));
            }

            int vowelCount = 0;
            String vowels = "aeiouAEIOU";
            for (int i = 0; i < shifted.length(); i++) {
                if (vowels.indexOf(shifted.charAt(i)) != -1) {
                    vowelCount++;
                }
            }

            System.out.println("Clue 2 = " + vowelCount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
