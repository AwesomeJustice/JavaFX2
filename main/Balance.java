package main;

public class Balance {
    private int leftWeight = 0;
    private int rightWeight = 0;

    // Метод для добавления веса на правую чашу
    public void addRight(int weight) {
        rightWeight += weight;
    }

    // Метод для добавления веса на левую чашу
    public void addLeft(int weight) {
        leftWeight += weight;
    }

    // Метод для вывода результата балансировки
    public void result() {
        if (leftWeight == rightWeight) {
            System.out.println("=");
        } else if (leftWeight > rightWeight) {
            System.out.println("L");
        } else {
            System.out.println("R");
        }
    }

    public static void main(String[] args) {
        Balance balance = new Balance();
        balance.addLeft(5);
        balance.addRight(3);
        balance.result();  // Выведет "L"
    }
}