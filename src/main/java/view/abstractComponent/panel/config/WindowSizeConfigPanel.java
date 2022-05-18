package view.abstractComponent.panel.config;

import java.awt.*;

import domain.config.controller.WindowSizeConfigController;
import domain.config.entity.WindowSizeConfig;
import view.abstractComponent.frame.DefaultFrame;

public class WindowSizeConfigPanel extends ConfigPanel {

    private static final String titleText = "창 크기";
    private static final String[] buttonTexts = {
        "800_600",
        "1000_800",
        "1280_960",
    };
    
    private static WindowSizeConfigController windowSizeConfigController = WindowSizeConfigController.getInstance();
    private WindowSizeConfig windowSizeConfig;


    public WindowSizeConfigPanel() {
        super(titleText, buttonTexts);
        
        windowSizeConfig = windowSizeConfigController.getCurrentConfig();

        updateSelectedIndex();
        decorateSelectedButton();
    }


    public WindowSizeConfig getWindowSizeConfig() {
        return windowSizeConfig;
    }

    public void setWindowSizeConfig() {
        switch (getFocusIndex()) {
            case 0: // 800_600
                windowSizeConfig = windowSizeConfigController.getW800_H600();
                break;
            case 1: // 1000_800
                windowSizeConfig = windowSizeConfigController.getW1000_H800();
                break;
            case 2: // 1280_960
                windowSizeConfig = windowSizeConfigController.getW1280_H960();
                break;
            default:
                return;
        }

        windowSizeConfigController.update(windowSizeConfig);

        decorateUnfocusButton(getSelectedIndex());
        updateSelectedIndex();
        decorateSelectedButton();
    }

    public void updateSelectedIndex() {
        switch (windowSizeConfig.getWidth()) {
            case 800: setSelectedIndex(0); break;
            case 1000: setSelectedIndex(1); break;
            case 1280: setSelectedIndex(2); break;
        }
    }

    public void setDefault() {
        windowSizeConfig = windowSizeConfigController.getDefault();
        windowSizeConfigController.update(windowSizeConfig);
    }


    public static void main(String[] args) {
        DefaultFrame frame = new DefaultFrame();

        WindowSizeConfigPanel defaultPanel = new WindowSizeConfigPanel();

        WindowSizeConfigPanel focusPanel = new WindowSizeConfigPanel();
        focusPanel.decorateFocusButton();

        GridLayout gl = new GridLayout(2, 1);
        frame.setLayout(gl);

        frame.add(defaultPanel);
        frame.add(focusPanel);
        frame.setVisible(true);
    }
}
