package model;

import java.util.Random;
import java.util.Scanner;

class Desert {
    private Scanner scan = new Scanner(System.in);
    private Random rand = new Random();

    public int findTreasure() {
        return rand.nextInt(50) + 1;
    }

    public boolean lost() {
        System.out.println("You have gotten lost! Press 1 to try escaping the"
            + " Desert.\nHopefully you can make it out alive.");
        int move = scan.nextInt();
        return (move == 1) ? false : true;
    }
}
