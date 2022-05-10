package view.frame;

import java.awt.event.KeyListener;

import domain.config.controller.WindowSizeConfigController;
import domain.config.entity.WindowSizeConfig;
import view.abstractComponent.frame.DefaultFrame;
import view.abstractComponent.panel.game.GamePanel;
import view.keyListener.GameKeyListener;

public class GameFrame extends DefaultFrame {
    WindowSizeConfig windowSize = WindowSizeConfigController.getInstance().getCurrentConfig();
    
    private GamePanel gamePanel;
    private GameKeyListener gameKeyListener;

    public GameFrame(){
        init();
        add();
        set();
    }

    public void init(){
        gamePanel = new GamePanel(1);
        gameKeyListener = new GameKeyListener();
    }

    public void set(){
        setVisible(true);
        setFocusable(true);
    }
    public void add(){
        add(gamePanel);
        addKeyListener(gameKeyListener);
    }
    public static void main(String[] args){
        new GameFrame();
    }
}
