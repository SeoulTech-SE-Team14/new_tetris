package view.abstractComponent.frame;

import javax.swing.JFrame;
import java.awt.*;

import domain.config.dao.WindowSizeConfigDao;

public class DefaultFrame extends JFrame {

    //private WindowSizeConfigDao windowSizeConfigDao = WindowSizeConfigDao.getInstance();

    private final String title = "Tetris";

    public DefaultFrame(){

        setTitle(title);

        //setSize(windowSizeConfigDao.read().getWidth(),
        // windowSizeConfigDao.read().getHeight());
        setSize(800, 600);
        setResizable(false);
        setBackground(Color.BLACK);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args){
        new DefaultFrame();
    }
}
