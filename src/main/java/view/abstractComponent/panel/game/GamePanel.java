package view.abstractComponent.panel.game;

import domain.board.controller.BoardController;
import domain.config.controller.WindowSizeConfigController;
import domain.config.entity.WindowSizeConfig;
import domain.score.controller.ScoreController;
import domain.score.entity.Score;
import view.abstractComponent.frame.DefaultFrame;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private BoardPanel boardPanel;
    private NextBlockPanel nextBlockPanel;
    private ScorePanel scorePanel;
    private BoardPanel previewPanel;

    private JPanel eastPanel;
    private JPanel westPanel;

    public GamePanel() {
        super();
        addComponents();
    }

    public GamePanel(Score score, String mode) {
        super();
        addComponents();
        BoardController.getInstance().setItemMode();
        ScoreController.getInstance().setMode(score, mode);
    }
    private void addComponents() {
        WindowSizeConfig windowSize = WindowSizeConfigController.getInstance().getCurrentConfig();

        setLayout(new BorderLayout());

        boardPanel = new BoardPanel(300, 300);
        nextBlockPanel = new NextBlockPanel();
        scorePanel = new ScorePanel();

        eastPanel = new JPanel();
        westPanel = new JPanel();

        westPanel.setBackground(Color.GRAY);
        westPanel.setPreferredSize(new Dimension((int)(windowSize.getWidth()/4), windowSize.getHeight()));
        eastPanel.setPreferredSize(new Dimension((int)(windowSize.getWidth()/4), windowSize.getHeight()/2));
        boardPanel.setPreferredSize(new Dimension((int)(windowSize.getWidth()/3), (int)(windowSize.getHeight()*0.9)));
        nextBlockPanel.setPreferredSize(new Dimension((int)(windowSize.getWidth()/8), (int)(windowSize.getWidth()/8)));
        scorePanel.setPreferredSize(new Dimension((int)(windowSize.getWidth()/8), (int)(windowSize.getWidth()/8)));

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
        frame.add(new GamePanel());
        frame.setVisible(true);
    }
}
