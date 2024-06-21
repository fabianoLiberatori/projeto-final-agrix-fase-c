package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.PersonDto;
import com.betrybe.agrix.controller.dto.PersonWithoutPasswordDto;
import com.betrybe.agrix.model.entity.Person;
import com.betrybe.agrix.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller by Person.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PersonWithoutPasswordDto save(@RequestBody PersonDto person) {
    Person savedPerson = personService.create(person.toEntity());
    return PersonWithoutPasswordDto.fromEntity(savedPerson);
  }
}
