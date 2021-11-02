package com.renfa.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.renfa.model.Watchlist;
//import com.renfa.repository.WatchlistRepository;

@Service
public class WatchlistService {
  //@Autowired
  //WatchlistRepository repository;

  public List<Watchlist> getAllWatchlist() {
   // return repository.findAll();
   return null;
  }
}
