package com.example.springgradle.entities;

import com.example.springgradle.common.model.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class ChucVuCanBo extends Auditable {

    /*@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ISEQ$$_216832", allocationSize = 1)
    private long id;*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenChucVu;
    private String tenVietTat;
    private int trangThai = 1;
}
