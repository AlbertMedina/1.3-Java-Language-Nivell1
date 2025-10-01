package Level1Ex3;

import java.util.Scanner;

public class InputHandler {

    private static final Scanner SCANNER = new Scanner(System.in);

    public InputHandler() {
    }

    public static String readString(String message) {
        while (true) {
            System.out.print(message + ": ");
            try {
                String input = SCANNER.nextLine();
                if (input.isEmpty()) {
                    throw new Exception("Format error");
                }
                return input;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
