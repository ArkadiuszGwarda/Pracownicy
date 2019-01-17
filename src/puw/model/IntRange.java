package puw.model;

import java.util.Scanner;

public class IntRange {
    private int from;
    private int to;

    public void chooseRange(Scanner scanner) {
        System.out.println("Wprowadź zakres");
        System.out.print("od: ");
        from = scanner.nextInt();
        scanner.nextLine();
        System.out.print("do: ");
        to = scanner.nextInt();
        scanner.nextLine();
    }

    public IntRange() {
    }

    public IntRange(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}
