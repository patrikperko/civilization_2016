package view;

import controller.GameController;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
//import model.Civilization;

public class ResourcesMenu {

    private HBox rootNode;
    private Text stratLevel;
    private Text resources;
    private Text settlements;
    private Text money;
    private Text food;
    private Text happiness;

    public ResourcesMenu() {
        rootNode = new HBox();
        stratLevel = new Text("Strat Level: "
        + GameController.getCivilization().getStrategy().getStrategyLevel()
        + "    ");
        resources = new Text("Resources: "
        + GameController.getCivilization().getResources() + "    ");
        settlements = new Text("Settlements: "
        + GameController.getCivilization().getNumSettlements() + "    ");
        money = new Text("Money: "
        + GameController.getCivilization().getTreasury().getCoins() + "    ");
        food = new Text("Food: "
        + GameController.getCivilization().getFood() + "    ");
        happiness = new Text("Happiness: "
        + GameController.getCivilization().getHappiness() + "    ");

        rootNode.getChildren().addAll(stratLevel, resources,
            settlements, money, food, happiness);
    }

    public void update() {
        stratLevel.setText("Strat Level: "
            + GameController.getCivilization().getStrategy().getStrategyLevel()
            + "    ");
        resources.setText("Resources: "
            + GameController.getCivilization().getResources() + "    ");
        settlements.setText("Settlements: "
            + GameController.getCivilization().getNumSettlements() + "    ");
        money.setText("Money: "
            + GameController.getCivilization().getTreasury()
            .getCoins() + "    ");
        food.setText("Food: "
            + GameController.getCivilization().getFood() + "    ");
        happiness.setText("Happiness: "
            + GameController.getCivilization().getHappiness() + "    ");
    }

    public HBox getRootNode() {
        //TODO
        update();
        return rootNode;
    }


}