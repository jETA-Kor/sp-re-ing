package net.jetalab.spreinglab08.controller;

import net.jetalab.spreinglab08.dao.BoardDAO;
import net.jetalab.spreinglab08.dto.BoardDTO;
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
@MapperScan(basePackages = "net.jetalab.spreinglab08.dao")
public class BoardController {

    @Autowired
    private BoardDAO boardDAO;

    @RequestMapping(value = "/board", method = RequestMethod.POST)
    public ResponseEntity<BoardDTO> postUsers(BoardDTO board) throws Exception {
        if ((board.getAuthor() == null) || (board.getContents() == null) || (board.getPassword() == null) || (board.getTitle() == null)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        boardDAO.newBoard(board);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @RequestMapping(value = "/board/{seq}", method = RequestMethod.GET)
    public ResponseEntity<BoardDTO> getUsers(@PathVariable("seq") final int seq) throws Exception {
        BoardDTO param = new BoardDTO();
        param.setSeq(seq);

        /* TODO: 조회수 증가 */

        BoardDTO board = boardDAO.getBoard(param);

        if (board == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @RequestMapping(value = "/board/{seq}", method = RequestMethod.PUT)
    public ResponseEntity<BoardDTO> putUsers(@PathVariable("seq") final int seq, BoardDTO param) throws Exception {
        if ((param.getAuthor() == null) || (param.getContents() == null) || (param.getPassword() == null) || (param.getTitle() == null)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        param.setSeq(seq); // 조회할 게시물 번호 지정
        BoardDTO board = boardDAO.getBoard(param);
        if (board == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        board.setTitle(param.getTitle());
        board.setContents(param.getContents());
        board.setAuthor(param.getAuthor());
        boardDAO.editBoard(board);

        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @RequestMapping(value = "/board/{seq}", method = RequestMethod.DELETE)
    public ResponseEntity<BoardDTO> deleteUsers(@PathVariable("seq") final int seq, BoardDTO param) throws Exception {
        if (param.getPassword() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        param.setSeq(seq); // 조회할 게시물 번호 지정
        BoardDTO board = boardDAO.getBoard(param);
        if (board == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        board.setDeleted("Y");
        boardDAO.editBoard(board);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
