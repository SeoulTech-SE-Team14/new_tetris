package view.abstractComponent.panel.config;

import javax.swing.JPanel;

import domain.config.entity.WindowSizeConfig;

public class WindowSizeConfigPanel extends JPanel {
    
    private WindowSizeConfig windowSizeConfig;

    public WindowSizeConfig getWindowSizeConfig() {
        return windowSizeConfig;
    }

    public void setWindowSizeConfig(WindowSizeConfig windowSizeConfig) {
        this.windowSizeConfig = windowSizeConfig;
    }
}
