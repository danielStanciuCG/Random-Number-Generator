package daniel.stanciu.randomnumgen;

import javax.swing.*;

class MainWindow {
    private float vNo = 1.2F;
    private String name = "Random Number Generator v";
    private String title = String.format("%s%.1f", name, vNo);
    private int min;
    private int max;
    private int repeat;

    MainWindow() {
        /* ----- FROM ----- */
        int fromLoopCondition = 1;
        do {
            try {
                String from = (String) JOptionPane.showInputDialog(
                        null,
                        "Welcome to Random Number Generator!\n\nPlease insert your number range.\n\nFrom:",
                        title,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        null,
                        "Enter Number"
                );
                if (from == null) {
                    return;
                }
                min = Integer.parseInt(from);
                fromLoopCondition = 2;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "INPUT ERROR: Please insert a number",
                        title,
                        JOptionPane.ERROR_MESSAGE
                );
            }
        } while (fromLoopCondition == 1);

        /* ----- TO ----- */
        int toLoopCondition = 1;
        do {
            try {
                String to = (String) JOptionPane.showInputDialog(
                        null,
                        "To:",
                        title,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        null,
                        "Enter Number"
                );
                if (to == null) {
                    return;
                }
                max = Integer.parseInt(to);
                if (max < min) {
                    throw new NumberFormatException();
                }
                toLoopCondition = 2;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "INPUT ERROR: Please insert a number greater than the first",
                        title,
                        JOptionPane.ERROR_MESSAGE
                );
            }
        } while (toLoopCondition == 1);

        /* ----- QUANTITY ----- */
        int qtyLoopCondition = 1;
        do {
            try {
                String quantity = (String) JOptionPane.showInputDialog(
                        null,
                        "How many numbers would you like?",
                        title,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        null,
                        "Enter Number"
                );
                if (quantity == null) {
                    return;
                }
                repeat = Integer.parseInt(quantity);
                if (repeat < 1) {
                    throw new NumberFormatException();
                }
                qtyLoopCondition = 2;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "INPUT ERROR: Please insert a number greater than 0",
                        title,
                        JOptionPane.ERROR_MESSAGE
                );
            }
        } while (qtyLoopCondition == 1);

        /* ----- RESULT ----- */
        int counter = 1;
        Generator generator = new Generator(min, max, repeat);
        int[] results = generator.generateNumber();

        for (int i : results) {
            JOptionPane.showMessageDialog(
                    null,
                    "Random number #" + counter++ + ": " + i,
                    title,
                    JOptionPane.PLAIN_MESSAGE
            );
        }
    }
}