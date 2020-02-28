package net.jetalab.spreinglab05.dao;

import net.jetalab.spreinglab05.dto.BoardDTO;

public interface BoardDAO {
    int newBoard(BoardDTO param) throws Exception;
    BoardDTO getBoard(int param) throws Exception;
}