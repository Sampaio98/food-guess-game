package back;

import lombok.Getter;

public class Game {

    @Getter
    private FoodNode foodNodeRoot;

    public Game() {
        setupGame();
    }

    private void setupGame() {
        foodNodeRoot = new FoodNode("massa", "Lasanha");
        foodNodeRoot.setFoodNodeLeft(new FoodNode("Bolo de Chocolate"));
    }

    public FoodNode play(int answer, FoodNode foodNode) {
        if (foodNode != null) {
            if (answer == 0) {
                if (foodNode.getFoodNodeRight() != null) {
                    return foodNode.getFoodNodeRight();
                } else {
                    return null;
                }
            } else {
                if (foodNode.getFoodNodeLeft() != null) {
                    return foodNode.getFoodNodeLeft();
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    public void insertNewFoodNode(String foodName, String foodCharacteristic, FoodNode actualFoodNode, FoodNode previousFoodNode) {
        FoodNode newFoodNode = new FoodNode(foodCharacteristic, foodName);
        newFoodNode.setFoodNodeLeft(actualFoodNode);
        if (previousFoodNode.getFoodNodeLeft().getName().equals(actualFoodNode.getName())) {
            previousFoodNode.setFoodNodeLeft(newFoodNode);
        } else {
            previousFoodNode.setFoodNodeRight(newFoodNode);
        }
    }
}
