package view.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

import domain.board.controller.BoardController;
import domain.config.controller.DifficultyConfigController;
import domain.config.controller.WindowSizeConfigController;

import domain.config.entity.WindowSizeConfig;

import view.abstractComponent.frame.DefaultFrame;
import view.abstractComponent.panel.game.GamePanel;
import view.keyListener.GameKeyListener;

import javax.swing.*;

public class GameFrame extends DefaultFrame {
    WindowSizeConfig windowSize = WindowSizeConfigController.getInstance().getCurrentConfig();
    
    private GamePanel gamePanel;
    private GameKeyListener gameKeyListener;

    private final static int minInterval = 50;
    public static int periodInterval = 1000;
    private static int rateOfDecrease = 25;

    private static Timer updateTimer;
    private Timer redrawTimer;

    public GameFrame(){ }
    public GameFrame(int mode) {
        init();
        add();
        set();
        run(DifficultyConfigController.getInstance().getCurrentConfig().getDifficulty(), mode);
    }
    public void init(){
        gamePanel = new GamePanel();
        addKeyListener(new GameKeyListener(gamePanel));
    }
    public void set(){
        setVisible(true);
        setFocusable(true);
    }
    public void add(){
        add(gamePanel);
    }
    public void run(String difficulty, int mode) {
        start(difficulty, mode);
    }
    public void start(String difficulty, int mode) {
        beforeStart(difficulty, mode);

        updateTimer = new Timer(periodInterval, new UpdateCycle());
        updateTimer.start();

        redrawTimer = new Timer(25, new RepaintCycle());
        redrawTimer.start();
    }
    private void beforeStart(String difficulty, int mode) {
        if (Objects.equals(difficulty, "Easy")) {
            periodInterval = 1500;
            rateOfDecrease = 2;
        }
        else if (Objects.equals(difficulty, "Normal")) {
            periodInterval = 1000;
            rateOfDecrease = 5;
        }
        else if (Objects.equals(difficulty, "Hard")) {
            periodInterval = 750;
            rateOfDecrease = 7;
        }

        if (mode == 1) {
            BoardController.getInstance().setItemMode();
        }
    }

    private class UpdateCycle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            try {
                update();
            } catch (Exception exception) {
                //TODO: handle exception
            }
        }

    }

    private class RepaintCycle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if (BoardController.getInstance().getForceQuit()) {
                updateTimer.stop();
                redrawTimer.stop();

                dispose();
                try {
                    //new InputNameFrame();
                } catch (Exception exception) {
                    //TODO: handle exception
                }
            }
            //score update
            repaint();
        }
    }

    private void update() {

        List<Integer> toDelete = BoardController.getInstance().findFullLine(gamePanel.getBoardPanel().getBoard());
        if (!toDelete.isEmpty()) {
            int deletedLines = toDelete.size();
            BoardController.getInstance().deleteFullLine(gamePanel.getBoardPanel().getBoard(), toDelete);
            //ScoreController.getInstance().updateScore(score, clock, deletedLines);
        }
        if (BoardController.getInstance().isPause()) {
            return;
        }

        if (BoardController.getInstance().moveDown(gamePanel.getBoardPanel().getBoard())) {
            setPeriodInterval();
        }

        if (BoardController.getInstance().isDead(gamePanel.getBoardPanel().getBoard())) {
            updateTimer.stop();
            redrawTimer.stop();

            if (BoardController.getInstance().isItemMode()) {
                //ScoreController.getInstance().setMode();
            }
            else {
                //ScoreController.getInstance().setMode();;
            }
            //new InputNameFrame();
            dispose();
        }
    }

    public static void setPeriodInterval() {
        periodInterval -= rateOfDecrease;
        if (periodInterval < minInterval) {
            periodInterval = minInterval;
        }
        updateTimer.setDelay(periodInterval);
    }
    @Override
    public void repaint() {
        super.repaint();
    }
    public static void main(String[] args){
        new GameFrame(1);
    }
}
