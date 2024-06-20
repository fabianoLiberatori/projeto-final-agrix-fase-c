package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.model.entity.Farm;

/**
 * Methords fromEntity'n'toDTO by Farm.
 */
public record FarmDto(
    Long id,
    String name,
    Double size
) {

  /**
   * Returns by Entity to DTO.
   */
  public static FarmDto fromEntity(Farm farm) {
    return new FarmDto(
        farm.getId(),
        farm.getName(),
        farm.getSize()
    );
  }

  /**
   * Returns by DTO to Entity.
   */
  public Farm toEntity() {
    Farm farm = new Farm();
    farm.setName(name);
    farm.setSize(size);
    return farm;
  }
}
