package view.frame.game.multi;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

import domain.score.entity.Score;
import view.abstractComponent.frame.DefaultFrame;
import view.abstractComponent.panel.LabelNScoreDetailsPanel;
import view.keyListener.game.multi.MultiGameOverKeyListener;

public class MultiGameOverFrame extends DefaultFrame {

    private static final String buttonText = "나가기";
    
    private JLabel label;
    private JPanel scoresPanel;
    private LabelNScoreDetailsPanel p1ScorePanel;
    private LabelNScoreDetailsPanel p2ScorePanel;
    private JButton exitButton;

    public MultiGameOverFrame(Score p1Score, Score p2Score) {
        GridLayout gl = new GridLayout(1, 2);
        BorderLayout bl = new BorderLayout();

        setLayout(bl);

        p1ScorePanel = new LabelNScoreDetailsPanel("P1 스코어", p1Score);
        p2ScorePanel = new LabelNScoreDetailsPanel("P2 스코어", p2Score);
        exitButton = new JButton(buttonText);
        
        if (p1Score.getScore() > p2Score.getScore())
        label = new JLabel("Player 1 승리");
        else if (p1Score.getScore() < p2Score.getScore())
        label = new JLabel("Player 2 승리");
        else
        label = new JLabel("무승부");

        scoresPanel = new JPanel();
        scoresPanel.setLayout(gl);
        scoresPanel.add(p1ScorePanel);
        scoresPanel.add(p2ScorePanel);

        decorateComponent(label);
        decorateComponent(exitButton);

        add(label, BorderLayout.NORTH);
        add(scoresPanel, BorderLayout.CENTER);
        add(exitButton, BorderLayout.SOUTH);

        setVisible(true);
        setFocusable(true);
        addKeyListener(new MultiGameOverKeyListener(this));
    }

    public MultiGameOverFrame(Score p1Score, Score p2Score, int who) {
        this(p1Score, p2Score);

        if (who == 1)
            label.setText("Player 1 승리");
        else if (who == 2)
            label.setText("Player 2 승리");
        else
            label.setText("무승부");
    }

    private void decorateComponent(JComponent component) {
        Font font = new Font("Noto sans", Font.PLAIN, 20);

        component.setFont(font);
        component.setBackground(Color.BLACK);
        component.setForeground(Color.WHITE);
        component.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }

    public static void main(String[] args) {
        Score p1Score = new Score();
        Score p2Score = new Score();
        new MultiGameOverFrame(p1Score, p2Score);
    }
}
