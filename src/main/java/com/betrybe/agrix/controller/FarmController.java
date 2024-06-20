package com.betrybe.agrix.controller;


import com.betrybe.agrix.controller.dto.CropDto;
import com.betrybe.agrix.controller.dto.FarmDto;
import com.betrybe.agrix.model.entity.Crop;
import com.betrybe.agrix.model.entity.Farm;
import com.betrybe.agrix.service.CropService;
import com.betrybe.agrix.service.FarmService;
import com.betrybe.agrix.service.exception.CropNotFoundException;
import com.betrybe.agrix.service.exception.FarmNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller by Farm.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {

  private final FarmService farmService;
  private final CropService cropService;

  @Autowired
  public FarmController(FarmService farmService, CropService cropService) {
    this.farmService = farmService;
    this.cropService = cropService;
  }

  /**
   * Get Returns List Farms.
   */
  @GetMapping
  public List<FarmDto> findAll() {
    List<Farm> farms = farmService.findAll();
    return farms.stream()
        .map(FarmDto::fromEntity)
        .toList();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FarmDto save(@RequestBody FarmDto farm) {
    Farm savedFarm = farmService.create(farm.toEntity());
    return FarmDto.fromEntity(savedFarm);
  }

  @GetMapping("/{id}")
  public FarmDto findById(@PathVariable("id") long id) throws FarmNotFoundException {
    Farm farm = farmService.findById(id);
    return FarmDto.fromEntity(farm);
  }

  @PostMapping("/{farmId}/crops")
  @ResponseStatus(HttpStatus.CREATED)
  public CropDto createCrop(@RequestBody CropDto crop, @PathVariable("farmId") long farmId)
      throws FarmNotFoundException {
    Crop savedCrop = cropService.createCrop(crop.toEntity(), farmId);
    return CropDto.fromEntity(savedCrop);
  }

  /**
   * Get all Crops from farmId.
   */
  @GetMapping("/{farmId}/crops")
  public List<CropDto> findAllCrops(@PathVariable("farmId") long farmId)
      throws FarmNotFoundException {
    Farm farm = farmService.findById(farmId);

    if (farm == null) {
      throw new FarmNotFoundException();
    }

    List<Crop> crops = cropService.findAll();
    return crops.stream()
        .filter((crop -> crop.getFarm().getId() == farmId))
        .map(CropDto::fromEntity)
        .toList();
  }

}
