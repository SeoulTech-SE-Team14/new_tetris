package view.abstractComponent.panel;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import java.awt.*;

import domain.score.entity.Score;
import view.abstractComponent.frame.DefaultFrame;

public class LabelNScoreDetailsPanel extends JPanel {
    
    private JLabel label;
    private ScoreDetailsPanel scoreDetailsPanel;

    public LabelNScoreDetailsPanel(String labelText, Score score) {
        BorderLayout bl = new BorderLayout();
        setLayout(bl);

        label = new JLabel(labelText);
        scoreDetailsPanel = new ScoreDetailsPanel(score);

        setBackground(Color.BLACK);
        setForeground(Color.WHITE);

        decorateLabel(label);
        addComponents();
    }

    private void decorateLabel(JLabel label) {
        Font font = new Font("Noto sans", Font.PLAIN, 20);

        label.setFont(font);
        label.setBackground(Color.BLACK);
        label.setForeground(Color.WHITE);
    }

    private void addComponents() {
        BorderLayout bl = new BorderLayout();
        setLayout(bl);

        add(label, BorderLayout.NORTH);
        add(scoreDetailsPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        String labelString = "P1 스코어";
        Score score = new Score();

        DefaultFrame frame = new DefaultFrame();
        FlowLayout fl = new FlowLayout();
        frame.setLayout(fl);
        frame.add(new LabelNScoreDetailsPanel(labelString, score));
        frame.setVisible(true);
    }
}
