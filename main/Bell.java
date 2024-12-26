package main;

public class Bell {
    private boolean isDing = true;

    // Метод для попеременного вывода "ding" и "dong"
    public void sound() {
        if (isDing) {
            System.out.println("ding");
        } else {
            System.out.println("dong");
        }
        isDing = !isDing;
    }

    public static void main(String[] args) {
        Bell bell = new Bell();
        bell.sound();  // Выведет "ding"
        bell.sound();  // Выведет "dong"
    }
}