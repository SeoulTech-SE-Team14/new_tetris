package view.frame.score;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import domain.score.entity.Score;
import view.abstractComponent.frame.DefaultFrame;
import view.abstractComponent.panel.ScoreDetailsPanel;
import view.keyListener.score.ScoreUsernameInputKeyListener;

public class ScoreUsernameInputFrame extends DefaultFrame {

    private static final String labelText = "게임 종료";

    private JLabel label;
    private ScoreDetailsPanel scoreDetailsPanel;
    private JTextField input;

    public ScoreUsernameInputFrame(Score score) {
        GridLayout gl = new GridLayout(3, 1);

        setLayout(gl);

        label = new JLabel(labelText);
        label.setHorizontalAlignment(JLabel.CENTER);
        scoreDetailsPanel = new ScoreDetailsPanel(score);
        input = new JTextField();

        input.addKeyListener(new ScoreUsernameInputKeyListener(this, input, score));

        decorateComponent(label);

        add(label);
        add(scoreDetailsPanel);
        add(input);

        input.grabFocus();
        input.requestFocus();
        
        setVisible(true);
    }

    private void decorateComponent(JComponent component) {
        Font font = new Font("Noto sans", Font.PLAIN, 20);

        component.setFont(font);
        component.setBackground(Color.BLACK);
        component.setForeground(Color.WHITE);
        component.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }


    public static void main(String[] args) {
        Score score = new Score(1, "username", 123, System.currentTimeMillis(), "Normal", "Item");
        new ScoreUsernameInputFrame(score);
    }
}
