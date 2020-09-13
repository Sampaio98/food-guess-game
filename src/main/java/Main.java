import back.Game;
import front.App;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();

        JFrame frame = new JFrame("Jogo Gourmet");
        frame.setPreferredSize(new Dimension(280, 120));
        frame.setContentPane(new App(game).getWelcomeScreen());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
