package view.frame;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import view.abstractComponent.frame.DefaultFrame;
import view.abstractComponent.panel.game.BoardPanel;
import view.abstractComponent.panel.game.GamePanel;

public class MultiGameFrame extends DefaultFrame {
    
    private GamePanel playerOneGamePanel;
    private GamePanel playerTwoGamePanel;
}
