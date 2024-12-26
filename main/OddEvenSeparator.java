package main;

import java.util.ArrayList;
import java.util.List;

public class OddEvenSeparator {
    private List<Integer> evenNumbers = new ArrayList<>();
    private List<Integer> oddNumbers = new ArrayList<>();

    // Метод для добавления числа
    public void addNumber(int number) {
        if (number % 2 == 0) {
            evenNumbers.add(number);
        } else {
            oddNumbers.add(number);
        }
    }

    // Метод для вывода четных чисел
    public void even() {
        System.out.println("Четные числа: " + evenNumbers);
    }

    // Метод для вывода нечетных чисел
    public void odd() {
        System.out.println("Нечетные числа: " + oddNumbers);
    }

    public static void main(String[] args) {
        OddEvenSeparator separator = new OddEvenSeparator();
        separator.addNumber(1);
        separator.addNumber(2);
        separator.addNumber(3);
        separator.even();  // Выведет "Четные числа: [2]"
        separator.odd();   // Выведет "Нечетные числа: [1, 3]"
    }
}