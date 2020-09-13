package back;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GameTest {

    private static final int YES = 0;
    private static final int NO = 1;

    static Game game;

    @BeforeAll
    public static void game() {
        game = new Game();
    }

    @Test
    public void shouldReturnRightFoodNodePlay() {
        FoodNode foodNodeRight = game.getFoodNodeRoot().getFoodNodeRight();
        FoodNode foodNodeAnswer = game.play(YES, game.getFoodNodeRoot());
        assertEquals(foodNodeRight, foodNodeAnswer, "FoodNode are different.");
    }

    @Test
    public void shouldReturnLeftFoodNodePlay() {
        FoodNode foodNodeLeft = game.getFoodNodeRoot().getFoodNodeLeft();
        FoodNode foodNodeAnswer = game.play(NO, game.getFoodNodeRoot());
        assertEquals(foodNodeLeft, foodNodeAnswer, "FoodNode are different.");
    }

    @Test
    public void shouldReturnNothingOnRightNodePlay() {
        FoodNode foodNodeRight = game.getFoodNodeRoot().getFoodNodeRight();
        FoodNode foodNodeAnswer = game.play(YES, foodNodeRight);
        assertNull(foodNodeAnswer, "FoodNode is not null.");
    }

    @Test
    public void shouldReturnNothingOnLeftNodePlay() {
        FoodNode foodNodeLeft = game.getFoodNodeRoot().getFoodNodeLeft();
        FoodNode foodNodeAnswer = game.play(NO, foodNodeLeft);
        assertNull(foodNodeAnswer, "FoodNode is not null.");
    }

    @Test
    public void shouldReturnNothingOnPlay() {
        FoodNode foodNode = new FoodNode("frito", "coxinha");
        FoodNode foodNodeAnswer = game.play(NO, foodNode.getFoodNodeLeft());
        assertNull(foodNodeAnswer, "FoodNode is not null.");
    }

    @Test
    public void shouldInsertNewNode() {
        FoodNode foodNode = game.getFoodNodeRoot().getFoodNodeRight();
        FoodNode previousFoodNode = game.getFoodNodeRoot();
        game.insertNewFoodNode("pastel", "frito", foodNode, previousFoodNode);

        FoodNode newFoodNode = previousFoodNode.getFoodNodeRight();

        assertEquals(newFoodNode.getName(), "frito", "Food name are different.");
        assertEquals(newFoodNode.getFoodNodeRight().getName(), "pastel", "Food name are different.");
    }

    @Test
    public void shouldInsertNewNodeAndRegroupLeaf() {
        FoodNode foodNodePrevious = game.getFoodNodeRoot().getFoodNodeRight();
        FoodNode foodNodeActual = foodNodePrevious.getFoodNodeLeft();
        game.insertNewFoodNode("pizza", "redondo", foodNodeActual, foodNodePrevious);

        FoodNode newFoodNode = foodNodePrevious.getFoodNodeLeft();

        assertEquals(newFoodNode.getName(), "redondo", "Food name are different.");
        assertEquals(newFoodNode.getFoodNodeRight().getName(), "pizza", "Food name are different.");
    }

}