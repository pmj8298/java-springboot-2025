package com.pknu.backboard.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pknu.backboard.entity.History;


@Repository
public interface HistoryRepository extends JpaRepository<History, Long>{

    @SuppressWarnings("null")
    Optional<History> findById(Long id);
    
}
