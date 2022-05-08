package view.abstractComponent.panel.config;

import java.awt.*;

import domain.config.controller.BlockColorConfigController;
import domain.config.entity.BlockColorConfig;
import view.abstractComponent.frame.DefaultFrame;

public class BlockColorConfigPanel extends ConfigPanel {

    private static final String titleText = "색상";
    private static final String[] buttonTexts = {
        "일반 모드",
        "색맹 모드",
    };

    private static final BlockColorConfigController blockColorConfigController = BlockColorConfigController.getInstance();
    private BlockColorConfig blockColorConfig;


    public BlockColorConfigPanel() {
        super(titleText, buttonTexts);
        
        blockColorConfig = blockColorConfigController.getCurrentConfig();

        updateSelectedIndex();
        decorateSelectedButton();
    }


    public BlockColorConfig getBlockColorConfig() {
        return blockColorConfig;
    }

    public void setBlockColorConfig() {
        switch (getFocusIndex()) {
            case 0: // 일반 모드
                blockColorConfig = blockColorConfigController.getDefault();
                break;
            case 1: // 색맹 모드
                blockColorConfig = blockColorConfigController.getProtanopia();
                break;
            default: 
                break;
        }

        blockColorConfigController.update(blockColorConfig);

        decorateUnfocusButton(getSelectedIndex());
        updateSelectedIndex();
        decorateSelectedButton();
    }

    public void updateSelectedIndex() {
        switch (blockColorConfig.getType()) {
            case "Default": setSelectedIndex(0); break;
            case "Protanopia": setSelectedIndex(1); break;
            case "Tritanopia": setSelectedIndex(1); break;
        }
    }

    public void setDefault() {
        blockColorConfig = blockColorConfigController.getDefault();
        blockColorConfigController.update(blockColorConfig);
    }


    public static void main(String[] args) {
        DefaultFrame frame = new DefaultFrame();

        BlockColorConfigPanel defaultPanel = new BlockColorConfigPanel();

        BlockColorConfigPanel focusPanel = new BlockColorConfigPanel();
        focusPanel.decorateFocusButton();

        GridLayout gl = new GridLayout(2, 1);
        frame.setLayout(gl);

        frame.add(defaultPanel);
        frame.add(focusPanel);
        frame.setVisible(true);
    }
}
