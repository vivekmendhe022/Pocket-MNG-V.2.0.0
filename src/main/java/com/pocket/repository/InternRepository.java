package com.pocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pocket.entity.Intern;

public interface InternRepository extends JpaRepository<Intern, Long> {

}
