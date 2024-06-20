package com.betrybe.agrix.service;

import com.betrybe.agrix.model.entity.Farm;
import com.betrybe.agrix.model.repository.FarmRepository;
import com.betrybe.agrix.service.exception.FarmNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service by Farm.
 */
@Service
public class FarmService {

  private final FarmRepository farmRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  public Farm findById(long id) throws FarmNotFoundException {
    return farmRepository.findById(id)
        .orElseThrow(FarmNotFoundException::new);
  }

  public List<Farm> findAll() {
    return farmRepository.findAll();
  }

  public Farm create(Farm farm) {
    return farmRepository.save(farm);
  }
}
