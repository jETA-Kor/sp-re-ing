package net.jetalab.spreinglab04.controller;

import net.jetalab.spreinglab04.dao.BoardDAO;
import net.jetalab.spreinglab04.dto.BoardDTO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@MapperScan(basePackages = "net.jetalab.spreinglab04.dao")
public class BoardController {

        @Autowired
        private BoardDAO boardDAO;

        @RequestMapping(value = "/board", method = RequestMethod.POST)
        public BoardDTO postBoard(BoardDTO board) throws Exception {
            boardDAO.newBoard(board);
            return board;
        }

}
