package lk.ijse.easybodimak_backend.repository;

import lk.ijse.easybodimak_backend.entity.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository extends JpaRepository<Ad,String> {

//    @Query("SELECT c FROM Ad c WHERE c.location LIKE #{[0} and  c.category LIKE #{[0} and c.noOfBedrooms LIKE #{[0} and c.noOfBathrooms LIKE #{[0}")
//    List<Ad> letsFindSomeAds(String location, String category, int noOfBedrooms, int noOfBathrooms) ;
//
//    @Query("SELECT c FROM Ad c WHERE c.location LIKE #{[0}")
//    List<Ad> AdsinCity(String location);

//      @Query("SELECT c FROM Ad c WHERE c.status LIKE #{[0}")
//      List<Ad>getNotApprovedAds(String status);
}
