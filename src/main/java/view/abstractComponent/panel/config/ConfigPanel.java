package view.abstractComponent.panel.config;

import java.awt.*;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.abstractComponent.frame.DefaultFrame;
import view.abstractComponent.panel.LabelNButtonPanel;

public class ConfigPanel extends JPanel {
    
    private JLabel title;
    private LabelNButtonPanel[] labelNButtonPanels;
    
    private int focusIndex;
    private int selectedIndex;

    
    public ConfigPanel(String titleText, String[] labelTexts, String[] buttonTexts) {
        title = new JLabel(titleText);

        int length = labelTexts.length;
        labelNButtonPanels = new LabelNButtonPanel[length];
        for (int i = 0; i < length; i++)
            labelNButtonPanels[i] = new LabelNButtonPanel(labelTexts[i], buttonTexts[i]);

        selectedIndex = -1;

        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));

        decorateTitle();
    
        addComponents();
    }

    public ConfigPanel(String titleText, String[] buttonTexts) {
        this(titleText, new String[buttonTexts.length], buttonTexts);
    }

    private void decorateTitle() {
        Font font = new Font("Noto sans", Font.BOLD, 15);

        title.setForeground(Color.WHITE);
        title.setFont(font);
    }

    private void addComponents() {
        FlowLayout fl = new FlowLayout();
        setLayout(fl);

        add(title);
        for (LabelNButtonPanel panel : labelNButtonPanels)
            add(panel);
    }
    

    public JLabel getTitle() {
        return title;
    }

    public LabelNButtonPanel[] getLabelNButtonPanels() {
        return labelNButtonPanels;
    }

    public LabelNButtonPanel getLabelNButtonPanel(int idx) {
        return labelNButtonPanels[idx];
    }

    public void decorateFocusButton() {
        labelNButtonPanels[focusIndex].decorateFocusButton();
    }

    public void decorateUnfocusButton(int idx) {
        labelNButtonPanels[idx].decorateUnfocusButton();
    }

    public void decorateSelectedButton() {
        if (selectedIndex == -1)
            return;
        labelNButtonPanels[selectedIndex].decorateSelectedButton();
    }

    public void decorateAllInNotFocus() {
        for (int i = 0; i < labelNButtonPanels.length; i++)
            decorateUnfocusButton(i);
        decorateSelectedButton();
    }

    public void shiftRightFocusIndex() {
        decorateUnfocusButton(focusIndex);
        decorateSelectedButton();
        focusIndex = (focusIndex + 1) % labelNButtonPanels.length;
        decorateFocusButton();
    }

    public void shiftLeftFocusIndex() {
        decorateUnfocusButton(focusIndex);
        decorateSelectedButton();
        focusIndex = (focusIndex + labelNButtonPanels.length - 1) % labelNButtonPanels.length;
        decorateFocusButton();

    }

    public int getFocusIndex() {
        return focusIndex;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public void updateButtonText(int idx, String text) {
        labelNButtonPanels[idx].updateButtonText(text);
    }


    public static void main(String[] args) {
        String titleText = "config";
        String[] labelTexts = {
            "label1",
            "label2",
            "label3",
        };
        String[] buttonTexts = {
            "button1",
            "button2",
            "button3",
        };

        DefaultFrame frame = new DefaultFrame();

        GridLayout gl = new GridLayout(2, 1);
        frame.setLayout(gl);

        frame.add(new ConfigPanel(titleText, labelTexts, buttonTexts));
        frame.add(new ConfigPanel(titleText, buttonTexts));
        frame.setVisible(true);
    }
}
