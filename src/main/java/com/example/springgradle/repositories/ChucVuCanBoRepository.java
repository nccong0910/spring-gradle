package com.example.springgradle.repositories;

import com.example.springgradle.entities.ChucVuCanBo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChucVuCanBoRepository extends JpaRepository<ChucVuCanBo, Long> {

    @Query("select distinct r from ChucVuCanBo r where r.tenChucVu=:tenChucVu and r.trangThai=1")
    ChucVuCanBo getByTenChucVu(String tenChucVu);

    Page<ChucVuCanBo> findByTrangThaiEqualsOrderById(int trangThai, Pageable pageable);

    @Modifying
    @Query("delete from ChucVuCanBo where id=:id")
    int deleteById(long id);
}
