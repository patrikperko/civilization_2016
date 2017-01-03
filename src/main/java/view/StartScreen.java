package view;

//commented imports for organizational purposes for navigating api
//import model.Civilization;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
//import javafx.scene.control.ListCell;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
//import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
//import javafx.scene.input.MouseEvent;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.util.Callback;

public class StartScreen extends StackPane {

    private ListView<CivEnum> civList;
    private Button startButton;

    public StartScreen() {
        //TODO

        civList = new ListView<CivEnum>();

        ObservableList<CivEnum> civs = FXCollections
            .observableArrayList(CivEnum.ANCIENT_EGYPT,
            CivEnum.QIN_DYNASTY, CivEnum.ROMAN_EMPIRE);
        civList.setItems(civs);
        civList.setMaxHeight(71);
        civList.setTranslateY(220);
        civList.setMaxWidth(200);
        String grabval;

        //button
        startButton = new Button("     Start     ");
        startButton.setTranslateY(270);

        //list title
        Label listTitle = new Label("Select A Civilization to Begin");
        listTitle.setFont(new Font("Cambria", 16));
        listTitle.setTextFill(Color.RED);
        listTitle.setTranslateY(172);

        //background image
        Image background =
            new Image("File:./src/main/java/view/civ_background.png");
        ImageView iv1 = new ImageView();
        iv1.setImage(background);
        iv1.setFitWidth(1080);
        iv1.setFitHeight(720);
        getChildren().addAll(iv1, civList, listTitle, startButton);
    }

    public Button getStartButton() {
        //TODO
        return startButton;
    }

    public ListView<CivEnum> getCivList() {
        //TODO
        return civList;
    }
}