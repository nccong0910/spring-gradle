package com.example.springgradle.controllers;

import com.example.springgradle.common.errors.Exeptions;
import com.example.springgradle.common.reponse.PageResponse;
import com.example.springgradle.entities.CapBacCanBo;
import com.example.springgradle.services.CapBacCanBoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/cap-bac/")
public class CapBacCanBoController {

    @Autowired
    private CapBacCanBoService service;

    @GetMapping("")
    public PageResponse<CapBacCanBo> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        var formPage = service.list(page, size);
        return new PageResponse<>(formPage.getNumber(), formPage.getNumberOfElements(), formPage.getTotalPages(), formPage.getContent());
    }

    @PostMapping("")
    CapBacCanBo create(@RequestBody CapBacCanBo input) throws Exception {
        return service.create(input);
    }

    @GetMapping("/{id}")
    public CapBacCanBo get(@PathVariable Long id) throws Exception {
        return service.get(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody CapBacCanBo objInput) {
        try {
            service.update(objInput);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exeptions exeptions) {
            exeptions.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        service.remove(id);
    }
}
