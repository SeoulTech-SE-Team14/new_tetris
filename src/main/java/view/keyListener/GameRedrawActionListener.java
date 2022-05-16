package view.keyListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.abstractComponent.panel.game.GamePanel;

public class GameRedrawActionListener implements ActionListener {

    private GamePanel gamePanel;

    public GameRedrawActionListener(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gamePanel.repaint();
    }
    
}
