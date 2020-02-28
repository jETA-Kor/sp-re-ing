package net.jetalab.spreinglab05.controller;

import net.jetalab.spreinglab05.dao.BoardDAO;
import net.jetalab.spreinglab05.dto.BoardDTO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@MapperScan(basePackages = "net.jetalab.spreinglab05.dao")
public class BoardController {

    @Autowired
    private BoardDAO boardDAO;

    @RequestMapping(value = "/board", method = RequestMethod.POST)
    public BoardDTO users(BoardDTO board) throws Exception {
        boardDAO.newBoard(board);
        return board;
    }

    @RequestMapping(value = "/board/{param}", method = RequestMethod.GET)
    public BoardDTO users(@PathVariable("param") final int param) throws Exception {
        BoardDTO board = boardDAO.getBoard(param);
        return board;
    }

}
