import java.nio.file.Files;
import java.nio.file.Paths;

public class Problem3 {

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean isCompositeOdd(int n) {
        return n % 2 != 0 && n > 1 && !isPrime(n);
    }

    public static void main(String[] args) {
        try {
            String data = new String(Files.readAllBytes(Paths.get("../inputs/states.txt")));
            String[] parts = data.trim().split("\\s+");

            int finalStateCount = 0;

            for (String p : parts) {
                int value = Integer.parseInt(p);
                int state = 0;

                if (value % 2 == 0) {
                    state = Math.min(3, state + 1);
                } else if (isPrime(value)) {
                    state = 3;
                } else if (isCompositeOdd(value)) {
                    state = state;
                }

                if (state == 3) {
                    finalStateCount++;
                }
            }

            System.out.println("Clue 3 = " + finalStateCount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
