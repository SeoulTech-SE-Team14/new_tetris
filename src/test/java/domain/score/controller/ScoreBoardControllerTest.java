package domain.score.controller;

import domain.score.entity.Score;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoreBoardControllerTest {
    List<Score> score;
    List<Score> expected;
    @BeforeEach
    void beforeEach() {
        ScoreBoardController.getInstance().removeAll();
        Score one = new Score(0,"", 2, 122, "Normal", "Item");
        Score two = new Score(0,"", 0, 123, "Normal", "Default");
        ScoreBoardController.getInstance().appendScoreBoard(two);
        ScoreBoardController.getInstance().appendScoreBoard(one);
    }
    @Test
    void getScoreBoard() {
        expected = new ArrayList<>();
        Score one = new Score(0,"", 2, 122, "Normal", "Item");
        Score two = new Score(0,"", 0, 123, "Normal", "Default");
        expected.add(one);
        expected.add(two);
        List<Score> actual = ScoreBoardController.getInstance().getScoreBoard();

        assertEquals(expected.size(), actual.size());
        for(int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i).getId(), actual.get(i).getId());
            assertEquals(expected.get(i).getDifficulty(), actual.get(i).getDifficulty());
            assertEquals(expected.get(i).getScore(), actual.get(i).getScore());
            assertEquals(expected.get(i).getMode(), actual.get(i).getMode());
            assertEquals(expected.get(i).getTimestamp(), actual.get(i).getTimestamp());
            assertEquals(expected.get(i).getUsername(), actual.get(i).getUsername());
        }

    }

    @Test
    void appendScoreBoard() {
        expected = new ArrayList<>();
        Score input = new Score(0,"", 123, 1234, "Hard", "Default");
        Score one = new Score(0,"", 2, 122, "Normal", "Item");
        Score two = new Score(0,"", 0, 123, "Normal", "Default");
        expected.add(input);
        expected.add(one);
        expected.add(two);
        ScoreBoardController.getInstance().appendScoreBoard(input);
        List<Score> actual = ScoreBoardController.getInstance().getScoreBoard();

        assertEquals(expected.size(), actual.size());
        for(int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i).getId(), actual.get(i).getId());
            Assertions.assertEquals(expected.get(i).getDifficulty(), actual.get(i).getDifficulty());
            Assertions.assertEquals(expected.get(i).getScore(), actual.get(i).getScore());
            Assertions.assertEquals(expected.get(i).getMode(), actual.get(i).getMode());
            Assertions.assertEquals(expected.get(i).getTimestamp(), actual.get(i).getTimestamp());
            Assertions.assertEquals(expected.get(i).getUsername(), actual.get(i).getUsername());
        }
    }

    @Test
    void removeAll() {
        ScoreBoardController.getInstance().removeAll();
        List<Score> actual = ScoreBoardController.getInstance().getScoreBoard();

        assertEquals(0, actual.size());
    }
}