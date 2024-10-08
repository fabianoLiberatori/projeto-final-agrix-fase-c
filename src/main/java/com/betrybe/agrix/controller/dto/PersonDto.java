package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.model.entity.Person;
import com.betrybe.agrix.security.Role;

/**
 * Methords fromEntity'n'toDTO by Person.
 */
public record PersonDto(
    Long id,
    String username,
    String password,
    Role role
) {

  /**
   * Returns by Entity to DTO.
   */
  public static PersonDto fromEntity(Person person) {
    return new PersonDto(
        person.getId(),
        person.getUsername(),
        person.getPassword(),
        person.getRole()
    );
  }

  /**
   * Returns by DTO to Entity.
   */
  public Person toEntity() {
    Person person = new Person();
    person.setUsername(username);
    person.setPassword(password);
    person.setRole(role);
    return person;
  }
}
