package com.fsse2410.BBB02_.controller;

import com.fsse2410.BBB02_.data.person.domainObject.request.CreatePersonRequestData;
import com.fsse2410.BBB02_.data.person.domainObject.request.UpdatePersonRequestData;
import com.fsse2410.BBB02_.data.person.domainObject.response.CreatePersonResponseData;
import com.fsse2410.BBB02_.data.person.domainObject.response.PersonResponseData;
import com.fsse2410.BBB02_.data.person.dto.request.CreatePersonRequestDto;
import com.fsse2410.BBB02_.data.person.dto.request.UpdatePersonRequestDto;
import com.fsse2410.BBB02_.data.person.dto.response.CreatePersonResponseDto;
import com.fsse2410.BBB02_.data.person.dto.response.PersonResponseDto;
import com.fsse2410.BBB02_.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {


    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person")
    public CreatePersonResponseDto createPerson(@RequestBody CreatePersonRequestDto createPersonRequestDto) {
        CreatePersonRequestData createPersonRequestData = new CreatePersonRequestData(createPersonRequestDto);
        CreatePersonResponseData createPersonResponseData = personService.createPerson(createPersonRequestData);
        CreatePersonResponseDto createPersonResponseDto = new CreatePersonResponseDto(createPersonResponseData);
        return createPersonResponseDto;
    }
    @GetMapping("/person")
    public List<PersonResponseDto> getAllPerson(){
        List<PersonResponseData> personResponseDataList = personService.getAllPerson();
        List<PersonResponseDto> personResponseDtoList = new ArrayList<>();
        for (PersonResponseData personResponseData : personResponseDataList){
            PersonResponseDto personResponseDto = new PersonResponseDto(personResponseData);
            personResponseDtoList.add(personResponseDto);
        }
        return personResponseDtoList;
    }
    @PutMapping("/person")
    public PersonResponseDto updatePerson(@RequestBody UpdatePersonRequestDto updatePersonRequestDto){
        UpdatePersonRequestData updatePersonRequestData = new UpdatePersonRequestData(updatePersonRequestDto);
        PersonResponseData personResponseData = personService.updatePerson(updatePersonRequestData);
        PersonResponseDto personResponseDto = new PersonResponseDto(personResponseData);
        return personResponseDto;
    }
    @DeleteMapping("/person")
    public PersonResponseDto deletePerson(@RequestParam String hkid){ //@RequestParam(value = "hkid_number") String hkid
        PersonResponseData personResponseData = personService.deletePerson(hkid);
        PersonResponseDto personResponseDto = new PersonResponseDto(personResponseData);
        return personResponseDto;
    }
    @GetMapping("/person/{lastName}") //
    public List<PersonResponseDto> getByLastName(@PathVariable String lastName){
        //Lv2
        List<PersonResponseData> personResponseDataList = personService.getByLastName(lastName);
        List<PersonResponseDto> personResponseDtoList = new ArrayList<>();
        for (PersonResponseData personResponseData : personResponseDataList){
            PersonResponseDto personResponseDto = new PersonResponseDto(personResponseData);
            personResponseDtoList.add(personResponseDto);
        }
//        Lv3
//        List<PersonResponseDto> personResponseDtoList = new ArrayList<>();
//        for (PersonResponseData personResponseData : personService.getByLastName(lastName)){
//            personResponseDtoList.add(new PersonResponseDto(personResponseData));
//        }
//
        return personResponseDtoList;
    }
}