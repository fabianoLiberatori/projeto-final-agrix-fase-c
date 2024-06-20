package com.betrybe.agrix.service;

import com.betrybe.agrix.model.entity.Fertilizer;
import com.betrybe.agrix.model.repository.FertilizerRepository;
import com.betrybe.agrix.service.exception.FertilizerNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service by Fertilizer.
 */
@Service
public class FertilizerService {

  private final FertilizerRepository fertilizerRepository;

  @Autowired
  public FertilizerService(FertilizerRepository fertilizerRepository) {
    this.fertilizerRepository = fertilizerRepository;
  }

  public Fertilizer create(Fertilizer fertilizer) {
    return fertilizerRepository.save(fertilizer);
  }

  public List<Fertilizer> findAll() {
    return fertilizerRepository.findAll();
  }

  public Fertilizer findById(long id) throws FertilizerNotFoundException {
    return fertilizerRepository.findById(id)
        .orElseThrow(FertilizerNotFoundException::new);
  }
}
