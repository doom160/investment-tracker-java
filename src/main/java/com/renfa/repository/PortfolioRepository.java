package com.renfa.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.renfa.model.Equity;

public interface PortfolioRepository extends JpaRepository<Equity, Long> {

    @Query(value = "SELECT e FROM equity e WHERE e.id = ?1")
    Equity findById(String id);

    @Query(value = "SELECT e FROM equity e WHERE e.ticker = ?1")
    List<Equity> findByTicker(String id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM equity e WHERE e.id = ?1")
    void deleteById(String id);
}