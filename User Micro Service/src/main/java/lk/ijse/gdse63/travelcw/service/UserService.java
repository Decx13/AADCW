package lk.ijse.gdse63.travelcw.service;

import lk.ijse.gdse63.travelcw.dto.UserDTO;
import lk.ijse.gdse63.travelcw.exception.CreateFailException;
import lk.ijse.gdse63.travelcw.exception.DeleteFailException;
import lk.ijse.gdse63.travelcw.exception.UpdateFailException;
import lk.ijse.gdse63.travelcw.exception.UserNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserDTO searchUserByEmail(String email) throws UserNotFoundException;
    void  updateUser(UserDTO email) throws UpdateFailException;
    int addUsers(UserDTO email) throws CreateFailException;
    void deleteUser(String email) throws DeleteFailException;

    List<UserDTO> getAll(String email) throws UserNotFoundException;
}