package view.frame.score;

import java.awt.*;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

import view.abstractComponent.frame.DefaultFrame;
import view.abstractComponent.table.ScoreBoardTable;
import view.abstractComponent.table.ScoreBoardTableRenderer;
import view.keyListener.score.ScoreBoardKeyListener;

public class ScoreBoardFrame extends DefaultFrame {

    private final String labelText = "스코어 보드";
    private final String exitText = "나가기 (Enter)";
    
    private JLabel label;
    private ScoreBoardTable scoreBoardTable;
    private JButton exiButton;


    public ScoreBoardFrame() {
        label = new JLabel(labelText);
        scoreBoardTable = new ScoreBoardTable();
        exiButton = new JButton(exitText);

        BorderLayout bl = new BorderLayout();
        setLayout(bl);
        
        addKeyListener(new ScoreBoardKeyListener(this));

        label.setHorizontalAlignment(JLabel.CENTER);
        decorateComponent(label);
        decorateComponent(exiButton);

        add(label, BorderLayout.NORTH);
        add(scoreBoardTable, BorderLayout.CENTER);
        add(exiButton, BorderLayout.SOUTH);

        setFocusable(true);
        setVisible(true);
    }

    public ScoreBoardFrame(long timestamp) {
        this();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ScoreBoardTableRenderer renderer = new ScoreBoardTableRenderer(dateFormat.format(timestamp));
        scoreBoardTable.getScoreTable().setDefaultRenderer(Object.class, renderer);

    }

    private void decorateComponent(JComponent component) {
        Font font = new Font("Noto sans", Font.BOLD, 30);
        component.setFont(font);
        component.setBackground(Color.BLACK);
        component.setForeground(Color.WHITE);
    }


    public static void main(String[] args) {
        new ScoreBoardFrame();
    }
}