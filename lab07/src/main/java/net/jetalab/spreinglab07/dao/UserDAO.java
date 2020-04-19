package net.jetalab.spreinglab07.dao;

import net.jetalab.spreinglab07.dto.UserDTO;

import java.util.List;

public interface UserDAO {
    List<UserDTO> selectUsers(UserDTO param) throws Exception;
    List<Integer> selectUserSeq(UserDTO param) throws Exception;
}
