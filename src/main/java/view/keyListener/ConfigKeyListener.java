package view.keyListener;

import java.awt.event.*;

import domain.score.controller.ScoreBoardController;
import view.abstractComponent.panel.config.*;
import view.frame.ConfigFrame;
import view.frame.IndexFrame;

public class ConfigKeyListener extends KeyAdapter {

    private boolean isWaitKeyPressed = false;
    private int playerType;

    private ConfigFrame frame;

    WindowSizeConfigPanel windowSizeConfigPanel;
    BlockColorConfigPanel blockColorConfigPanel;
    DifficultyConfigPanel difficultyConfigPanel;
    P1KeyConfigPanel p1KeyConfigPanel;
    P2KeyConfigPanel p2KeyConfigPanel;
    OtherConfigPanel otherConfigPanel;

    private ScoreBoardController scoreBoardController = ScoreBoardController.getInstance();

    public ConfigKeyListener(ConfigFrame frame) {
        this.frame = frame;

        ConfigPanel[] panels = frame.getConfigPanels();

        windowSizeConfigPanel = (WindowSizeConfigPanel) panels[0];
        blockColorConfigPanel = (BlockColorConfigPanel) panels[1];
        difficultyConfigPanel = (DifficultyConfigPanel) panels[2];
        p1KeyConfigPanel = (P1KeyConfigPanel) panels[3];
        p2KeyConfigPanel = (P2KeyConfigPanel) panels[4];
        otherConfigPanel = (OtherConfigPanel) panels[5];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (isWaitKeyPressed) {
            setKeyConfig(e);
            isWaitKeyPressed = false;
            return;
        }

        switch (keyCode) {
            case KeyEvent.VK_UP: frame.shiftUpFocusIndex(); break;
            case KeyEvent.VK_DOWN: frame.shiftDownFocusIndex(); break;
            case KeyEvent.VK_LEFT: frame.shiftLeftConfigPanels(); break;
            case KeyEvent.VK_RIGHT: frame.shiftRightConfigPanels(); break;
            case KeyEvent.VK_ENTER: setConfig(); break;
        }
    }

    public void setKeyConfig(KeyEvent e) {
        switch (playerType) {
            case 1: p1KeyConfigPanel.setKeyConfig(e); break;
            case 2: p2KeyConfigPanel.setKeyConfig(e); break;
        }
    }

    public void setConfig() {

        switch (frame.getFocusIndex()) {
            case 0: windowSizeConfigPanel.setWindowSizeConfig(); frame.dispose(); new ConfigFrame(); break;
            case 1: blockColorConfigPanel.setBlockColorConfig(); break;
            case 2: difficultyConfigPanel.setDifficultyConfig(); break;
            case 3: isWaitKeyPressed = true; playerType = 1; break;
            case 4: isWaitKeyPressed = true; playerType = 2; break;
            case 5: actOtherConfig(otherConfigPanel.getFocusIndex()); break;
        }
    }

    public void actOtherConfig(int focusIndex) {
        switch (focusIndex) {
            case 0: setDefaultConfig(); break;
            case 1: scoreBoardController.removeAll(); break;
            case 2: frame.dispose(); new IndexFrame(); break;
        }
    }

    public void setDefaultConfig() {
        windowSizeConfigPanel.setDefault();
        blockColorConfigPanel.setDefault();
        difficultyConfigPanel.setDefault();
        p1KeyConfigPanel.setDefault();
        p2KeyConfigPanel.setDefault();
        frame.dispose(); new ConfigFrame();
    }
}