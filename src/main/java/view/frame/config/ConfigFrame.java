package view.frame.config;

import javax.swing.JLabel;

import java.awt.*;

import view.abstractComponent.frame.DefaultFrame;
import view.abstractComponent.panel.config.BlockColorConfigPanel;
import view.abstractComponent.panel.config.ConfigPanel;
import view.abstractComponent.panel.config.DifficultyConfigPanel;
import view.abstractComponent.panel.config.OtherConfigPanel;
import view.abstractComponent.panel.config.P1KeyConfigPanel;
import view.abstractComponent.panel.config.P2KeyConfigPanel;
import view.abstractComponent.panel.config.WindowSizeConfigPanel;
import view.keyListener.config.ConfigKeyListener;

public class ConfigFrame extends DefaultFrame {

    private static final String titleText = "설정";

    private JLabel title;

    private final int COUNT = 6;

    private ConfigPanel[] configPanels;

    private int focusIndex;

    public ConfigFrame() {
        GridLayout gl = new GridLayout(7, 1);
        setLayout(gl);

        addComponents();
        addKeyListener(new ConfigKeyListener(this));
        setFocusable(true);
        setVisible(true);
    }

    private void addComponents() {
        title = new JLabel(titleText);

        Font font = new Font("Noto sans", Font.BOLD, 30);
        title.setFont(font);

        title.setBackground(Color.BLACK);
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(JLabel.CENTER);

        add(title);

        configPanels = new ConfigPanel[COUNT];

        configPanels[0] = new WindowSizeConfigPanel();
        configPanels[1] = new BlockColorConfigPanel();
        configPanels[2] = new DifficultyConfigPanel();
        configPanels[3] = new P1KeyConfigPanel();
        configPanels[4] = new P2KeyConfigPanel();
        configPanels[5] = new OtherConfigPanel();

        configPanels[focusIndex].decorateFocusButton();

        for (int i = 0; i < COUNT; i++)
            add(configPanels[i]);
    }

    public void shiftUpFocusIndex() {
        configPanels[focusIndex].decorateAllInNotFocus();
        focusIndex = (focusIndex + COUNT - 1) % COUNT;
        configPanels[focusIndex].decorateFocusButton();
    }

    public void shiftDownFocusIndex() {
        configPanels[focusIndex].decorateAllInNotFocus();
        focusIndex = (focusIndex + 1) % COUNT;
        configPanels[focusIndex].decorateFocusButton();
    }

    public void shiftLeftConfigPanels() {
        configPanels[focusIndex].shiftLeftFocusIndex();
    }

    public void shiftRightConfigPanels() {
        configPanels[focusIndex].shiftRightFocusIndex();
    }

    public JLabel getFrameTitle() {
        return title;
    }

    public ConfigPanel[] getConfigPanels() {
        return configPanels;
    }

    public int getFocusIndex() {
        return focusIndex;
    }

    public static void main(String[] args) {
        new ConfigFrame();
    }
}
