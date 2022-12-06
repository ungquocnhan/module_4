package com.practice.management_phone.repository;

import com.practice.management_phone.model.Smartphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ISmartphoneRepository extends JpaRepository<Smartphone, Integer> {
    @Query(value = "select * from smartphones where flag = 1", nativeQuery = true)
    Page<Smartphone> findAllFlag(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update smartphones set flag = 0 where id = :id", nativeQuery = true)
    void updateFlag(@Param("id") int id);
}
