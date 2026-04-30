package com.example.demo.repository.jpa;

import com.example.demo.entity.jpa.DipAllotment;
import com.example.demo.entity.jpa.DipAllotmentId;
import com.example.demo.util.QueryConstant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DipAllotmentRepository extends JpaRepository<DipAllotment, DipAllotmentId> {

    @Query(QueryConstant.GET_USER_ID_FROM_ADHAR_ID)
    List<Integer> getUseIDFromAdharForFiveMonth(@Param("aadharId") String aadharId);

}
