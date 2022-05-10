package view.frame;

import domain.config.controller.WindowSizeConfigController;
import domain.config.entity.WindowSizeConfig;
import view.abstractComponent.frame.DefaultFrame;
import view.abstractComponent.panel.game.GamePanel;
import view.keyListener.GameKeyListener;

import java.awt.*;

public class MultiGameFrame extends DefaultFrame {
    WindowSizeConfig windowSize = WindowSizeConfigController.getInstance().getCurrentConfig();
    
    private GamePanel playerOneGamePanel;
    private GamePanel playerTwoGamePanel;
    private GameKeyListener gameKeyListener;
    private GridLayout gridLayout;

    public MultiGameFrame(){
        init();
        add();
        set();
    }

    public void init(){
        playerOneGamePanel = new GamePanel(windowSize.getWidth()/2, windowSize.getHeight(), 1);
        playerTwoGamePanel = new GamePanel(windowSize.getWidth()/2, windowSize.getHeight(), 1);
        gameKeyListener = new GameKeyListener();
        gridLayout = new GridLayout(1, 0);
    }
    public void set(){
        setLayout(gridLayout);
        setFocusable(true);
        setVisible(true);
    }
    public void add(){
        add(playerOneGamePanel, BorderLayout.WEST);
        add(playerTwoGamePanel, BorderLayout.EAST);
        addKeyListener(gameKeyListener);
    }
    public static void main(String[] args){
        new MultiGameFrame();
    }
}
