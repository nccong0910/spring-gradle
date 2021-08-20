package com.example.springgradle.services;

import com.example.springgradle.common.errors.Errors;
import com.example.springgradle.common.errors.Exeptions;
import com.example.springgradle.entities.ChucVuCanBo;
import com.example.springgradle.repositories.ChucVuCanBoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChucVuCanBoService {

    @Autowired
    private ChucVuCanBoRepository repository;

    public Page<ChucVuCanBo> list(int page, int size) {
        PageRequest PageElements = PageRequest.of(page, size);
        return repository.findByTrangThaiEqualsOrderById(1, PageElements);
    }

    public ChucVuCanBo create(ChucVuCanBo input) throws Exception {
        var canBo = repository.getByTenChucVu(input.getTenChucVu());
        if (canBo != null) {
            throw new Exeptions(Errors.RESOURCE_EXISTED, "Biểu mẫu đã tồn tại");
        }
        canBo = new ChucVuCanBo();
        canBo.setTenChucVu(input.getTenChucVu());
        canBo.setTenVietTat(input.getTenVietTat());
        canBo.setTrangThai(1);
        return repository.save(input);
    }

    public ChucVuCanBo get(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exeptions(Errors.NOT_FOUND, "danh mục không tồn tại"));
    }

    @Transactional
    public ChucVuCanBo update(ChucVuCanBo objInput) throws Exeptions {
        var canBo = repository.findById(objInput.getId()).orElseThrow(()
                -> new Exeptions(Errors.NOT_FOUND, "Không tìm thấy danh mục"));
        if (objInput.getTenChucVu().isEmpty() || objInput.getTenVietTat().isEmpty()) {
            throw new Exeptions(Errors.ERR_NOT_NULL, "Tên chức vụ, tên viết tắt không được để trống");
        }
        canBo.setTenChucVu(objInput.getTenChucVu());
        canBo.setTenVietTat(objInput.getTenVietTat());
        canBo.setTrangThai(1);
        return canBo;
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }
}
