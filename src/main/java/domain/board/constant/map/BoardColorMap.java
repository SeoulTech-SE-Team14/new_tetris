package domain.board.constant.map;

import domain.board.constant.BoardComponent;
import global.color.BaseColor;

import java.util.EnumMap;

public class BoardColorMap {
    private static EnumMap<BoardComponent, BaseColor> bEnumMap;

    static {
        bEnumMap = new EnumMap<>(BoardComponent.class);

        bEnumMap.put(BoardComponent.EMPTY, BaseColor.BLACK);
        bEnumMap.put(BoardComponent.WALL, BaseColor.LIGHT_GREY);
    }

    public static int getColor(BoardComponent boardComponent) {
        return bEnumMap.get(boardComponent).getColor();
    }
}
