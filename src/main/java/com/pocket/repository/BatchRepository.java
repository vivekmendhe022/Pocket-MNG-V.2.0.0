package com.pocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pocket.entity.Batch;

public interface BatchRepository extends JpaRepository<Batch, Long>{

}
