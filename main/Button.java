package main;
public class Button {
    private int clicks = 0;

    // Метод для увеличения счетчика кликов и вывода текущего числа нажатий
    public void click() {
        clicks++;
        System.out.println("Количество нажатий: " + clicks);
    }

    public static void main(String[] args) {
        Button button = new Button();
        button.click();
        button.click();
    }
}