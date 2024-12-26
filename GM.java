import main.Circle2D;
import main.Rectangle2D;
import main.Shape2D;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class main extends Application {
    private List<Shape2D> shapes = new ArrayList<>();
    private Shape2D selectedShape = null;
    private double offsetX, offsetY;

    @Override
    public void start(Stage primaryStage) {
        // Создаем холст
        Canvas canvas = new Canvas(600, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Создаем кнопки для добавления фигур
        Button addRectangleButton = new Button("Add Rectangle");
        Button addCircleButton = new Button("Add Circle");

        addRectangleButton.setOnAction(e -> addShape("Rectangle"));
        addCircleButton.setOnAction(e -> addShape("Circle"));

        VBox buttonBox = new VBox(10, addRectangleButton, addCircleButton);

        // Обработчик событий мыши для перетаскивания и изменения цвета
        canvas.setOnMousePressed(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                for (Shape2D shape : shapes) {
                    if (shape.contains(e.getX(), e.getY())) {
                        selectedShape = shape;
                        offsetX = e.getX() - shape.getX();
                        offsetY = e.getY() - shape.getY();
                        break;
                    }
                }
            } else if (e.getButton() == MouseButton.SECONDARY) {
                for (Shape2D shape : shapes) {
                    if (shape.contains(e.getX(), e.getY())) {
                        shape.setColor(randomColor());
                        redraw(gc);
                        break;
                    }
                }
            }
        });

        canvas.setOnMouseDragged(e -> {
            if (selectedShape != null) {
                selectedShape.setPosition(e.getX() - offsetX, e.getY() - offsetY);
                redraw(gc);
            }
        });

        canvas.setOnMouseReleased(e -> selectedShape = null);

        // Создаем основной макет
        StackPane root = new StackPane();
        root.getChildren().addAll(canvas, buttonBox);

        // Окно приложения
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Geometry App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addShape(String type) {
        Random rand = new Random();
        Color randomColor = randomColor();

        if ("Rectangle".equals(type)) {
            double x = rand.nextDouble() * 500;
            double y = rand.nextDouble() * 300;
            double width = rand.nextDouble() * 100 + 50;
            double height = rand.nextDouble() * 100 + 50;
            shapes.add(new Rectangle2D(x, y, width, height, randomColor));
        } else if ("Circle".equals(type)) {
            double x = rand.nextDouble() * 500;
            double y = rand.nextDouble() * 300;
            double radius = rand.nextDouble() * 50 + 30;
            shapes.add(new Circle2D(x, y, radius, randomColor));
        }

        redraw(getGraphicsContext2D());
    }

    private void redraw(GraphicsContext gc) {
        gc.clearRect(0, 0, 600, 400);
        for (Shape2D shape : shapes) {
            shape.draw(gc);
        }
    }

    private Color randomColor() {
        Random rand = new Random();
        return Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

    public static void main(String[] args) {
        launch(args);
    }
}