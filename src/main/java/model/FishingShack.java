package model;

import java.util.Random;
import javafx.scene.image.Image;

public class FishingShack extends Building {
    private SimpleSet<Fish> fish;
    private static Random rand = new Random();

    public FishingShack(Civilization owner) {
        super(200, owner, 5, 0, 10, 0, 0, 10);
        fish = new MySet<>();
        invest();
    }

    @Override
    public void invest() {
        replenishFish();
        int foodGeneration = 0;
        int goldGeneration = 0;
        Object[] fishes = fish.toArray();
        for (Object o : fishes) {
            Fish f = (Fish) o;
            foodGeneration += (int) (f.getHealth() / 2);
            goldGeneration += f.getHealth() - foodGeneration;
        }
        setFoodGeneration(foodGeneration);
        setGoldGeneration(goldGeneration);
    }

    @Override
    public char symbol() {
        return '&';
    }

    public Fish getFish() {
        try {
            Fish toBeReturned = fish.getRandomElement();
            return fish.remove(toBeReturned);
        } catch (ElementDoesNotExistException e) {
            return null;
        }
    }

    public boolean replenishFish() {
        if (!fish.isEmpty()) {
            return false;
        }
        while (fish.size() < 5) {
            fish.add(new Fish(rand.nextInt(5), rand.nextInt(5)));
        }
        return true;
    }

    @Override
    public String toString() {
        return "FishingShack. " + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image(
                "File:./src/main/java/view/Civ_Icon/fishing_shack_icon.PNG");
    }
}
