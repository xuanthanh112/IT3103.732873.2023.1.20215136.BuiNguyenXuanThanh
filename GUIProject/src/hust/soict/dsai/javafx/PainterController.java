package hust.soict.dsai.javafx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class PainterController {
    private Color brushColor = Color.BLACK;
    @FXML private Pane drawingAreaPane;
    @FXML private ToggleGroup tool;

    @FXML
    void changeTool(ActionEvent event) {
        switch(((RadioButton)event.getSource()).getText()) {
            default:
            case "Pen":
                brushColor = Color.BLACK;
                break;
            case "Eraser":
                brushColor = Color.WHITE;
                break;
        }
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        var circle = new Circle(event.getX(), event.getY(), 4, brushColor);
        drawingAreaPane.getChildren().add(circle);
    }
}
