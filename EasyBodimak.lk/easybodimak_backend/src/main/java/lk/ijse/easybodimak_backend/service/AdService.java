package lk.ijse.easybodimak_backend.service;


import lk.ijse.easybodimak_backend.dto.AdDTO;

import java.util.List;
import java.util.Queue;

public interface AdService {

    public void saveAd(AdDTO adDTO);

    void updateAd(String ad_id, AdDTO adDTO);

    void approveAd(String ad_id, AdDTO adDTO);

    void deleteAd(String ad_id);

    AdDTO findAd(String ad_id);

    List<AdDTO> getAllAds();

    List<AdDTO>AdsinCity(String location);

    List<AdDTO> findAdsLike(String category,String location,int bedrooms,int bathrooms);

    List<AdDTO> getNotApprovedAds();

    List<AdDTO> getApprovedAds();

    long getAdsCount();

}
