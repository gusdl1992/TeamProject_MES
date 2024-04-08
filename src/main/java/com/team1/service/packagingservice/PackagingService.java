package com.team1.service.packagingservice;

import com.team1.model.dto.packagingdto.PackagingDto;
import com.team1.model.entity.PackagingEntity;
import com.team1.model.repository.PackagingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PackagingService {
    @Autowired
    private PackagingRepository packagingRepository;

    public List<PackagingEntity> doPackInfoGet(int pgno) {




        return null;
    }
}
