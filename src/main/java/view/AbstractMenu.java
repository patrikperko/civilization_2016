package view;

import controller.GameController;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class AbstractMenu {
    public static final int PREFWIDTH = 140;
    private Button exploreButton = new Button("Explore");
    private Button endTurnButton = new Button("End Turn");
    private Text terrain = new Text();
    private Text unitStatus = new Text();
    private VBox menu = new VBox(10, terrain, unitStatus,
            exploreButton, endTurnButton);

    public AbstractMenu() {
        menu.setPrefWidth(PREFWIDTH);
        unitStatus.setWrappingWidth(120);

        exploreButton.setOnMousePressed(e -> {
                GameController.getCivilization().explore();
                if (endTurn()) {
                    Alert newAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    newAlert.setHeaderText("Congratulations");
                    newAlert.setTitle("You Won!");
                    newAlert.showAndWait();
                    System.exit(0);
                }
            });

        endTurnButton.setOnAction(event -> {
                if (endTurn()) {
                    Alert newAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    newAlert.setHeaderText("Congratulations");
                    newAlert.setTitle("You Won!");
                    newAlert.showAndWait();
                    System.exit(0);
                }
            });
        menu.setPrefWidth(PREFWIDTH);
        updateItems();
    }

    public VBox getRootNode() {
        updateItems();
        return menu;
    }

    public void addMenuItem(Node node) {
        menu.getChildren().add(node);
    }

    public boolean endTurn() {
        GameController.setLastClicked(null);
        GameController.tick();
        GameController.ai();
        GridFX.update();
        GameController.updateResourcesBar();
        if (GameController.getCivilization().getNumSettlements() <= 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Your last settlement has been destroyed!");
            alert.setTitle("Game Over");
            alert.showAndWait();
            System.exit(0);
        }
        return GameController.getCivilization()
                .getStrategy().conqueredTheWorld()
                || GameController.getCivilization()
                .getTechnology().hasTechnologyWin();
    }

    private void updateItems() {
        unitStatus.setText("");
        if (GameController.getLastClicked() != null) {
            terrain.setText(GameController.getLastClicked()
                    .getTile().getType().toString());
            if (!GameController.getLastClicked().getTile().isEmpty()) {
                unitStatus.setText(GameController.getLastClicked()
                        .getTile().getOccupant().getStatusString());
            }
        }
    }
}
