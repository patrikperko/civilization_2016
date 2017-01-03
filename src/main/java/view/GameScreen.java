package view;

import controller.GameController;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class GameScreen extends BorderPane {

    private static ResourcesMenu resources = new ResourcesMenu();
    private static AbstractMenu abstractMenu = new AbstractMenu();
    private static MilitaryMenu militaryMenu = new MilitaryMenu();
    private static WorkerMenu workerMenu = new WorkerMenu();
    private static RecruitMenu recruitMenu = new RecruitMenu();
    private static BuildingMenu buildingMenu = new BuildingMenu();
    private static StatusMenu statusMenu = new StatusMenu();
    private static VBox vboxLeft = new VBox();
    private static VBox vboxTop = new VBox();


    public GameScreen() {
        //TODO
        setCenter(GridFX.getInstance());
        GridFX.update();
        setTop(vboxTop);
        setLeft(vboxLeft);
    }

    /**
     * This method should update the gridfx and the resource bar
     */
    public void update() {
      //TODO
        GridFX.update();
        resources.update();
    }
    /**
    * this method should return the resource menu
    * @return resource menu
    */
    public static ResourcesMenu getResources() {
        return resources;
    }


    /**
     * This method switches menus based on passed in game state.
     * Game.java calls this to selectively control which menus are displayed
     * @param state
     */
    public static void switchMenu(GameController.GameState state) {
       //TODO
        //NEUTRAL, MILITARY, WORKER, BUILDING, RECRUITING, ATTACKING, MOVING
        vboxTop.getChildren().setAll(resources.getRootNode());
        vboxLeft.getChildren().setAll(abstractMenu.getRootNode());
        if (state == GameController.GameState.MILITARY) {
            vboxLeft.getChildren().setAll(militaryMenu.getRootNode());
        } else if (state == GameController.GameState.WORKER) {
            vboxLeft.getChildren().setAll(workerMenu.getRootNode());
        } else if (state == GameController.GameState.RECRUITING) {
            vboxLeft.getChildren().setAll(recruitMenu.getRootNode());
        } else if (state == GameController.GameState.BUILDING) {
            vboxLeft.getChildren().setAll(buildingMenu.getRootNode());
        } else if (state == GameController.GameState.NEUTRAL) {
            vboxLeft.getChildren().setAll(statusMenu.getRootNode());
        }

    }
}
