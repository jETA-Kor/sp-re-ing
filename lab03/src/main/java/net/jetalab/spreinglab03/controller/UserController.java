package net.jetalab.spreinglab03.controller;

import net.jetalab.spreinglab03.dao.UserDAO;
import net.jetalab.spreinglab03.dto.UserDTO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@MapperScan(basePackages = "net.jetalab.spreinglab03.dao")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/users")
    public List<UserDTO> users(@RequestParam(value = "country", defaultValue = "") String country) throws Exception {
        final UserDTO param = new UserDTO(0, null, country);
        final List<UserDTO> userList = userDAO.selectUsers(param);
        return userList;
    }
    
}
