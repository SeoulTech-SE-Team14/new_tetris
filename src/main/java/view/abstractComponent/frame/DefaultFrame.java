package view.abstractComponent.frame;

import javax.swing.JFrame;

import java.awt.*;

import domain.config.controller.WindowSizeConfigController;
import domain.config.entity.WindowSizeConfig;

public class DefaultFrame extends JFrame {
    
    private static final String title = "Tetris";


    protected final WindowSizeConfigController windowSizeConfigController = WindowSizeConfigController.getInstance();
    protected WindowSizeConfig windowSizeConfig;


    public DefaultFrame() {
        windowSizeConfig = windowSizeConfigController.getCurrentConfig();

        setTitle(title);
        setSize(windowSizeConfig.getWidth(), windowSizeConfig.getHeight());
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setVisible(true);
    }


    public static void main(String[] args) {
        new DefaultFrame();
    }
}
