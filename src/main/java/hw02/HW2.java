package hw02;

import java.util.Arrays;

public class HW2 {
    public static void main(String[] args) {
        String[][] gameField;
        gameField = new String[6][6];
        for (int i = 0; i < gameField.length; i++) {
            gameField[0][i] = String.join(" ", Integer.toString(i), " ");
            gameField[i][0] = String.join(" ", Integer.toString(i), "|");
            String aStrRep = Arrays.toString(gameField[i]);
            System.out.println(aStrRep);
        }
    }
}

