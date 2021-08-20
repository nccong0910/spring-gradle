package com.example.springgradle.repositories;

import com.example.springgradle.entities.CapBacCanBo;
import com.example.springgradle.entities.ChucVuCanBo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CapBacCanBoRepository extends JpaRepository<CapBacCanBo, Long> {

    @Query("select distinct r from CapBacCanBo r where r.tenCapBac=:tenCapBac and r.trangThai=1")
    CapBacCanBo getByTenCapBac(String tenCapBac);

    Page<CapBacCanBo> findByTrangThaiEqualsOrderById(int trangThai, Pageable pageable);

    @Modifying
    @Query("delete from CapBacCanBo where id=:id")
    int deleteById(long id);
}
