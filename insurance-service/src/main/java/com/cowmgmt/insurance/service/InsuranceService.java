package com.cowmgmt.insurance.service;

import com.cowmgmt.insurance.model.Insurance;
import com.cowmgmt.insurance.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {
    @Autowired
    private InsuranceRepository repo;

    public Insurance save(Insurance insurance) {

        String resourcePath = getClass().getClassLoader().getResource("").getPath();
        String filePath = resourcePath + "qrcode.png";

        try {
            new QRCodeGenerator().generateQRCodeImage(
                    insurance.getPolicyNumber(), // text to encode
                    300,                       // width
                    300,                       // height
                    filePath               // output file path
            );
            System.out.println("QR Code generated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return repo.save(insurance);
    }

    public List<Insurance> getAll() {
        return repo.findAll();
    }

    public List<Insurance> getByCowId(Long cowId) {
        return repo.findByCowId(cowId);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
