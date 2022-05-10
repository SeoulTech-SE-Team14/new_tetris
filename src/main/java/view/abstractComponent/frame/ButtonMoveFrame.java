package view.abstractComponent.frame;

import javax.swing.*;
import java.awt.*;

public class ButtonMoveFrame extends DefaultFrame {

    protected JButton[] buttons;
    
    private final int count;
    private int focusIndex;

    public ButtonMoveFrame(int count) {
        this.count = count;
    }

    public void decorateButton(JButton button) {
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }

    private void decorateAllInNotFocus() {
        for (int i = 0; i < count; i++)
            decorateButton(buttons[i]);
    }

    protected void decorateSelectedButton() {
        buttons[focusIndex].setBackground(Color.WHITE);
        buttons[focusIndex].setForeground(Color.BLACK);
    }

    public int getFocusIndex() {
        return focusIndex;
    }

    public void shiftUpFocusIndex() {
        decorateAllInNotFocus();
        focusIndex = (focusIndex + count - 1) % count;
        decorateSelectedButton();
    }

    public void shiftDownFocusIndex() {
        decorateAllInNotFocus();
        focusIndex = (focusIndex + 1) % count;
        decorateSelectedButton();
    }
}
