package com.tamil.cloudimage.repository;

import com.tamil.cloudimage.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataJPA extends JpaRepository<Data,Integer> {
}
