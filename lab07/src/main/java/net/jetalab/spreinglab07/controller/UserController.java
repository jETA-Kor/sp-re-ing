package net.jetalab.spreinglab07.controller;

import net.jetalab.spreinglab07.dao.UserDAO;
import net.jetalab.spreinglab07.dto.UserDTO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@MapperScan(basePackages = "net.jetalab.spreinglab07.dao")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/users")
    public List<UserDTO> users(@RequestParam(value = "country", defaultValue = "") String country, @RequestParam(value = "name", defaultValue = "") String name, @RequestParam(value = "seq", defaultValue = "0") int seq) throws Exception {
        final UserDTO param = new UserDTO(seq, name, country);
        final List<UserDTO> userList = userDAO.selectUsers(param);
        return userList;
    }

    @RequestMapping("/seq")
    public List<Integer> seq(@RequestParam(value = "country", defaultValue = "") String country, @RequestParam(value = "name", defaultValue = "") String name, @RequestParam(value = "seq", defaultValue = "0") int seq) throws Exception {
        final UserDTO param = new UserDTO(seq, name, country);
        final List<Integer> seqList = userDAO.selectUserSeq(param);
        return seqList;
    }

}
