package com.betrybe.agrix.service.exception;


/**
 * Excption to Fetilizer.
 */
public class FertilizerNotFoundException extends NotFoundException {

  public FertilizerNotFoundException() {
    super("Fertilizante não encontrado!");
  }

}
