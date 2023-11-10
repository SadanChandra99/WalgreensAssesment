package com.walgreens.pcs.assesment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.walgreens.pcs.assesment.entity.Assesment;

@Repository
public interface AssesmentRepository extends JpaRepository<Assesment, Long>{

}
