package view.frame;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.abstractComponent.frame.DefaultFrame;
import view.abstractComponent.panel.ImagePanel;
import view.keyListener.IndexKeyListener;

public class IndexFrame extends DefaultFrame {

    private final String titleText = "테트리스";
    private final String[] buttonTexts = {
        "게임 시작",
        "스코어 보드",
        "환경 설정",
        "나가기"
    };

    private final int COUNT = 4;
    private int focusIndex;
    
    private JLabel title;
    private ImagePanel titlePanel;
    private JButton[] buttons;

    public IndexFrame() {
        BorderLayout bl = new BorderLayout();
        GridLayout gl = new GridLayout(COUNT, 1);
        setLayout(bl);
        addKeyListener(new IndexKeyListener(this));

        Font font = new Font("Noto sans", Font.BOLD, 30);
        title = new JLabel(titleText);
        title.setFont(font);
        title.setForeground(Color.WHITE);
        add(title, BorderLayout.NORTH);

        // titlePanel = new ImagePanel("./tetris_image.jpg");
        // add(titlePanel, BorderLayout.NORTH);

        buttons = new JButton[] {
            new JButton(buttonTexts[0]),
            new JButton(buttonTexts[1]),
            new JButton(buttonTexts[2]),
            new JButton(buttonTexts[3]),
        };

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(gl);


        for (int i = 0; i < COUNT; i++) {
            decorateButton(buttons[i]);
            buttonPanel.add(buttons[i]);
        }
        add(buttonPanel, BorderLayout.CENTER);

        setFocusable(true);
        decorateSelectedButton();
        setVisible(true);
    }

    private void decorateButton(JButton button) {
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }

    public void shiftUpFocusIndex() {
        decorateAllInNotFocus();
        focusIndex = (focusIndex + COUNT - 1) % COUNT;
        decorateSelectedButton();
    }

    public void shiftDownFocusIndex() {
        decorateAllInNotFocus();
        focusIndex = (focusIndex + 1) % COUNT;
        decorateSelectedButton();
    }

    private void decorateAllInNotFocus() {
        for (int i = 0; i < COUNT; i++)
            decorateButton(buttons[i]);
    }

    private void decorateSelectedButton() {
        buttons[focusIndex].setBackground(Color.WHITE);
        buttons[focusIndex].setForeground(Color.BLACK);
    }

    public int getFocusIndex() {
        return focusIndex;
    }


    public static void main(String[] args) {
        new IndexFrame();
    }
}
