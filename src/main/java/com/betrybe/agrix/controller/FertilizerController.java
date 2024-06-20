package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.FertilizerDto;
import com.betrybe.agrix.model.entity.Fertilizer;
import com.betrybe.agrix.service.FertilizerService;
import com.betrybe.agrix.service.exception.FertilizerNotFoundException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller by Fertilizer.
 */
@RestController
@RequestMapping("/fertilizers")
public class FertilizerController {

  private final FertilizerService fertilizerService;

  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  /**
   * Create Fertilizer.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FertilizerDto save(@RequestBody FertilizerDto fertilizer) {
    Fertilizer saverdFertilizer = fertilizerService.create(fertilizer.toEntity());
    return FertilizerDto.fromEntity(saverdFertilizer);
  }

  /**
   * Get list from Fertilizer.
   */
  @GetMapping
  public List<FertilizerDto> findAll() {
    List<Fertilizer> fertilizers = fertilizerService.findAll();
    return fertilizers.stream()
        .map(FertilizerDto::fromEntity)
        .toList();
  }

  @GetMapping("/{fertilizerId}")
  public FertilizerDto findById(@PathVariable("fertilizerId") long fertilizerId)
      throws FertilizerNotFoundException {
    Fertilizer fertilizer = fertilizerService.findById(fertilizerId);
    return FertilizerDto.fromEntity(fertilizer);
  }
}
