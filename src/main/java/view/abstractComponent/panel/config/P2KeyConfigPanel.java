package view.abstractComponent.panel.config;

import domain.config.constant.key.KeyType;
import domain.config.controller.KeyConfigController;
import domain.config.entity.KeyConfig;
import view.abstractComponent.frame.DefaultFrame;
import view.abstractComponent.panel.LabelNButtonPanel;

import java.awt.*;
import java.awt.event.KeyEvent;

public class P2KeyConfigPanel extends ConfigPanel {
    
    private static final String titleText = "P2 키";
    private static final String[] labelTexts = {
        "블록 회전",
        "블록 아래 이동",
        "블록 한번에 아래 이동",
        "블록 왼쪽 이동",
        "블록 오른쪽 이동",
    };
    private static final String[] buttonTexts = {
        KeyEvent.getKeyText(KeyEvent.VK_T),
        KeyEvent.getKeyText(KeyEvent.VK_S),
        KeyEvent.getKeyText(KeyEvent.VK_W),
        KeyEvent.getKeyText(KeyEvent.VK_A),
        KeyEvent.getKeyText(KeyEvent.VK_D),
    };
    
    private static KeyConfigController keyConfigController = KeyConfigController.getInstance();
    private KeyConfig keyConfig;


    public P2KeyConfigPanel() {
        super(titleText, labelTexts, buttonTexts);
        
        keyConfig = keyConfigController.getCurrentConfig();
        updateButtonTexts();
    }

    private void updateButtonTexts() {
        LabelNButtonPanel[] panels = getLabelNButtonPanels();

        panels[0].updateButtonText(KeyEvent.getKeyText(
            keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_ROTATE)));
        panels[1].updateButtonText(KeyEvent.getKeyText(
            keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_MOVE_DOWN)));
        panels[2].updateButtonText(KeyEvent.getKeyText(
            keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_MOVE_DOWN_AT_ONCE)));
        panels[3].updateButtonText(KeyEvent.getKeyText(
            keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_MOVE_LEFT)));
        panels[4].updateButtonText(KeyEvent.getKeyText(
            keyConfigController.getKeyEvent(keyConfig, KeyType.P2_BLOCK_MOVE_RIGHT)));
    }


    public KeyConfig getKeyConfig() {
        return keyConfig;
    }

    public void setKeyConfig(KeyEvent e) {
        switch (getFocusIndex()) {

            case 0: // P2_BLOCK_ROTATE
                keyConfigController.setKeyConfig(keyConfig, KeyType.P1_BLOCK_ROTATE, e.getKeyCode());
                break;
            case 1: // P2_BLOCK_MOVE_DOWN
                keyConfigController.setKeyConfig(keyConfig, KeyType.P1_BLOCK_ROTATE, e.getKeyCode());
                break;
            case 2: // P2_BLOCK_MOVE_DOWN_AT_ONCE
                keyConfigController.setKeyConfig(keyConfig, KeyType.P1_BLOCK_ROTATE, e.getKeyCode());
                break;
            case 3: // P2_BLOCK_MOVE_LEFT
                keyConfigController.setKeyConfig(keyConfig, KeyType.P1_BLOCK_ROTATE, e.getKeyCode());
                break;
            case 4: // P2_BLOCK_MOVE_RIGHT
                keyConfigController.setKeyConfig(keyConfig, KeyType.P1_BLOCK_ROTATE, e.getKeyCode());
                break;
            default: 
                return;
        }

        keyConfigController.update(keyConfig);
        updateButtonText(getFocusIndex(), KeyEvent.getKeyText(e.getKeyCode()));
    }

    public void setDefault() {
        
    }


    public static void main(String[] args) {
        DefaultFrame frame = new DefaultFrame();

        P2KeyConfigPanel defaultPanel = new P2KeyConfigPanel();

        P2KeyConfigPanel focusPanel = new P2KeyConfigPanel();
        focusPanel.shiftRightFocusIndex();

        GridLayout gl = new GridLayout(2, 1);
        frame.setLayout(gl);

        frame.add(defaultPanel);
        frame.add(focusPanel);
        frame.setVisible(true);
    }
}
