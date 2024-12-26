package main;

public class Table {
    private int[][] table;

    public Table(int rows, int cols) {
        table = new int[rows][cols];
    }

    public int getValue(int row, int col) {
        return table[row][col];
    }

    public void setValue(int row, int col, int value) {
        table[row][col] = value;
    }

    public int rows() {
        return table.length;
    }

    public int cols() {
        return table[0].length;
    }

    public double average() {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                sum += table[i][j];
                count++;
            }
        }
        return (double) sum / count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                sb.append(table[i][j]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Table table = new Table(2, 3);
        table.setValue(0, 0, 1);
        table.setValue(0, 1, 2);
        table.setValue(0, 2, 3);
        System.out.println(table);
        System.out.println("Среднее: " + table.average());
    }
}