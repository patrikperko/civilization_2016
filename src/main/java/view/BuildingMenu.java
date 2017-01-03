package view;

import controller.GameController;
// import model.Building;
// import model.Settlement;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;

public class BuildingMenu extends AbstractMenu {

    private Button investButton = new Button("Invest");
    private Button demolishButton = new Button("Demolish");

    public BuildingMenu() {
        //TODO

        investButton.setOnMousePressed(e -> {
            // GameController.getLastClicked().
            //     getTile().getOccupant().((Building) invest());
            //placeholder button function
                GameController.getCivilization().explore();
                if (endTurn()) {
                    Alert newAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    newAlert.setHeaderText("Congratulations");
                    newAlert.setTitle("You Won!");
                    newAlert.showAndWait();
                    System.exit(0);
                }
            });

    }
}
