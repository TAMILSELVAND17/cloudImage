package com.tamil.cloudimage.entity;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Datas")
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dataIdl;

    private String dataName;

    private String dataImage;
}
