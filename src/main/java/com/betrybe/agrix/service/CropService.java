package com.betrybe.agrix.service;

import com.betrybe.agrix.model.entity.Crop;
import com.betrybe.agrix.model.entity.Farm;
import com.betrybe.agrix.model.entity.Fertilizer;
import com.betrybe.agrix.model.repository.CropRepository;
import com.betrybe.agrix.service.exception.CropNotFoundException;
import com.betrybe.agrix.service.exception.FarmNotFoundException;
import com.betrybe.agrix.service.exception.FertilizerNotFoundException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service by Crop.
 */
@Service
public class CropService {

  private final CropRepository cropRepository;
  private final FarmService farmService;
  private final FertilizerService fertilizerService;

  /**
   * Contructor to repositorys.
   */
  @Autowired
  public CropService(CropRepository cropRepository, FarmService farmService,
      FertilizerService fertilizerService) {
    this.cropRepository = cropRepository;
    this.farmService = farmService;
    this.fertilizerService = fertilizerService;
  }

  public Crop findById(long id) throws CropNotFoundException {
    return cropRepository.findById(id)
        .orElseThrow(CropNotFoundException::new);
  }

  public List<Crop> findAll() {
    return cropRepository.findAll();
  }

  public Crop create(Crop crop) {
    return cropRepository.save(crop);
  }

  /**
   * Create Crop with FarmId.
   */
  public Crop createCrop(Crop crop, long farmId) throws FarmNotFoundException {
    Farm farm = farmService.findById(farmId);

    crop.setFarm(farm);

    return cropRepository.save(crop);
  }

  public List<Crop> searchCrops(LocalDate start, LocalDate end) {
    return cropRepository.findByHarvestDateBetween(start, end);
  }

  /**
   * Association Fertilizers to Crop by id.
   */
  public void addFertilizerToCrop(Long cropId, Long fertilizerId)
      throws CropNotFoundException, FertilizerNotFoundException {
    Crop crops = findById(cropId);
    Fertilizer fertilizers = fertilizerService.findById(fertilizerId);
    crops.getFertilizers().add(fertilizers);
    cropRepository.save(crops);
  }

  public List<Fertilizer> findFertilizersFromCropId(Long cropId)
      throws CropNotFoundException {
    Crop crops = findById(cropId);
    return crops.getFertilizers();
  }

}
