package net.jetalab.spreinglab04.dao;

import net.jetalab.spreinglab04.dto.BoardDTO;

public interface BoardDAO {

    int newBoard(BoardDTO param) throws Exception;

}
