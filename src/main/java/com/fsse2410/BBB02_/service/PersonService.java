package com.fsse2410.BBB02_.service;

import com.fsse2410.BBB02_.data.person.domainObject.request.CreatePersonRequestData;
import com.fsse2410.BBB02_.data.person.domainObject.request.UpdatePersonRequestData;
import com.fsse2410.BBB02_.data.person.domainObject.response.CreatePersonResponseData;
import com.fsse2410.BBB02_.data.person.domainObject.response.PersonResponseData;
import com.fsse2410.BBB02_.data.person.entity.PersonEntity;

import java.util.List;

public interface PersonService {
    CreatePersonResponseData createPerson(CreatePersonRequestData createPersonRequestData);
    List<PersonResponseData> getAllPerson();
    PersonResponseData updatePerson(UpdatePersonRequestData updatePersonRequestData);
    PersonResponseData deletePerson(String hkid);
    List<PersonResponseData> getByLastName(String lastName);

    boolean existedByHkid(String hkid);

    PersonEntity getEntityByHkid(String hkid);
}
