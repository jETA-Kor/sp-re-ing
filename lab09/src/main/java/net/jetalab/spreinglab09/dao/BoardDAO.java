package net.jetalab.spreinglab09.dao;

import net.jetalab.spreinglab09.dto.BoardDTO;

public interface BoardDAO {
    int newBoard(BoardDTO param) throws Exception;
    BoardDTO getBoard(BoardDTO param) throws Exception;
    int editBoard(BoardDTO param) throws Exception;
    int addBoardReadCount(BoardDTO param) throws Exception;
}