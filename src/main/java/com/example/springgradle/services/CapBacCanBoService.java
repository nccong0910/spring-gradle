package com.example.springgradle.services;

import com.example.springgradle.common.errors.Errors;
import com.example.springgradle.common.errors.Exeptions;
import com.example.springgradle.entities.CapBacCanBo;
import com.example.springgradle.repositories.CapBacCanBoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CapBacCanBoService {

    @Autowired
    private CapBacCanBoRepository repository;

    public Page<CapBacCanBo> list(int page, int size) {
        PageRequest PageElements = PageRequest.of(page, size);
        return repository.findByTrangThaiEqualsOrderById(1, PageElements);
    }

    public CapBacCanBo create(CapBacCanBo input) throws Exception {
        var canBo = repository.getByTenCapBac(input.getTenCapBac());
        if (canBo != null) {
            throw new Exeptions(Errors.RESOURCE_EXISTED, "Biểu mẫu đã tồn tại");
        }
        canBo = new CapBacCanBo();
        canBo.setTenCapBac(input.getTenCapBac());
        canBo.setCapBac(input.getCapBac());
        canBo.setTrangThai(1);
        return repository.save(input);
    }

    public CapBacCanBo get(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exeptions(Errors.NOT_FOUND, "danh mục không tồn tại"));
    }

    @Transactional
    public CapBacCanBo update(CapBacCanBo objInput) throws Exeptions {
        var canBo = repository.findById(objInput.getId()).orElseThrow(()
                -> new Exeptions(Errors.NOT_FOUND, "Không tìm thấy danh mục"));
        if (objInput.getTenCapBac().isEmpty() || objInput.getCapBac().isEmpty()) {
            throw new Exeptions(Errors.ERR_NOT_NULL, "Tên cấp bậc, cấp bậc không được để trống");
        }
        canBo.setTenCapBac(objInput.getTenCapBac());
        canBo.setCapBac(objInput.getCapBac());
        canBo.setTrangThai(1);
        return canBo;
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }
}
