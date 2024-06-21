package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.model.entity.Person;
import com.betrybe.agrix.security.Role;

/**
 * Methords fromEntity'n'toDTO by Person without password.
 */
public record PersonWithoutPasswordDto(
    Long id,
    String username,
    Role role
) {

  /**
   * Returns by Entity to DTO.
   */
  public static PersonWithoutPasswordDto fromEntity(Person person) {
    return new PersonWithoutPasswordDto(
        person.getId(),
        person.getUsername(),
        person.getRole()
    );
  }

  /**
   * Returns by DTO to Entity.
   */
  public Person toEntity() {
    Person person = new Person();
    person.setUsername(username);
    person.setRole(role);
    return person;
  }
}
