package view.abstractComponent.panel.config;

import java.awt.*;

import domain.config.controller.DifficultyConfigController;
import domain.config.entity.DifficultyConfig;
import view.abstractComponent.frame.DefaultFrame;

public class DifficultyConfigPanel extends ConfigPanel {

    private static final String titleText = "난이도";
    private static final String[] buttonTexts = {
        "쉬움",
        "보통",
        "어려움",
    };
    
    private static DifficultyConfigController difficultyConfigController = DifficultyConfigController.getInstance();
    private DifficultyConfig difficultyConfig;


    public DifficultyConfigPanel() {
        super(titleText, buttonTexts);
        
        difficultyConfig = difficultyConfigController.getCurrentConfig();

        updateSelectedIndex();
        decorateSelectedButton();
    }

    public DifficultyConfig getDifficultyConfig() {
        return difficultyConfig;
    }

    public void setDifficultyConfig() {
        switch (getFocusIndex()) {
            case 0:  // 쉬움
                difficultyConfig = difficultyConfigController.getEasy();
                break;
            case 1: // 보통
                difficultyConfig = difficultyConfigController.getNormal();
                break;
            case 2:  // 어려움
                difficultyConfig = difficultyConfigController.getHard();
                break;
            default:
                return;
        }

        difficultyConfigController.update(difficultyConfig);

        decorateUnfocusButton(getSelectedIndex());
        updateSelectedIndex();
        decorateSelectedButton();
    }

    public void updateSelectedIndex() {
        switch (difficultyConfig.getDifficulty()) {
            case "Easy": setSelectedIndex(0); break;
            case "Normal": setSelectedIndex(1); break;
            case "Hard": setSelectedIndex(2); break;
        }
    }

    public void setDefault() {
        difficultyConfig = difficultyConfigController.getDefault();
        difficultyConfigController.update(difficultyConfig);
    }


    public static void main(String[] args) {
        DefaultFrame frame = new DefaultFrame();

        DifficultyConfigPanel defaultPanel = new DifficultyConfigPanel();

        DifficultyConfigPanel focusPanel = new DifficultyConfigPanel();
        focusPanel.decorateFocusButton();

        GridLayout gl = new GridLayout(2, 1);
        frame.setLayout(gl);

        frame.add(defaultPanel);
        frame.add(focusPanel);
        frame.setVisible(true);
    }
}
