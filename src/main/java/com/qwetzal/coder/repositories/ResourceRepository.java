package com.qwetzal.coder.repositories;

import com.qwetzal.coder.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource,Long> {
    
    List<Resource> findAllByDeletedAtNull();
}
