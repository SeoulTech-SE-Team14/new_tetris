package view.abstractComponent.panel.game;

import domain.board.controller.BoardController;
import domain.config.controller.WindowSizeConfigController;
import domain.config.entity.WindowSizeConfig;
import view.abstractComponent.frame.DefaultFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel {
    private List<Integer> toDelete = new ArrayList<>();
    
     WindowSizeConfig windowSize = WindowSizeConfigController.getInstance().getCurrentConfig();

    private BoardPanel boardPanel;
    private NextBlockPanel nextBlockPanel;
    private ScorePanel scorePanel;
    private BoardPanel previewPanel;

    private JPanel eastPanel;
    private JPanel westPanel;


    public GamePanel(int width  , int height, int mode) {//multiGameFrame
        super();
        init();
        set(width, height);
        addComponents();
    }

    public GamePanel(int mode) {//singleGameFrame
        super();
        init();
        set();
        addComponents();
        BoardController.getInstance().setItemMode();
        //ScoreController.getInstance().setMode(mode);
    }

    private void init(){
        boardPanel = new BoardPanel(300, 300);
        nextBlockPanel = new NextBlockPanel();
        scorePanel = new ScorePanel();
        previewPanel = new BoardPanel(300, 300);

        eastPanel = new JPanel();
        westPanel = new JPanel();
    }
    private void set(){

        westPanel.setBackground(Color.GRAY);
        westPanel.setPreferredSize(new Dimension((int)(windowSize.getWidth()/4), windowSize.getHeight()));
        eastPanel.setPreferredSize(new Dimension((int)(windowSize.getWidth()/4), windowSize.getHeight()/2));
        boardPanel.setPreferredSize(new Dimension((int)(windowSize.getWidth()/3), (int)(windowSize.getHeight()*0.9)));
        nextBlockPanel.setPreferredSize(new Dimension((int)(windowSize.getWidth()/6), (int)(windowSize.getWidth()/6)));
        scorePanel.setPreferredSize(new Dimension((int)(windowSize.getWidth()/6), (int)(windowSize.getWidth()/6)));

        setLayout(new BorderLayout());
    }
    private void set(int width, int height){//MultiGame

        westPanel.setBackground(Color.GRAY);
        westPanel.setPreferredSize(new Dimension(0, height));
        eastPanel.setPreferredSize(new Dimension((int)(width*0.3), height/2));
        boardPanel.setPreferredSize(new Dimension((int)(width*0.6), (int)(height*0.9)));
        nextBlockPanel.setPreferredSize(new Dimension((int)(width/5), (int)(width/5)));
        scorePanel.setPreferredSize(new Dimension((int)(width/5), (int)(width/5)));

        setLayout(new BorderLayout());
    }
    private void addComponents() {
        eastPanel.setBackground(Color.GRAY);
        eastPanel.add(nextBlockPanel);
        eastPanel.add(scorePanel);

        add(westPanel, BorderLayout.WEST);
        add(boardPanel, BorderLayout.CENTER);
        add(eastPanel, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        DefaultFrame frame = new DefaultFrame();
        GridLayout gl = new GridLayout(1, 1);
        frame.setLayout(gl);
        frame.add(new GamePanel(1));
        frame.setVisible(true);
    }
}
