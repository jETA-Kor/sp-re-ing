package net.jetalab.spreinglab05.controller;

import net.jetalab.spreinglab05.dao.BoardDAO;
import net.jetalab.spreinglab05.dto.BoardDTO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<BoardDTO> users(BoardDTO board) throws Exception {
        if ((board.getAuthor() == null) || (board.getContents() == null) || (board.getPassword() == null) || (board.getTitle() == null)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        boardDAO.newBoard(board);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @RequestMapping(value = "/board/{param}", method = RequestMethod.GET)
    public ResponseEntity<BoardDTO> users(@PathVariable("param") final int param) throws Exception {
        /* TODO: 조회수 증가 */
        BoardDTO board = boardDAO.getBoard(param);

        if (board == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(board, HttpStatus.OK);
    }

}
