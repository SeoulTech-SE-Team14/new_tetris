package view.frame;

import domain.config.controller.WindowSizeConfigController;

import domain.config.entity.WindowSizeConfig;
import domain.score.entity.Score;
import view.abstractComponent.frame.DefaultFrame;
import view.abstractComponent.panel.game.GamePanel;
import view.keyListener.SingleGameKeyListener;

public class GameFrame extends DefaultFrame {
    WindowSizeConfig windowSize = WindowSizeConfigController.getInstance().getCurrentConfig();
    
    private GamePanel gamePanel;

    public GameFrame() { 

        initPanel();
        addComponents();

        gamePanel.reset();
        gamePanel.setDefaultMode();

        addKeyListener(new SingleGameKeyListener(this));

        setFocusable(true);
        setVisible(true);
    }
    public GameFrame(String mode) {
        this();

        if (mode.equals("Item")) {
            gamePanel.setItemMode();
        }

        setVisible(true);
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void initPanel() {
        gamePanel = new GamePanel();
    }

    public void addComponents() {
        add(gamePanel);
    }

    public void gameExit() {
        Score score = gamePanel.getScore();
        new ScoreUsernameInputFrame(score);
        dispose();
    }

    @Override
    public void repaint() {
        super.repaint();
    }
    public static void main(String[] args){
        new GameFrame("Item");
    }
}
