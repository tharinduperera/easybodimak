package lk.ijse.easybodimak_backend.service;

import lk.ijse.easybodimak_backend.dto.UserDTO;

import java.util.List;

public interface UserService {

    public void saveUser(UserDTO userDTO);
    public void updateUser(String id,UserDTO userDTO);
    public List<UserDTO>getAllUsers();
    UserDTO findUser(String id);
    //public List<UserDTO> findUsersLike(String name);
    public  long getUsersCount();

}
