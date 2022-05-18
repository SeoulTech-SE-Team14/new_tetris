package view.keyListener.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.abstractComponent.panel.game.GamePanel;

public class GameUpdateActionListener implements ActionListener {

    private GamePanel gamePanel;

    public GameUpdateActionListener(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gamePanel.update();
    }
}
