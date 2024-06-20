package com.betrybe.agrix.service.exception;

/**
 * Exception to Farm.
 */
public class FarmNotFoundException extends NotFoundException {

  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
