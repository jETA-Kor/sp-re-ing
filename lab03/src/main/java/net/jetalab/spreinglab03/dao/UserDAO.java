package net.jetalab.spreinglab03.dao;

import net.jetalab.spreinglab03.dto.UserDTO;

import java.util.List;

public interface UserDAO {
    List<UserDTO> selectUsers(UserDTO param) throws Exception;
}
