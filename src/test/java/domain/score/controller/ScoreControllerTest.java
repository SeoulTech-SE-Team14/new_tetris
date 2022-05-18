package domain.score.controller;

import domain.score.entity.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ScoreControllerTest {
    Score score;
    @BeforeEach
    void beforeEach() {
        score = new Score(0, "test", 50, 1, "Easy", "Normal");
    }
    @Test
    @DisplayName("[이지 모드] 점수 업데이트 테스트 - 삭제한 줄이 없고, 점수 배수가 없는 경우")
    void testUpdateScore() {
        score.setDifficulty("Easy");
        int deleteLines = 0;
        ScoreController.getInstance().updateScore(score, 100, deleteLines);
        assertEquals(60, score.getScore());
    }

    @DisplayName("[이지 모드] 점수 업데이트 테스트 - 삭제한 줄이 있고, 점수 배수가 없는 경우")
    @Test
    void testUpdateScore2() {
        score.setDifficulty("Easy");
        int deleteLines = 2;
        ScoreController.getInstance().updateScore(score, 100, deleteLines);
        assertEquals(130, score.getScore());
    }
    @DisplayName("[이지 모드] 점수 업데이트 테스트 - 삭제한 줄이 없고, 점수 배수가 있는 경우")
    @Test
    void testUpdateScore3() {
        score.setDifficulty("Easy");
        int deleteLines = 0;
        ScoreController.getInstance().updateScore(score, 100, deleteLines, 2);
        assertEquals(70, score.getScore());
    }
    @Test
    @DisplayName("[이지 모드] 점수 업데이트 테스트 - 삭제한 줄이 없고, 점수 배수가 있는 경우")
    void testUpdateScore4() {
        score.setDifficulty("Easy");
        int deleteLines = 2;
        ScoreController.getInstance().updateScore(score, 100, deleteLines, 2);
        assertEquals(210, score.getScore());
    }

    @Test
    @DisplayName("[노멀 모드] 점수 업데이트 테스트 - 삭제한 줄이 없고, 점수 배수가 없는 경우")
    void testUpdateScore5() {
        score.setDifficulty("Normal");
        int deleteLines = 0;
        ScoreController.getInstance().updateScore(score, 100, deleteLines);
        assertEquals(70, score.getScore());
    }

    @DisplayName("[노멀 모드] 점수 업데이트 테스트 - 삭제한 줄이 있고, 점수 배수가 없는 경우")
    @Test
    void testUpdateScore6() {
        score.setDifficulty("Normal");
        int deleteLines = 2;
        ScoreController.getInstance().updateScore(score, 100, deleteLines);
        assertEquals(210, score.getScore());
    }
    @DisplayName("[노멀 모드] 점수 업데이트 테스트 - 삭제한 줄이 없고, 점수 배수가 있는 경우")
    @Test
    void testUpdateScore7() {
        score.setDifficulty("Normal");
        int deleteLines = 0;
        ScoreController.getInstance().updateScore(score, 100, deleteLines, 2);
        assertEquals(90, score.getScore());
    }
    @Test
    @DisplayName("[노멀 모드] 점수 업데이트 테스트 - 삭제한 줄이 없고, 점수 배수가 있는 경우")
    void testUpdateScore8() {
        score.setDifficulty("Normal");
        int deleteLines = 2;
        ScoreController.getInstance().updateScore(score, 100, deleteLines, 2);
        assertEquals(370, score.getScore());
    }

    @Test
    @DisplayName("[하드 모드] 점수 업데이트 테스트 - 삭제한 줄이 없고, 점수 배수가 없는 경우")
    void testUpdateScore9() {
        score.setDifficulty("Hard");
        int deleteLines = 0;
        ScoreController.getInstance().updateScore(score, 100, deleteLines);
        assertEquals(80, score.getScore());
    }

    @DisplayName("[하드 모드] 점수 업데이트 테스트 - 삭제한 줄이 있고, 점수 배수가 없는 경우")
    @Test
    void testUpdateScore10() {
        score.setDifficulty("Hard");
        int deleteLines = 2;
        ScoreController.getInstance().updateScore(score, 100, deleteLines);
        assertEquals(290, score.getScore());
    }
    @DisplayName("[하드 모드] 점수 업데이트 테스트 - 삭제한 줄이 없고, 점수 배수가 있는 경우")
    @Test
    void testUpdateScore11() {
        score.setDifficulty("Hard");
        int deleteLines = 0;
        ScoreController.getInstance().updateScore(score, 100, deleteLines, 2);
        assertEquals(110, score.getScore());
    }
    @Test
    @DisplayName("[하드 모드] 점수 업데이트 테스트 - 삭제한 줄이 없고, 점수 배수가 있는 경우")
    void testUpdateScore12() {
        score.setDifficulty("Hard");
        int deleteLines = 2;
        ScoreController.getInstance().updateScore(score, 100, deleteLines, 2);
        assertEquals(530, score.getScore());
    }
    @Test
    void setUsername() {
        ScoreController.getInstance().setUsername(score, "admin");
        String actual = score.getUsername();
        assertEquals("admin", actual);
    }

    @Test
    void setDifficulty() {
        ScoreController.getInstance().setDifficulty(score, "Hard");
        String actual = score.getMode();
        assertEquals("Hard", actual);
    }
}