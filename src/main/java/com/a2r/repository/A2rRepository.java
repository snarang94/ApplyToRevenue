package com.a2r.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.a2r.model.A2rEntity;

@Repository
public interface A2rRepository extends JpaRepository<A2rEntity, Long>{

}
