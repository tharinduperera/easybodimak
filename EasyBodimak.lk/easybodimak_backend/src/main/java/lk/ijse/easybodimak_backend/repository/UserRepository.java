package lk.ijse.easybodimak_backend.repository;

import lk.ijse.easybodimak_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

//    @Query("SELECT c FROM User c WHERE c.email LIKE #{[0} AND c.password LIKE #{[0}")
//    public void userLogin(String email,String password);
//
//    @Query("SELECT c FROM User c WHERE c.name LIKE #{[0}")
//    List<User> letsFindSomeUsers(String name);
}
