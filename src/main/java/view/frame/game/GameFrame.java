package view.frame.game;

import javax.swing.Timer;

import domain.config.controller.WindowSizeConfigController;

import domain.config.entity.WindowSizeConfig;
import domain.score.entity.Score;
import view.abstractComponent.frame.DefaultFrame;
import view.abstractComponent.panel.game.GamePanel;
import view.frame.score.ScoreUsernameInputFrame;
import view.keyListener.game.GameFrameActionListener;
import view.keyListener.game.single.SingleGameKeyListener;

public class GameFrame extends DefaultFrame {
    WindowSizeConfig windowSize = WindowSizeConfigController.getInstance().getCurrentConfig();
    
    private GamePanel gamePanel;

    private Timer updateTimer;

    public GameFrame() { 

        initPanel();
        addComponents();

        gamePanel.reset();
        gamePanel.setDefaultMode();

        addKeyListener(new SingleGameKeyListener(this));

        updateTimer = new Timer(25, new GameFrameActionListener(this));
        updateTimer.start();

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
        updateTimer.stop();
        Score score = gamePanel.getScore();
        new ScoreUsernameInputFrame(score);
        dispose();
    }

    public boolean isGameOver() {
        return gamePanel.isGameOver();
    }

    @Override
    public void repaint() {
        super.repaint();
    }
    public static void main(String[] args){
        new GameFrame("Item");
    }
}
