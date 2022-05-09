package view.abstractComponent.table;

import java.awt.BorderLayout;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import domain.score.controller.ScoreBoardController;
import domain.score.entity.Score;
import view.abstractComponent.frame.DefaultFrame;

public class ScoreBoardTable extends JPanel {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String[] HEADERS = {
        "이름", "점수", "난이도", "날짜", "모드"
    };
    
    
    private final ScoreBoardController scoreBoardController = ScoreBoardController.getInstance();
    private List<Score> scores;

    private JTable scoreTable;
    private String[][] contents;


    public ScoreBoardTable() {
        scores = scoreBoardController.getScoreBoard();
        setContents();

        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));

        scoreTable = new JTable(contents, HEADERS);

        decorateTable(scoreTable);

        JScrollPane tempPane = new JScrollPane(scoreTable);
        decoratePane(tempPane);

        add(tempPane);
    }

    public ScoreBoardTable(long timestamp) {
        this();

        
    }

    private void decorateTable(JTable table) {
        table.setBackground(Color.BLACK);
        table.setForeground(Color.WHITE);
        table.getTableHeader().setBackground(Color.BLACK);
        table.getTableHeader().setForeground(Color.WHITE);
        table.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        table.getColumn(HEADERS[0]).setPreferredWidth(50); // 이름
        table.getColumn(HEADERS[1]).setPreferredWidth(50); // 점수
        table.getColumn(HEADERS[2]).setPreferredWidth(10); // 난이도
        table.getColumn(HEADERS[3]).setPreferredWidth(100); // 날짜
        table.getColumn(HEADERS[4]).setPreferredWidth(10); // 모드
    }

    private void decoratePane(JScrollPane pane) {
        pane.setBackground(Color.BLACK);
        pane.setForeground(Color.WHITE);
        pane.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }

    private void setContents() {
        contents = new String[scores.size()][5];
        
        int i = 0;
        for (Score score : scores)
            contents[i++] = toContent(score);
    }

    private String[] toContent(Score score) {
        String[] ret = new String[5];

        ret[0] = score.getUsername();
        ret[1] = score.getScore() + "";
        ret[2] = score.getDifficulty();
        ret[3] = dateFormat.format(score.getTimestamp());
        ret[4] = score.getMode();

        return ret;
    }


    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public JTable getScoreTable() {
        return scoreTable;
    }


    public static void main(String[] args) {
        DefaultFrame frame = new DefaultFrame();

        frame.add(new ScoreBoardTable());
        frame.setVisible(true);
    }

}
