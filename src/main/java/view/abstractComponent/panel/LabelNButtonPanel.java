package view.abstractComponent.panel;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.abstractComponent.frame.DefaultFrame;

public class LabelNButtonPanel extends JPanel {
    
    private JLabel label;
    private JButton button;


    public LabelNButtonPanel(String labelText, String buttonText) {
        label = new JLabel(labelText);
        button = new JButton(buttonText);

        decorateComponents();
        addComponents();
    }

    public LabelNButtonPanel(String buttonText) {
        this("", buttonText);
    }

    private void decorateComponents() {
        setBackground(Color.BLACK);

        decorateLabel();
        decorateButton();
    }

    private void decorateLabel() {
        Font font = new Font("Noto sans", Font.PLAIN, 12);

        label.setFont(font);
        label.setBackground(Color.BLACK);
        label.setForeground(Color.WHITE);
    }

    private void decorateButton() {
        Font font = new Font("Noto sans", Font.PLAIN, 12);

        button.setFont(font);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.WHITE), 
            BorderFactory.createEmptyBorder(2, 4, 2, 4)));
    }

    private void addComponents() {
        FlowLayout flowLayout = new FlowLayout();
        
        setLayout(flowLayout);

        add(label);
        add(button);
    }


    public JLabel getLabel() {
        return label;
    }

    public JButton getButton() {
        return button;
    }

    public void decorateFocusButton() {
        button.setBackground(Color.GRAY);
        button.setForeground(Color.WHITE);
    }

    public void decorateUnfocusButton() {
        decorateButton();
    }

    public void decorateSelectedButton() {
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
    }

    public void updateButtonText(String text) {
        button.setText(text);
    }


    public static void main(String[] args) {
        String labelText = "label";
        String buttonText = "button";

        DefaultFrame frame = new DefaultFrame();
        FlowLayout fl = new FlowLayout();

        frame.setLayout(fl);
        frame.add(new LabelNButtonPanel(labelText, buttonText));
        frame.add(new LabelNButtonPanel(buttonText));
        frame.setVisible(true);
    }
}
