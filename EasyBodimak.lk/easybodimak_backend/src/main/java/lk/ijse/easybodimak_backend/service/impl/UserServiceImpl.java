package lk.ijse.easybodimak_backend.service.impl;
import lk.ijse.easybodimak_backend.dto.UserDTO;
import lk.ijse.easybodimak_backend.entity.User;
import lk.ijse.easybodimak_backend.repository.UserRepository;
import lk.ijse.easybodimak_backend.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveUser(UserDTO userDTO) {
//        if(userRepository.existsById(userDTO.getEmail())){
//            System.out.println("gona");
//            throw new RuntimeException("Email is Already Registered");
//        }
            System.out.println(userDTO.toString());
            User user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setName(userDTO.getName());
            user.setAddress(userDTO.getAddress());
            user.setEmail(userDTO.getEmail());
            user.setTel(userDTO.getTel());
            user.setRegisterDate(new Date().toString());

            //encript password
            String password = userDTO.getPassword();
            String result = DigestUtils.md5Hex(password);
            System.out.println(result);

            //if (result = e10adc3949ba59abbe56e057f20f883e)


            user.setPassword(result);
            userRepository.save(user);


    }

    @Override
    public void updateUser(String id, UserDTO userDTO) {
        if(userDTO.getId() != "") {
            throw new RuntimeException("User ID mismatched");
        }if(userRepository.existsById(id)){
            User user = new User();
            user.setId(userDTO.getId());
            user.setName(userDTO.getName());
            user.setAddress(userDTO.getAddress());
            user.setEmail(userDTO.getEmail());
            user.setTel(userDTO.getTel());
            user.setRegisterDate(userDTO.getRegisterDate());
            String password = userDTO.getPassword();
            String result = DigestUtils.md5Hex(password);
            System.out.println(result);
            user.setPassword(result);
            userRepository.save(user);
        }else{
            throw new RuntimeException("Customer Doesn't exist!!");
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO>userDTOS = new ArrayList<>();
        users.forEach(c -> userDTOS.add(new UserDTO(
                c.getId(),
                c.getEmail(),
                c.getName(),
                c.getAddress(),
                c.getTel(),
                c.getRegisterDate(),
                c.getPassword()
        )));
        return userDTOS;
    }

    @Override
    public UserDTO findUser(String id) {
        User user = userRepository.findById(id).get();
        return new UserDTO(user.getId(),user.getEmail(),user.getName(),user.getAddress(),user.getTel(),user.getRegisterDate(),user.getPassword());

    }


    @Override
    public long getUsersCount() {
        return userRepository.count();
    }



}
