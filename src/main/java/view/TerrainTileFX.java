package view;


import controller.GameController;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.TerrainTile;

public class TerrainTileFX extends StackPane {
    private Rectangle overlay;
    private ImageView background;
    private TerrainTile tile;
    private ImageView icon = new ImageView("File:./bologna");
    private Rectangle overlay2;

    public TerrainTileFX(TerrainTile tile) {
        this.tile = tile;
        overlay = new Rectangle(70, 70, Color.rgb(0, 0, 0, 0.0));
        overlay2 = new Rectangle(70, 70, Color.rgb(0, 0, 0, 0.0));
        overlay.setStroke(Color.BLACK);
        this.background = new ImageView(tile.getImage());
        this.getChildren().addAll(overlay2, background, overlay, icon);
        updateTileView();
        this.setOnMousePressed(event -> {
                GameController.setLastClicked(this);
                // if(getTile().getOccupant() ==)
                GameScreen.switchMenu(GameController.GameState.BUILDING);
            });
        this.setOnMouseEntered(event -> {
                overlay2.setOpacity(.5);
                overlay2.setFill(Color.BLUE);
            });
        this.setOnMouseExited(event -> {
                updateTileView();
            });
    }

    public TerrainTile getTile() {
        return tile;
    }

    public void updateTileView() {
        //TODO
        this.getChildren().remove(icon);
        this.getChildren().remove(overlay2);

        if (tile.isEmpty()) {
            overlay2.setOpacity(0);
        }
        if (!tile.isEmpty()) {
            overlay2.setOpacity(.9);
            overlay2.setFill(tile.getOccupant().getColor());
            icon.setImage(tile.getOccupant().getImage());

            this.getChildren().add(icon);
            System.out.println(tile.getOccupant().toString());
        }
        this.getChildren().add(overlay2);

    }
}
