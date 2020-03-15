package net.jetalab.spreinglab06.dao;

import net.jetalab.spreinglab06.dto.BoardDTO;

public interface BoardDAO {
    int newBoard(BoardDTO param) throws Exception;
    BoardDTO getBoard(BoardDTO param) throws Exception;
    int editBoard(BoardDTO param) throws Exception;
}