package view.frame.game.multi;

import domain.config.controller.WindowSizeConfigController;
import domain.config.entity.WindowSizeConfig;
import domain.score.entity.Score;
import view.abstractComponent.frame.DefaultFrame;
import view.abstractComponent.panel.game.GamePanel;
import view.keyListener.game.multi.MultiGameFrameActionListener;
import view.keyListener.game.multi.MultiGameKeyListener;
import view.keyListener.game.multi.MultiGameTimeOutActionListener;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MultiGameFrame extends DefaultFrame {
    
    private WindowSizeConfig windowSize = WindowSizeConfigController.getInstance().getCurrentConfig();
    
    private GamePanel p1GamePanel;
    private GamePanel p2GamePanel;

    private JPanel centerPanel;

    private boolean isTimeLimitMode;
    
    private Timer timeLimitTimer;
    private int count;

    private Timer updatTimer;

    private JLabel label;
    

    public MultiGameFrame(){
        initPanel();

        isTimeLimitMode = false;

        BorderLayout bl = new BorderLayout();

        p1GamePanel.reset();
        p2GamePanel.reset();
        p1GamePanel.setDefaultMode();
        p2GamePanel.setDefaultMode();

        label = new JLabel("일반 모드");
        decorateLabel();

        updatTimer = new Timer(25, new MultiGameFrameActionListener(this));
        updatTimer.start();

        setLayout(bl);
        addComponents();

        setFocusable(true);
        setVisible(true);

        p1GamePanel.setVisiblePreviewBoard();
        p2GamePanel.setVisiblePreviewBoard();
    }

    public MultiGameFrame(String mode) {
        this();

        label.setText("아이템 모드");

        if (mode.equals("Item")) {
            p1GamePanel.setItemMode();
            p2GamePanel.setItemMode();
        }

        setVisible(true);
    }

    public MultiGameFrame(int sec) {
        this();

        count = sec;
        isTimeLimitMode = true;
        timeLimitTimer = new Timer(1000, new MultiGameTimeOutActionListener(this));
        timeLimitTimer.start();
        label.setText("시간 제한 모드: " + count + " 초");
    }

    private void decorateLabel() {
        Font font = new Font("Noto sans", Font.BOLD, 30);
        label.setFont(font);
        label.setForeground(Color.WHITE);
    }

    public void initPanel(){
        p1GamePanel = new GamePanel(windowSize.getWidth(), windowSize.getHeight(), this);
        p2GamePanel = new GamePanel(windowSize.getWidth(), windowSize.getHeight(), this);

        GridLayout gl = new GridLayout(0, 2);

        centerPanel = new JPanel();
        centerPanel.setLayout(gl);

        centerPanel.add(p1GamePanel);
        centerPanel.add(p2GamePanel);
    }

    public void addComponents(){

        add(label, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        addKeyListener(new MultiGameKeyListener(this));
    }

    public GamePanel getP1GamePanel() {
        return p1GamePanel;
    }

    public GamePanel getP2GamePanel() {
        return p2GamePanel;
    }

    public boolean isTimeLimitMode() {
        return isTimeLimitMode;
    }

    public void timeOut() {
        gameExit();
    }

    public void gameExit() {
        if (isTimeLimitMode)
            timeLimitTimer.stop();
        updatTimer.stop();

        Score p1Score = p1GamePanel.getScore();
        Score p2Score = p2GamePanel.getScore();

        if (p1GamePanel.isGameOver())
            new MultiGameOverFrame(p1Score, p2Score, 2);
        else if (p2GamePanel.isGameOver())
            new MultiGameOverFrame(p1Score, p2Score, 1);
        else
            new MultiGameOverFrame(p1Score, p2Score);

        dispose();
    }

    public boolean isGameOver() {
        return p1GamePanel.isGameOver() || p2GamePanel.isGameOver();
    }

    public void countDown() {
        if (count <= 0)
            gameExit();

        count--;
        label.setText("시간 제한 모드: " + count + " 초");
    }

    public void pause() {
        if (isTimeLimitMode)
            timeLimitTimer.stop();

        p1GamePanel.pause();
        p2GamePanel.pause();
    }

    public void restart() {
        if (isTimeLimitMode) {
            timeLimitTimer.start();
        }

        p1GamePanel.restart();
        p2GamePanel.restart();
    }

    public static void main(String[] args){
        new MultiGameFrame(60);
    }
}
