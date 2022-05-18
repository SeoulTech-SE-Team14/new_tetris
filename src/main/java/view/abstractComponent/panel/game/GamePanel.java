package view.abstractComponent.panel.game;

import domain.block.entity.Block;
import domain.block.entity.itemBlock.BonusScoreItem;
import domain.board.controller.BoardController;
import domain.board.entity.Board;
import domain.config.controller.DifficultyConfigController;
import domain.config.controller.WindowSizeConfigController;
import domain.config.entity.DifficultyConfig;
import domain.config.entity.WindowSizeConfig;
import domain.score.entity.Score;
import view.abstractComponent.frame.DefaultFrame;
import view.frame.game.multi.MultiGameFrame;
import view.keyListener.game.GameRedrawActionListener;
import view.keyListener.game.GameUpdateActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.util.List;

public class GamePanel extends JPanel {

    private MultiGameFrame frame;
    
    private WindowSizeConfigController windowSizeConfigController = WindowSizeConfigController.getInstance();
    private DifficultyConfigController difficultyConfigController = DifficultyConfigController.getInstance();

    private WindowSizeConfig windowSize = windowSizeConfigController.getCurrentConfig();
    private DifficultyConfig difficultyConfig;

    private BoardPanel boardPanel;
    private NextBlockPanel nextBlockPanel;
    private ScorePanel scorePanel;
    private BoardPanel previewPanel;

    private JPanel eastPanel;
    private JPanel westPanel;
    private JPanel eastSouthPanel;

    private boolean isItemMode;
    private int deletedTotalLines;
    private final int itemPerDeletedLines = 10;

    private boolean isPause;

    private int minInterval = 50;
    private int periodInterval = 1000;
    private int rateOfDecrease = 25;

    private Timer updateTimer;
    private Timer redrawTimer;

    public GamePanel() {
        super();

        initPanel();
        addComponents();

        reset();
    }

    public void reset() {
        windowSize = windowSizeConfigController.getCurrentConfig();
        difficultyConfig = difficultyConfigController.getCurrentConfig();

        String diff = difficultyConfig.getDifficulty();
        if (diff.equals("Easy")) {
            periodInterval = 1000;
            rateOfDecrease = 8;
        }
        else if (diff.equals("Normal")) {
            periodInterval = 1000;
            rateOfDecrease = 10;
        }
        else if (diff.equals("Hard")) {
            periodInterval = 1000;
            rateOfDecrease = 12;
        }

        isItemMode = false;
        deletedTotalLines = 0;
        isPause = false;

        boardPanel.reset();
        nextBlockPanel.reset();
        scorePanel.reset();

        updateTimer = new Timer(periodInterval, new GameUpdateActionListener(this));
        redrawTimer = new Timer(25, new GameRedrawActionListener(this));

        updateTimer.start();
        redrawTimer.start();
    }

    public void setItemMode() {
        isItemMode = true;
        scorePanel.setItemMode();
    }

    public void setDefaultMode() {
        isItemMode = false;
        scorePanel.setMode("Default");
    }

    public GamePanel(int width, int height, MultiGameFrame frame) {
        super();

        this.frame = frame;

        BorderLayout bl = new BorderLayout();
        setLayout(bl);

        initMultiPanel();
        addComponents();

        previewPanel.setVisible(true);
    }

    public BoardPanel getBoardPanel() {
        return boardPanel;
    }


    private void initPanel(){
        double width = windowSize.getWidth();
        double height = windowSize.getHeight();

        int intHeight = (int) height;
        int heightD2 = (int) (height / 2);
        int height2D5 = (int) (height / 5 * 2);
        int height7D10 = (int) (height / 10 * 7);
        int heightD5 = (int) (height / 5);
        int heightD10 = (int) (height / 10);

        boardPanel = new BoardPanel(heightD2, intHeight);
        nextBlockPanel = new NextBlockPanel(heightD5, heightD5);
        scorePanel = new ScorePanel();
        eastSouthPanel = new JPanel();

        int[][] shape = new int[][] {
            {1},
        };

        previewPanel = new BoardPanel(heightD5, height2D5);
        previewPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        previewPanel.getNowBlock().setShape(shape);

        eastPanel = new JPanel();
        westPanel = new JPanel();
        westPanel.setBackground(Color.GRAY);

        westPanel.setPreferredSize(new Dimension((int) width - height7D10, intHeight));

        boardPanel.setPreferredSize(new Dimension(heightD2, intHeight));
        nextBlockPanel.setPreferredSize(new Dimension(heightD5, heightD5));
        scorePanel.setPreferredSize(new Dimension(heightD5, heightD10));
        previewPanel.setPreferredSize(new Dimension(heightD5, height2D5));

        setLayout(new BorderLayout());
    }

    private void initMultiPanel(){
        double width = windowSize.getWidth();
        double height = windowSize.getHeight();

        int w = 0;
        int h = 0;

        w = (int)(height / 2); h = (int)(height);
        boardPanel = new BoardPanel(w, h);

        w = (int)(width / 2 - height / 2); h = (int)(width / 2 - height / 2);
        nextBlockPanel = new NextBlockPanel(w, h);
        scorePanel = new ScorePanel();

        int[][] shape = new int[][] {
            {1},
        };

        w = (int)(width / 2 - height / 2); h = (int)(((width / 2 - height / 2)) * 2);
        previewPanel = new BoardPanel(w, h);
        previewPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        previewPanel.getNowBlock().setShape(shape);

        eastPanel = new JPanel();
        westPanel = new JPanel();
        eastSouthPanel = new JPanel();
        westPanel.setBackground(Color.GRAY);

        w = (int)(height / 2); h = (int)(height);
        boardPanel.setPreferredSize(new Dimension(w, h));

        w = (int)(width / 2 - height / 2); h = (int)(width / 2 - height / 2);
        nextBlockPanel.setPreferredSize(new Dimension(w, h));

        w = (int)(width / 2 - height / 2); h = (int)(width / 2 - height / 2);
        scorePanel.setPreferredSize(new Dimension(w, h));

        w = (int)(width / 2 - height / 2); h = (int)(((width / 2 - height / 2)) * 2);
        previewPanel.setPreferredSize(new Dimension(w, h));

        setLayout(new BorderLayout());
    }

    private void addComponents() {
        BoxLayout bl = new BoxLayout(eastPanel, BoxLayout.PAGE_AXIS);
        eastPanel.setLayout(bl);

        eastPanel.setBackground(Color.GRAY);
        eastPanel.add(nextBlockPanel);
        eastPanel.add(scorePanel);
        eastPanel.add(previewPanel);
        eastPanel.add(eastSouthPanel);

        eastSouthPanel.setBackground(Color.GRAY);

        add(westPanel, BorderLayout.WEST);
        add(boardPanel, BorderLayout.CENTER);
        add(eastPanel, BorderLayout.EAST);
    }

    public void setVisiblePreviewBoard() {
        previewPanel.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    public boolean isGameOver() {
        return boardPanel.isGameOver();
    }

    private Block savedNowBlock;
    private int savedCurX;
    private int savedCurY;

    public void update() {
        if (isPause)
            return;
        if (isGameOver()) {
            updateTimer.stop();
            redrawTimer.stop();
        }

        updateTimer.stop();

        if (boardPanel.doHitWall()) {
            // deletedTotalLines += 4; // 테스트 용
            boardPanel.transformBlockToBoard();

            if (frame != null) {
                savedNowBlock = boardPanel.getNowBlock();
                savedCurX = boardPanel.getBoard().getCurX();
                savedCurY = boardPanel.getBoard().getCurY();

                movePreveiwBoardToBoard();
            }

            boardPanel.updateNowBlock(nextBlockPanel.getNextBlock());

            if (isItemMode) {
                if (deletedTotalLines < itemPerDeletedLines)
                    nextBlockPanel.updateNextBlock();
                else {
                    nextBlockPanel.updateNextItem();
                    deletedTotalLines -= itemPerDeletedLines;
                }
             } else
                nextBlockPanel.updateNextBlock();

            setPeriodInterval();
        } else {
            if (frame != null) 
                updatePreviewBoard();

            int deletedLines = boardPanel.update();
            deletedTotalLines += deletedLines;
            if (boardPanel.getNowBlock() instanceof BonusScoreItem) {
                scorePanel.updateScore(updateTimer.getDelay(), deletedLines, 5);
            } else {
                scorePanel.updateScore(updateTimer.getDelay(), deletedLines);
            }
        }

        updateTimer.start();

    }

    public void updatePreviewBoard() {
        if (boardPanel.findFullLine().size() <= 1)
            return;

        BoardController bController = BoardController.getInstance();
        List<Integer> fullLine = findFullLine();
        Board myBoard = boardPanel.getBoard();
        Board otherPreviewBoard;

        if (boardPanel.getBoard() == frame.getP1GamePanel().getBoardPanel().getBoard()) {
            otherPreviewBoard = frame.getP2GamePanel().getPreviewPanel().getBoard();
        }
        else {
            otherPreviewBoard = frame.getP1GamePanel().getPreviewPanel().getBoard();
        }

        bController.updatePreviewBoard(myBoard, otherPreviewBoard, savedNowBlock, fullLine, savedCurX, savedCurY);
    }

    public BoardPanel getPreviewPanel() {
        return previewPanel;
    }

    public void movePreveiwBoardToBoard() {
        BoardController bController = BoardController.getInstance();
        Board myBoard = boardPanel.getBoard();
        Board myPreviewBoard;

        if (boardPanel.getBoard() == frame.getP1GamePanel().getBoardPanel().getBoard()) {
            myPreviewBoard = frame.getP1GamePanel().getPreviewPanel().getBoard();
        }
        else {
            myPreviewBoard = frame.getP2GamePanel().getPreviewPanel().getBoard();
        }

        bController.moveUpBoard(myBoard, myPreviewBoard);
    }

    public void setPeriodInterval() {
        periodInterval -= rateOfDecrease;
        if (periodInterval < minInterval) {
            periodInterval = minInterval;
        }
        updateTimer.setDelay(periodInterval);
    }

    public void moveDown() {
        update();
    }

    public void moveLeft() {
        boardPanel.moveLeft();
    }

    public void moveRight() {
        boardPanel.moveRight();
    }

    public void moveDownAtOnce() {
        int moveDownCnt = boardPanel.moveDownAtOnce();
        scorePanel.updateScore(updateTimer.getDelay(), 0, moveDownCnt);
        update();
    }

    public void swithPause() {
        if (isPause) {
            updateTimer.start();
            redrawTimer.start();
            isPause = false;
        } else {
            updateTimer.stop();
            redrawTimer.stop();
            isPause = true;
        }
    }

    public void pause() {
        updateTimer.stop();
        redrawTimer.stop();
        isPause = true;
    }

    public void restart() {
        updateTimer.start();
        redrawTimer.start();
        isPause = false;
    }

    public boolean isPause() {
        return isPause;
    }

    public Score getScore() {
        return scorePanel.getScoreObject();
    }

    public void rotate() {
        boardPanel.rotate();
    }

    public List<Integer> findFullLine() {
        return boardPanel.findFullLine();
    }

    public static void main(String[] args) {
        DefaultFrame frame = new DefaultFrame();
        GridLayout gl = new GridLayout(1, 1);
        frame.setLayout(gl);
        frame.add(new GamePanel());
        frame.setVisible(true);
    }
}