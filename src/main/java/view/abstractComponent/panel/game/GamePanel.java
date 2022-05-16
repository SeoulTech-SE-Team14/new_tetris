package view.abstractComponent.panel.game;

import domain.block.entity.itemBlock.BonusScoreItem;
import domain.config.controller.DifficultyConfigController;
import domain.config.controller.WindowSizeConfigController;
import domain.config.entity.DifficultyConfig;
import domain.config.entity.WindowSizeConfig;
import domain.score.entity.Score;
import view.abstractComponent.frame.DefaultFrame;
import view.keyListener.GameRedrawActionListener;
import view.keyListener.GameUpdateActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    
    private WindowSizeConfigController windowSizeConfigController = WindowSizeConfigController.getInstance();
    private DifficultyConfigController difficultyConfigController = DifficultyConfigController.getInstance();

    private WindowSizeConfig windowSize = windowSizeConfigController.getCurrentConfig();
    private DifficultyConfig difficultyConfig;

    private BoardPanel boardPanel;
    private NextBlockPanel nextBlockPanel;
    private ScorePanel scorePanel;
    private BoardPanel previewPanel;

    private JPanel eastPanel;
    private JPanel westPanel;

    private boolean isItemMode;
    private int deletedTotalLines;
    private final int itemPerDeletedLines = 10;

    private boolean isPause;

    private int minInterval = 50;
    private int periodInterval = 1000;
    private int rateOfDecrease = 25;

    private Timer updateTimer;
    private Timer redrawTimer;

    public GamePanel() {
        super();

        initPanel();
        setPanelSigleMode();
        addComponents();

        reset();
    }

    public void reset() {
        windowSize = windowSizeConfigController.getCurrentConfig();
        difficultyConfig = difficultyConfigController.getCurrentConfig();

        String diff = difficultyConfig.getDifficulty();
        if (diff.equals("Easy")) {
            periodInterval = 1000;
            rateOfDecrease = 8;
        }
        else if (diff.equals("Normal")) {
            periodInterval = 1000;
            rateOfDecrease = 10;
        }
        else if (diff.equals("Hard")) {
            periodInterval = 1000;
            rateOfDecrease = 12;
        }

        isItemMode = false;
        deletedTotalLines = 0;
        isPause = false;

        boardPanel.reset();
        nextBlockPanel.reset();
        scorePanel.reset();

        updateTimer = new Timer(periodInterval, new GameUpdateActionListener(this));
        redrawTimer = new Timer(25, new GameRedrawActionListener(this));

        updateTimer.start();
        redrawTimer.start();
    }

    public void setItemMode() {
        isItemMode = true;
        scorePanel.setItemMode();
    }

    public void setDefaultMode() {
        isItemMode = false;
        scorePanel.setMode("Default");
    }

    public GamePanel(int width, int height) {
        super();

        initPanel();
        setPanelMultiMode(width, height);
        addComponents();
    }

    public BoardPanel getBoardPanel() {
        return boardPanel;
    }


    private void initPanel(){
        boardPanel = new BoardPanel(300, 300);
        nextBlockPanel = new NextBlockPanel();
        scorePanel = new ScorePanel();
        previewPanel = new BoardPanel(300, 300);

        eastPanel = new JPanel();
        westPanel = new JPanel();
        westPanel.setBackground(Color.GRAY);

        setLayout(new BorderLayout());
    }
    private void setPanelSigleMode(){
        westPanel.setPreferredSize(new Dimension((int)(windowSize.getWidth()/4), windowSize.getHeight()));
        eastPanel.setPreferredSize(new Dimension((int)(windowSize.getWidth()/4), windowSize.getHeight()/2));
        boardPanel.setPreferredSize(new Dimension((int)(windowSize.getWidth()/3), (int)(windowSize.getHeight()*0.9)));
        nextBlockPanel.setPreferredSize(new Dimension((int)(windowSize.getWidth()/6), (int)(windowSize.getWidth()/6)));
        scorePanel.setPreferredSize(new Dimension((int)(windowSize.getWidth()/6), (int)(windowSize.getWidth()/6)));
    }

    private void setPanelMultiMode(int width, int height){
        westPanel.setPreferredSize(new Dimension(0, height));
        eastPanel.setPreferredSize(new Dimension((int)(width*0.3), height/2));
        boardPanel.setPreferredSize(new Dimension((int)(width*0.6), (int)(height*0.9)));
        nextBlockPanel.setPreferredSize(new Dimension((int)(width/5), (int)(width/5)));
        scorePanel.setPreferredSize(new Dimension((int)(width/5), (int)(width/5)));
    }

    private void addComponents() {
        eastPanel.setBackground(Color.GRAY);
        eastPanel.add(nextBlockPanel);
        eastPanel.add(scorePanel);

        add(westPanel, BorderLayout.WEST);
        add(boardPanel, BorderLayout.CENTER);
        add(eastPanel, BorderLayout.EAST);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    public boolean isGameOver() {
        return boardPanel.isGameOver();
    }

    public void update() {
        if (isPause)
            return;
        if (isGameOver()) {
            updateTimer.stop();
            redrawTimer.stop();
        }

        System.out.println("update");

        updateTimer.stop();

        if (boardPanel.doHitWall()) {
            deletedTotalLines += 4; // 추후 삭제 System.out.println()
            boardPanel.transformBlockToBoard();
            boardPanel.updateNowBlock(nextBlockPanel.getNextBlock());

            if (isItemMode) {
                if (deletedTotalLines < itemPerDeletedLines)
                    nextBlockPanel.updateNextBlock();
                else {
                    nextBlockPanel.updateNextItem();
                    deletedTotalLines -= itemPerDeletedLines;
                }
             } else
                nextBlockPanel.updateNextBlock();

            setPeriodInterval();
        } else {
            int deletedLines = boardPanel.update();
            deletedTotalLines += deletedLines;
            if (boardPanel.getNowBlock() instanceof BonusScoreItem) {
                scorePanel.updateScore(updateTimer.getDelay(), deletedLines, 5);
            } else {
                scorePanel.updateScore(updateTimer.getDelay(), deletedLines);
            }
        }

        updateTimer.start();

    }

    public void setPeriodInterval() {
        periodInterval -= rateOfDecrease;
        if (periodInterval < minInterval) {
            periodInterval = minInterval;
        }
        updateTimer.setDelay(periodInterval);
    }

    public void moveDown() {
        update();
    }

    public void moveLeft() {
        boardPanel.moveLeft();
    }

    public void moveRight() {
        boardPanel.moveRight();
    }

    public void moveDownAtOnce() {
        int moveDownCnt = boardPanel.moveDownAtOnce();
        scorePanel.updateScore(updateTimer.getDelay(), 0, moveDownCnt);
        update();
    }

    public void swithPause() {
        if (isPause) {
            updateTimer.start();
            redrawTimer.start();
            isPause = false;
        } else {
            updateTimer.stop();
            redrawTimer.stop();
            isPause = true;
        }
    }

    public void pause() {
        updateTimer.stop();
        redrawTimer.stop();
        isPause = true;
    }

    public void restart() {
        updateTimer.start();
        redrawTimer.start();
        isPause = false;
    }

    public boolean isPause() {
        return isPause;
    }

    public Score getScore() {
        return scorePanel.getScoreObject();
    }

    public void rotate() {
        boardPanel.rotate();
    }

    public static void main(String[] args) {
        DefaultFrame frame = new DefaultFrame();
        GridLayout gl = new GridLayout(1, 1);
        frame.setLayout(gl);
        frame.add(new GamePanel());
        frame.setVisible(true);
    }
}