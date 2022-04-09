package org.example.people.api.service.impl;

import org.example.people.api.client.ProfileClient;
import org.example.people.api.dto.PersonDTO;
import org.example.people.api.dto.ProfileDTO;
import org.example.people.api.model.Person;
import org.example.people.api.repository.PersonRepository;
import org.example.people.api.service.PersonService;
import org.example.people.api.util.ModelMapperSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private ProfileClient profileClient;

    @Override
    public PersonDTO findById(Long id) {
        Optional<Person> optional = repository.findById(id);
        if (optional.isPresent()) {
            Person person = optional.get();

            return getPersonDTO(person);
        }
        return null;
    }

    @Override
    public List<PersonDTO> findAllById(Long[] ids) {
        Iterable<Person> iterable = repository.findAllById(Arrays.asList(ids));
        if (iterable != null) {
            List<Person> list = StreamSupport.stream(iterable.spliterator(), false)
                    .collect(Collectors.toList());

            return list.stream().map(Person -> getPersonDTO(Person))
                    .collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public PersonDTO updateById(Long id, PersonDTO dto) {
        Person person = null;
        Optional<Person> optional = repository.findById(id);
        if (optional.isPresent()) {
            person = optional.get();
            ModelMapperSingleton.get().map(dto, person);
            person.setUpdatedAt(Date.valueOf(LocalDate.now()));

            return getPersonDTO(repository.save(person));
        }
        return null;
    }

    @Override
    public String findPolicyById(Long id) {
        Optional<Person> optional = repository.findById(id);
        if (optional.isPresent()) {
            Person person = optional.get();

            return person.getPolicyId();
        }
        return null;
    }

    private PersonDTO getPersonDTO(Person person) {
        ProfileDTO profileDTO = null;

        if (person.getProfileId() != null) {
            profileDTO = profileClient.get(person.getProfileId());
        }

        PersonDTO personDTO = ModelMapperSingleton.get().map(person, PersonDTO.class);
        personDTO.setProfile(profileDTO);

        return personDTO;
    }

}
