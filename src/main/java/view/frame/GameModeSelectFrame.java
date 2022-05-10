package view.frame;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.abstractComponent.frame.ButtonMoveFrame;
import view.keyListener.GameModeSelectListener;

public class GameModeSelectFrame extends ButtonMoveFrame {
    
    private final String titleText = "게임 모드";
    private final String[] buttonTexts = {
        "일반 모드",
        "아이템 모드",
        "듀열 모드",
        "나가기"
    };

    private static final int COUNT = 4;

    private JLabel title;

    public GameModeSelectFrame() {
        super(COUNT);

        BorderLayout bl = new BorderLayout();
        setLayout(bl);
        addKeyListener(new GameModeSelectListener(this));

        Font font = new Font("Noto sans", Font.BOLD, 30);
        title = new JLabel(titleText);
        title.setFont(font);
        title.setForeground(Color.WHITE);
        add(title, BorderLayout.NORTH);

        buttons = new JButton[] {
            new JButton(buttonTexts[0]),
            new JButton(buttonTexts[1]),
            new JButton(buttonTexts[2]),
            new JButton(buttonTexts[3]),
        };

        GridLayout gl = new GridLayout(COUNT, 1);
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


    public static void main(String[] args) {
        new GameModeSelectFrame();
    }
}
