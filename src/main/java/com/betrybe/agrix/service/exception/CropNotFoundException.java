package com.betrybe.agrix.service.exception;

/**
 * Exception to Crop.
 */
public class CropNotFoundException extends NotFoundException {

  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }
}
