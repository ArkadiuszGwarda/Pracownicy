package puw.model;

import java.util.Scanner;

public class DoubleRange {
    private double from;
    private double to;

    public void chooseRange(Scanner scanner) {
        System.out.println("Wprowadź zakres");
        System.out.print("od: ");
        from = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("do: ");
        to = scanner.nextDouble();
        scanner.nextLine();
    }

    public DoubleRange() {
    }

    public DoubleRange(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }
}
