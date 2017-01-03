package runner;

import controller.GameController;
import view.StartScreen;
//import view.CivEnum;
import view.GameScreen;
import view.GridFX;
//import model.Map;
import model.Civilization;
import model.Bandit;
//import model.QinDynasty;
//import model.RomanEmpire;
//import model.Egypt;
import javafx.application.Application;
//import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;
//import javafx.scene.control.Button;

public class CivilizationGame extends Application {


    private StartScreen screen1;
    private Scene scene1;
    private Scene scene2;
    private TextInputDialog dialog;
    private Optional<String> result;
    private Civilization civ1;
    private GameScreen screen2;

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Civilization 1331");
        screen1 = new StartScreen();
        scene1 = new Scene(screen1);
        primaryStage.setScene(scene1);
        primaryStage.sizeToScene();
        primaryStage.show();
        primaryStage.setResizable(false);

        //create button listener
        screen1.getStartButton().addEventHandler(MouseEvent.MOUSE_CLICKED,
            (MouseEvent e) -> {
                scene2 = startGame();
                primaryStage.setScene(scene2);
            });

        //TODO
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public Scene startGame() {
        //TODO
        dialog = new TextInputDialog("Town Name");
        dialog.setTitle("A New Settlement");
        dialog.setContentText("Enter the name of your first town: ");
        dialog.setHeaderText("You have built a settlement!");
        result = dialog.showAndWait();

        civ1 = new Civilization(getCivSelection());
        GameController.setCivilization(civ1);
        GridFX.getMap().putSettlement(getDialog(), civ1, 0, 0);
        GridFX.getMap().addEnemies(new Bandit(), 1);
        screen2 = new GameScreen();
        scene2 = new Scene(screen2);
        GameScreen.switchMenu(GameController.GameState.NEUTRAL);
        return scene2;
    }

    //to retrieve entered settlement name
    private String getDialog() {
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    //to retrieve selected civilization
    private String getCivSelection() {
        String input = screen1.getCivList().getSelectionModel()
            .getSelectedItem().toString();
        return input;
    }




}
