package net.jetalab.spreinglab10.dao;

import net.jetalab.spreinglab10.dto.BoardDTO;
import net.jetalab.spreinglab10.dto.ListDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("boardDAO")
public class BoardDAO {
    @Autowired
    protected SqlSessionTemplate sqlSession;

    public int newBoard(BoardDTO param) throws Exception {
        return sqlSession.insert("newBoard", param);
    }

    public BoardDTO getBoard(BoardDTO param) throws Exception {
        return sqlSession.selectOne("getBoard", param);
    }

    public int editBoard(BoardDTO param) throws Exception {
        return sqlSession.update("editBoard", param);
    }

    public int addBoardReadCount(BoardDTO param) throws Exception {
        return sqlSession.update("addBoardReadCount", param);
    };

    public List<BoardDTO> getBoardList(ListDTO param) throws Exception {
        if (param.getLastSeq() > 0) {
            return sqlSession.selectList("getBoardListNext", param);
        } else {
            return sqlSession.selectList("getBoardListPage", param);
        }
    }
}