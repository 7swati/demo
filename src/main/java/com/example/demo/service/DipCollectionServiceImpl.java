package com.example.demo.service;

import com.example.demo.bean.UserDipRequest;
import com.example.demo.entity.jpa.UserDipDetails;
import com.example.demo.repository.jpa.DipAllotmentRepository;
import com.example.demo.repository.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class DipCollectionServiceImpl implements DipCollectionService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DipAllotmentRepository dipAllotmentRepository;

    @Override
    public void saveUserDipRequest(UserDipRequest request) {
        if (checkIfUserWasAllocatedSlotInFiveMonths(request.adharCardNo())) {
            UserDipDetails user = toEntity(request);
            userRepository.save(user);
        }

    }

    private boolean checkIfUserWasAllocatedSlotInFiveMonths(long adharId) {


        List<Integer> userId = dipAllotmentRepository.getUseIDFromAdharForFiveMonth(String.valueOf(adharId));
        return CollectionUtils.isEmpty(userId) ? true : false;

    }

    public static UserDipDetails toEntity(UserDipRequest request) {
        UserDipDetails user = new UserDipDetails();
        user.setUserName(request.firstName().trim() + " " + request.lastName().trim());
        user.setAadharNo(String.valueOf(request.adharCardNo()));
        user.setMobileNo(String.valueOf(request.mobileNumber()));
        user.setEmailAddress(request.emailAddress().trim().toLowerCase());
        return user;
    }

}

