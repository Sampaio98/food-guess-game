package front;

import back.FoodNode;
import back.Game;
import lombok.Getter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.text.MessageFormat;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_NO_OPTION;

@Getter
public class App {
    private static final String MESSAGE = "O prato que você pensou é {0} ?";
    private static final String ASK_FOOD_NAME = "Qual prato você pensou ?";
    private static final String ASK_FOOD_CHARACTERISTIC = "{0} é _________ mas {1} não.";

    private final Game game;

    private JButton btnStart;
    private JPanel welcomeScreen;
    private JLabel lblWelcome;

    private FoodNode previousFoodNode;

    public App(Game game) {
        this.previousFoodNode = null;
        this.game = game;
        btnStart.addActionListener(actionEvent -> makePlay(game.getFoodNodeRoot()));
    }

    public void makePlay(FoodNode foodNode) {
        String msg = formatPlayMessage(foodNode.getName());
        int answer = JOptionPane.showConfirmDialog(null, msg, "Confirm", YES_NO_OPTION);

        FoodNode foodNodeAnswer = game.play(answer, foodNode);
        if (foodNodeAnswer != null) {
            previousFoodNode = foodNode;
            makePlay(foodNodeAnswer);
        } else {
            if (answer == NO_OPTION) {
                createNewFoodNode(foodNode);
            } else {
                JOptionPane.showMessageDialog(null, "Acertei de novo");
            }
        }
    }

    private void createNewFoodNode(FoodNode foodNode) {
        String newFoodName = JOptionPane.showInputDialog(null, ASK_FOOD_NAME, "Desisto", INFORMATION_MESSAGE);
        String newFoodCharacteristic = JOptionPane.showInputDialog(null,
                formatAskCharacteristic(newFoodName, foodNode.getName()), "Complete", INFORMATION_MESSAGE);
        game.insertNewFoodNode(newFoodName, newFoodCharacteristic, foodNode, previousFoodNode);
    }

    private String formatPlayMessage(String foodNodeName) {
        return MessageFormat.format(MESSAGE, foodNodeName);
    }

    private String formatAskCharacteristic(String newFoodName, String actualFoodName) {
        return MessageFormat.format(ASK_FOOD_CHARACTERISTIC, newFoodName, actualFoodName);
    }

}
