package com.demo.cinema.repository;

import com.demo.cinema.dto.SuatChieuView;
import com.demo.cinema.model.SuatChieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISuatChieuRepository extends JpaRepository<SuatChieu, Integer> {

    @Query(value = "select sc.id, sc.code, sc.amount, sc.ngay_chieu as ngayChieu, sc.ten_suat_chieu as tenSuatChieu, tp.name as tenPhim from suat_chieu sc join ten_phim tp on sc.ten_phim_id = tp.id where sc.flag = true and sc.ngay_chieu like concat('%', :ngayChieu,'%') and tp.name like concat('%',:tenPhim,'%') and sc.code like concat('%', :code,'%')",
            countQuery = "select * from (select sc.id, sc.code, sc.amount, sc.ngay_chieu as ngayChieu, sc.ten_suat_chieu as tenSuatChieu, tp.name as tenPhim from suat_chieu sc join ten_phim tp on sc.ten_phim_id = tp.id where sc.flag = true and sc.ngay_chieu like concat('%', :ngayChieu,'%') and tp.name like concat('%',:tenPhim,'%') and sc.code like concat('%', :code,'%')) as countPage",
            nativeQuery = true)
    Page<SuatChieuView> search(@Param("ngayChieu") String ngayChieu, @Param("tenPhim") String tenPhim, @Param("code") String code, Pageable pageable);

    Page<SuatChieu> findAll(Pageable pageable);

    SuatChieu findByCode(String code);
//    List<SuatChieu> findAll();

//    @Modifying
//    @Transactional
//    @Query(value = "update suat_chieu sc set sc.flag = false where sc.id in (:intergers)", nativeQuery = true)
//    Optional<List<SuatChieu>> softDeleteAllIds(List<Integer> integers);
}
