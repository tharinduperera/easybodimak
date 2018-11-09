package lk.ijse.easybodimak_backend.service.impl;

import lk.ijse.easybodimak_backend.dto.AdminDTO;
import lk.ijse.easybodimak_backend.entity.Admin;
import lk.ijse.easybodimak_backend.repository.AdminRepository;
import lk.ijse.easybodimak_backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<AdminDTO> getAllAdmin() {
        List<Admin> admin = adminRepository.findAll();
        List<AdminDTO>adminDTOS = new ArrayList<>();
        admin.forEach(c -> adminDTOS.add(new AdminDTO(
                c.getAemail(),
                c.getAname(),
                c.getAaddress(),
                c.getAtel(),
                c.getPassword()
        )));
        return adminDTOS;
    }
}
