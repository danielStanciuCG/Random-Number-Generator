package daniel.stanciu.randomnumgen;

import java.util.Random;

class Generator {
    private int min;
    private int max;
    private int quantity;

    Generator(int min, int max, int quantity) {
        this.min = min;
        this.max = max;
        this.quantity = quantity;
    }

    int[] generateNumber() {
        Random randomNum = new Random();
        int[] numbers = new int[quantity];

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = randomNum.nextInt(max - min + 1) + min; //Add + 1 to the formula to include the min and max numbers
        }
        return numbers;
    }
}
