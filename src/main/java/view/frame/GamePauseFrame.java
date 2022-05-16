package view.frame;

import java.awt.*;

import javax.swing.*;

import view.abstractComponent.frame.ButtonMoveFrame;
import view.keyListener.GamePauseListener;

public class GamePauseFrame extends ButtonMoveFrame {
    
    private final String titleText = "게임 일시정지";
    private final String[] buttonTexts = {
        "게임 재개",
        "게임 중지"
    };

    private static final int COUNT = 2;

    private JLabel title;

    public GamePauseFrame(GameFrame gameFrame) {
        super(COUNT);
        
        BorderLayout bl = new BorderLayout();
        setLayout(bl);
        addKeyListener(new GamePauseListener(this, gameFrame));

        Font font = new Font("Noto sans", Font.BOLD, 30);
        title = new JLabel(titleText);
        title.setFont(font);
        title.setForeground(Color.WHITE);
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
