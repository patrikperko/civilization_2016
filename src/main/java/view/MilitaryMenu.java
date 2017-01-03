package view;

//import controller.GameController;
import javafx.scene.control.Button;



public class MilitaryMenu extends AbstractMenu {

    private Button attackButton = new Button("Attack");
    private Button moveButton = new Button("Move");

    public MilitaryMenu() {
        //TODO
        super();
        addMenuItem(attackButton);
        addMenuItem(moveButton);
    }
}
