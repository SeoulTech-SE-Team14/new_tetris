package view.abstractComponent.panel.config;

import java.awt.*;

import view.abstractComponent.frame.DefaultFrame;

public class OtherConfigPanel extends ConfigPanel {
    private static final String titleText = "기타";
    private static final String[] buttonTexts = {
        "설정 초기화",
        "스코어보드 초기화",
        "나가기"
    };


    public OtherConfigPanel() {
        super(titleText, buttonTexts);
    }


    public static void main(String[] args) {
        DefaultFrame frame = new DefaultFrame();

        OtherConfigPanel defaultPanel = new OtherConfigPanel();

        OtherConfigPanel focusPanel = new OtherConfigPanel();
        focusPanel.decorateFocusButton();

        GridLayout gl = new GridLayout(2, 1);
        frame.setLayout(gl);

        frame.add(defaultPanel);
        frame.add(focusPanel);
        frame.setVisible(true);
    }
}
