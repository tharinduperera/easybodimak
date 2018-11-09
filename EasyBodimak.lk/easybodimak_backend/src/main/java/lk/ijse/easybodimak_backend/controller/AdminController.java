package lk.ijse.easybodimak_backend.controller;
import lk.ijse.easybodimak_backend.dto.AdminDTO;
import lk.ijse.easybodimak_backend.dto.AdminLoginDto;
import lk.ijse.easybodimak_backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public boolean adminLogin(@RequestBody AdminLoginDto adminLoginDto) {
        List<AdminDTO> allUsers = adminService.getAllAdmin();
        boolean admin = false;
        for (AdminDTO adminDTO : allUsers) {
            System.out.println(adminDTO.getAemail());
            System.out.println(adminDTO.getPassword());
            if (adminDTO.getAemail().equals(adminLoginDto.getEmail())) {
                if (adminDTO.getPassword().equals(adminLoginDto.getPassword())) {
                    admin = true;
                } else {
                    admin = false;
                }
            }
        }
        return admin;
    }



}
