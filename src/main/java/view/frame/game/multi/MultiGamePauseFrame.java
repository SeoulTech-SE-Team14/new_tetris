package view.frame.game.multi;

import java.awt.*;

import javax.swing.*;

import javax.swing.JLabel;

import view.abstractComponent.frame.ButtonMoveFrame;
import view.keyListener.game.multi.MultiGamePauseListener;

public class MultiGamePauseFrame extends ButtonMoveFrame {

    private final String titleText = "게임 일시정지";
    private final String[] buttonTexts = {
        "게임 재개",
        "게임 중지"
    };

    private static final int COUNT = 2;

    private JLabel title;

    public MultiGamePauseFrame(MultiGameFrame frame) {
        super(COUNT);
        
        BorderLayout bl = new BorderLayout();
        setLayout(bl);
        addKeyListener(new MultiGamePauseListener(this, frame));

        Font font = new Font("Noto sans", Font.BOLD, 30);
        title = new JLabel(titleText);
        title.setFont(font);
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);

        buttons = new JButton[] {
            new JButton(buttonTexts[0]),
            new JButton(buttonTexts[1]),
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
}
