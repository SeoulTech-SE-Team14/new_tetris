package view.abstractComponent.panel;

import java.awt.*;

import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.score.entity.Score;
import view.abstractComponent.frame.DefaultFrame;

public class ScoreDetailsPanel extends JPanel {
    
    private JLabel scoreLabel;
    private JLabel difficultyLabel;
    private JLabel timeStampLabel;
    private JLabel modeLabel;


    public ScoreDetailsPanel(Score score) {
        GridLayout gl = new GridLayout(4, 1);

        setLayout(gl);
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));

        scoreLabel = new JLabel("점수 : " + score.getScore());
        difficultyLabel = new JLabel("난이도 : " + score.getDifficulty());
        modeLabel = new JLabel("모드 : " + score.getMode());

        score.setTimestamp();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        timeStampLabel = new JLabel("게임 종료 시간 : " + dateFormat.format(score.getTimestamp()));

        decorateComponent(scoreLabel);
        decorateComponent(difficultyLabel);
        decorateComponent(timeStampLabel);
        decorateComponent(modeLabel);

        add(scoreLabel);
        add(difficultyLabel);
        add(modeLabel);
        add(timeStampLabel);
    }

    private void decorateComponent(JComponent component) {
        Font font = new Font("Noto sans", Font.PLAIN, 20);

        component.setFont(font);
        component.setBackground(Color.BLACK);
        component.setForeground(Color.WHITE);
        component.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }

    public static void main(String[] args) {
        DefaultFrame frame = new DefaultFrame();

        Score score = new Score(1, "username", 123, System.currentTimeMillis(), "Normal", "item");

        frame.add(new ScoreDetailsPanel(score));
        frame.setVisible(true);
    }
}
