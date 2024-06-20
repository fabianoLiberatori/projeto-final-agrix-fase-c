package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.model.entity.Farm;
import com.betrybe.agrix.model.entity.Fertilizer;

/**
 * Methords fromEntity'n'toDTO by Fertilizer.
 */
public record FertilizerDto(
    Long id,
    String name,
    String brand,
    String composition
) {

  /**
   * Returns by Entity to DTO.
   */
  public static FertilizerDto fromEntity(Fertilizer fertilizer) {
    return new FertilizerDto(
        fertilizer.getId(),
        fertilizer.getName(),
        fertilizer.getBrand(),
        fertilizer.getComposition()
    );
  }

  /**
   * Returns by DTO to Entity.
   */
  public Fertilizer toEntity() {
    Fertilizer fertilizer = new Fertilizer();
    fertilizer.setName(name);
    fertilizer.setBrand(brand);
    fertilizer.setComposition(composition);
    return fertilizer;
  }
}
