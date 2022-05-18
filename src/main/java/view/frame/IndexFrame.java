package view.frame;

import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.abstractComponent.frame.ButtonMoveFrame;
import view.abstractComponent.panel.ImagePanel;
import view.keyListener.IndexKeyListener;

public class IndexFrame extends ButtonMoveFrame {

    private final String titleText = "테트리스";
    private final String[] buttonTexts = {
        "게임 시작",
        "스코어 보드",
        "환경 설정",
        "나가기"
    };

    private final static int COUNT = 4;
    
    private JLabel title;
    private ImagePanel titlePanel;

    public IndexFrame() {
        super(COUNT);
        BorderLayout bl = new BorderLayout();
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
        new IndexFrame();
    }
}
