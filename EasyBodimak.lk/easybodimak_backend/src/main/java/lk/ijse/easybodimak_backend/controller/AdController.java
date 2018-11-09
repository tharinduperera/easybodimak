package lk.ijse.easybodimak_backend.controller;

import lk.ijse.easybodimak_backend.dto.AdDTO;
import lk.ijse.easybodimak_backend.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ads")
public class AdController {

    private  static  String UPLOAD_DIR = "images";

    @Autowired
    private AdService adService;

//    //save img
//    @PostMapping
//    public void saveImg(@RequestParam("file") MultipartFile file , HttpServletRequest request){
//        System.out.println("sdfds");
//
////        try {
////
////            String orgFileName = file.getOriginalFilename();
////            String path = request.getServletContext().getRealPath("")+ UPLOAD_DIR + "/customers" + File.separator + orgFileName;
////            InputStream inputStream = file.getInputStream();
////
////            saveFile(inputStream , path);
////
////        } catch (Exception e) {
////            e.printStackTrace();
////            throw new RuntimeException(e);
////        }
//
//    }

//    private void saveFile(InputStream inputStream, String path) {
//
//        File targetFile = new File(path);
//
//        try {
//            java.nio.file.Files.copy(
//                    inputStream,
//                    targetFile.toPath(),
//                    StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        IOUtils.closeQuietly(inputStream);
//    }

    @PutMapping
    public void saveAd(@RequestBody AdDTO adDTO) {
        adService.saveAd(adDTO);
    }

    @DeleteMapping("/{ad_id}")
    public void deleteAd(@PathVariable("ad_id") String ad_id){
        adService.deleteAd(ad_id);
    }

    @PostMapping("/{ad_id}")
    public void updateAd(@PathVariable("ad_id") String ad_id,
                               @RequestBody AdDTO adDTO){
        adService.updateAd(ad_id, adDTO);
    }

    @PutMapping("/{ad_id}")
    public void approveAd(@PathVariable("ad_id") String ad_id,
                         @RequestBody AdDTO adDTO){
        adService.approveAd(ad_id, adDTO);
    }

    @GetMapping("/{ad_id}")
    public AdDTO findAd(@PathVariable("ad_id") String ad_id){
        System.out.println(ad_id);
        return adService.findAd(ad_id);
    }

    @GetMapping
    public Object findAllAds(@RequestParam(value = "action", required = false) String action
            , @RequestParam(value = "location", required = false) String location) {
        if (action != null) {
            switch (action) {
                case "count":
                    return adService.getAdsCount();
                case "like":
                    return adService.AdsinCity(location);
                default:
                    return adService.getAllAds();
            }
        } else {
            return adService.getAllAds();
        }
    }

    @GetMapping("location/{location}")
     public List<AdDTO>AdsinCity(@PathVariable("location") String location){
        return adService.AdsinCity(location);
    }


    @GetMapping("/notapproved")
    public List<AdDTO> getNotApproved(){
        System.out.println("doneaaa");
        return adService.getNotApprovedAds();
    }

    @GetMapping("/approved")
    public List<AdDTO> getApproved(){
        return adService.getApprovedAds();
    }
}
