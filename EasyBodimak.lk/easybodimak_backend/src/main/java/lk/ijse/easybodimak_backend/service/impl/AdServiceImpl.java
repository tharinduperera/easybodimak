package lk.ijse.easybodimak_backend.service.impl;
import lk.ijse.easybodimak_backend.dto.AdDTO;
import lk.ijse.easybodimak_backend.entity.Ad;
import lk.ijse.easybodimak_backend.repository.AdRepository;
import lk.ijse.easybodimak_backend.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AdServiceImpl implements AdService {

    @Autowired
    private AdRepository adRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveAd(AdDTO adDTO) {
        Ad ad=new Ad();
        ad.setAd_id(UUID.randomUUID().toString());
        ad.setTitle(adDTO.getTitle());
        ad.setAd_date(new Date().toString());
        ad.setCategory(adDTO.getCategory());
        ad.setDescription(adDTO.getDescription());
        ad.setLocation(adDTO.getLocation());
        ad.setImage(adDTO.getImage());
        ad.setMap(adDTO.getMap());
        ad.setNoOfBathrooms(adDTO.getNoOfBathrooms());
        ad.setNoOfBedrooms(adDTO.getNoOfBedrooms());
        ad.setPrice(adDTO.getPrice());
        ad.setuUserid(adDTO.getUserid());
        ad.setStatus("Approved");
        adRepository.save(ad);
 }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateAd(String ad_id, AdDTO adDTO) {
        if (!adDTO.getAd_id().equals(ad_id)) {
            throw new RuntimeException("Ad ID mismatched");
        }
        if (adRepository.existsById(ad_id)) {
            Ad ad= new Ad();
            ad.setAd_id(adDTO.getAd_id());
            ad.setTitle(adDTO.getTitle());
            ad.setAd_date(new Date().toString());
            ad.setLocation(adDTO.getLocation());
            ad.setCategory(adDTO.getCategory());
            ad.setDescription(adDTO.getDescription());
            ad.setNoOfBathrooms(adDTO.getNoOfBathrooms());
            ad.setNoOfBedrooms(adDTO.getNoOfBedrooms());
            ad.setPrice(adDTO.getPrice());
            ad.setMap(adDTO.getMap());
            ad.setImage(adDTO.getImage());
            ad.setStatus("NotApproved");
            adRepository.save(ad);
        }else{
            throw new RuntimeException("Ad doesn't exist");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void approveAd(String ad_id, AdDTO adDTO) {
        if (!adDTO.getAd_id().equals(ad_id)) {
            System.out.println(ad_id);
            throw new RuntimeException("Ad ID mismatched");
        }
        if (adRepository.existsById(ad_id)) {
            Ad ad= new Ad();
            ad.setAd_id(adDTO.getAd_id());
            ad.setTitle(adDTO.getTitle());
            ad.setAd_date(new Date().toString());
            ad.setLocation(adDTO.getLocation());
            ad.setCategory(adDTO.getCategory());
            ad.setuUserid(adDTO.getUserid());
            ad.setDescription(adDTO.getDescription());
            ad.setNoOfBathrooms(adDTO.getNoOfBathrooms());
            ad.setNoOfBedrooms(adDTO.getNoOfBedrooms());
            ad.setPrice(adDTO.getPrice());
            ad.setMap(adDTO.getMap());
            ad.setImage(adDTO.getImage());
            ad.setStatus("Approved");
            adRepository.save(ad);
        }else{
            throw new RuntimeException("Ad doesn't exist");
        }

    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteAd(String ad_id) {
        adRepository.deleteById(ad_id);
    }

    @Override
    public AdDTO findAd(String ad_id) {
        Ad ad = adRepository.findById(ad_id).get();
        return new AdDTO(ad.getAd_id(),ad.getUserid(),ad.getTitle(),ad.getAd_date(),ad.getDescription(),ad.getLocation(),ad.getCategory(),  ad.getNoOfBedrooms(),ad.getNoOfBathrooms(),ad.getPrice(),ad.getMap(),ad.getImage(),ad.getStatus());
    }

    @Override
    public List<AdDTO> getAllAds() {
        List<Ad> ads = adRepository.findAll();
        List<AdDTO>adDTOS = new ArrayList<>();
        ads.forEach(c -> adDTOS.add(new AdDTO(
                c.getAd_id(),
                c.getUserid(),
                c.getTitle(),
                c.getAd_date(),
                c.getDescription(),
                c.getLocation(),
                c.getCategory(),
                c.getNoOfBedrooms(),
                c.getNoOfBathrooms(),
                c.getPrice(),
                c.getMap(),
                c.getImage(),
                c.getStatus()
        )));
        return adDTOS;
    }

    @Override
    public List<AdDTO> findAdsLike(String category,String location,int bedrooms,int bathrooms) {
        List<Ad> allAds =  adRepository.findAll();
        List<AdDTO> dtos = new ArrayList<>();
        for (Ad ad:allAds) {
            if (ad.getCategory().equals(category)) {
                if (ad.getLocation().equals(location)) {
                    if (ad.getNoOfBedrooms()==bedrooms) {
                        if (ad.getNoOfBathrooms()==bathrooms) {
                            dtos.add(new AdDTO(ad.getAd_id(),ad.getUserid(), ad.getTitle(), ad.getAd_date(), ad.getDescription(), ad.getLocation(), ad.getCategory(), ad.getNoOfBedrooms(), ad.getNoOfBathrooms(), ad.getPrice(), ad.getMap(), ad.getImage(), ad.getStatus()));
                        }
                    }
                }
            }
        }
        return dtos;
    }

    @Override
    public List<AdDTO> getNotApprovedAds() {
        List<Ad> allAds =  adRepository.findAll();
        List<AdDTO> dtos = new ArrayList<>();
        for (Ad ad:allAds) {
            if (ad.getStatus().equals("NotApproved")) {
                dtos.add(new AdDTO(ad.getAd_id(),ad.getUserid(), ad.getTitle(), ad.getAd_date(), ad.getDescription(), ad.getLocation(), ad.getCategory(), ad.getNoOfBedrooms(), ad.getNoOfBathrooms(), ad.getPrice(), ad.getMap(), ad.getImage(), ad.getStatus()));
            }
        }
        return dtos;
    }

    @Override
    public List<AdDTO> getApprovedAds() {
        List<Ad> allAds =  adRepository.findAll();
        List<AdDTO> dtos = new ArrayList<>();
        for (Ad ad:allAds) {
            if (ad.getStatus().equals("Approved")) {
                List<Date>dates=new ArrayList<>();
                try {
                    Date parse = new SimpleDateFormat("E MMM dd hh:mm:ss Z yyyy").parse(ad.getAd_date());
                    dates.add(parse);
                    Collections.sort(dates);
                    System.out.println(dates);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                dtos.add(new AdDTO(ad.getAd_id(),ad.getUserid(),ad.getTitle(), ad.getAd_date(), ad.getDescription(), ad.getLocation(), ad.getCategory(), ad.getNoOfBedrooms(), ad.getNoOfBathrooms(), ad.getPrice(), ad.getMap(), ad.getImage(), ad.getStatus()));
            }
        }
        return dtos;
    }

    @Override
    public List<AdDTO> AdsinCity(String location) {
        List<Ad> allAds =  adRepository.findAll();
        List<AdDTO> dtos = new ArrayList<>();
        for (Ad ad:allAds) {
            if (ad.getLocation().equals(location)) {
                dtos.add(new AdDTO(ad.getAd_id(),ad.getUserid(), ad.getTitle(), ad.getAd_date(), ad.getDescription(), ad.getLocation(), ad.getCategory(), ad.getNoOfBedrooms(), ad.getNoOfBathrooms(), ad.getPrice(), ad.getMap(), ad.getImage(), ad.getStatus()));
            }
        }
        return dtos;
    }

//    @Override
//    public List<AdDTO> findAdsLike(String name) {
//        List<Ad> allAds =  adRepository.letsFindSomeAds(name + "%", name + "%",Integer.parseInt(name),Integer.parseInt(name));
//        List<AdDTO> dtos = new ArrayList<>();
//        allAds.forEach(ad -> dtos.add(new AdDTO(ad.getAd_id(),ad.getAd_date(),ad.getDescription(),ad.getLocation(),ad.getCategory(),ad.getNoOfBedrooms(),ad.getNoOfBathrooms(),ad.getPrice(),ad.getMap(),ad.getImage())));
//        return dtos;
//    }

    @Override
    public long getAdsCount() {
        return adRepository.count();
    }


}

