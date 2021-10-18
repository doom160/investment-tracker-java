package com.renfa.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.domain.Pageable;

import com.renfa.model.Watchlist;

public interface WatchlistRepository extends JpaRepository<User, Long> {

    @Query(value = "UPDATE Watchlist set last_updated = CURRENT_TIMESTAMP where w.ticker = ?1")
    List<User> updateWatchlistLastUpdate(String ticker);

    @Query(value = "SELECT * FROM Watchlist w WHERE w.ticker = ?1")
    List<User> findById(String ticker);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Watchlist w WHERE w.ticker = ?1")
    void deleteById(String ticker);
}
