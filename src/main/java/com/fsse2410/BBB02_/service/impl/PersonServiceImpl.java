package com.fsse2410.BBB02_.service.impl;

import com.fsse2410.BBB02_.data.person.domainObject.request.CreatePersonRequestData;
import com.fsse2410.BBB02_.data.person.domainObject.request.UpdatePersonRequestData;
import com.fsse2410.BBB02_.data.person.domainObject.response.CreatePersonResponseData;
import com.fsse2410.BBB02_.data.person.domainObject.response.PersonResponseData;
import com.fsse2410.BBB02_.data.person.entity.PersonEntity;
import com.fsse2410.BBB02_.exception.person.PersonExistedException;
import com.fsse2410.BBB02_.exception.person.PersonNotFoundException;
import com.fsse2410.BBB02_.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PersonServiceImpl implements PersonService {
    private List<PersonEntity> personEntityList = new ArrayList<>();
    Logger logger = LoggerFactory.getLogger(PersonEntity.class);

    @Override
    public CreatePersonResponseData createPerson(CreatePersonRequestData createPersonRequestData) {
        try {
            PersonEntity newPersonEntity = new PersonEntity(createPersonRequestData);

            if (existedByHkid(newPersonEntity.getHkid())) {
                throw new PersonExistedException();
            }
            personEntityList.add(newPersonEntity);
            CreatePersonResponseData createPersonResponseData = new CreatePersonResponseData(newPersonEntity);
            return createPersonResponseData;
        } catch (Exception ex) {
            logger.warn("Create Person Failed: " + ex.getMessage());
            throw ex;
        }
    }
        @Override
        public List<PersonResponseData> getAllPerson () {
            List<PersonResponseData> personResponseDataList = new ArrayList<>();
            for (PersonEntity personEntity : personEntityList) {
                PersonResponseData personResponseData = new PersonResponseData(personEntity);
                personResponseDataList.add(personResponseData);
            }
            return personResponseDataList;
        }
        @Override
        public PersonResponseData updatePerson (UpdatePersonRequestData updatePersonRequestData) {
            try {
                for (PersonEntity personEntity : personEntityList) {
                    if (personEntity.getHkid().equals(updatePersonRequestData.getHkid())) {
                        personEntity.setFirstName(updatePersonRequestData.getFirstName());
                        personEntity.setLastName(updatePersonRequestData.getLastName());

                        PersonResponseData personResponseData = new PersonResponseData(personEntity);
                        return personResponseData;
                    }
                }
                throw new PersonNotFoundException(updatePersonRequestData.getHkid()); //exception內有string,呢度就收string hkid
            } catch (Exception ex) {
                logger.warn("Update Person: " + ex.getMessage());
                throw ex;
            }
        }
            @Override
            public PersonResponseData deletePerson(String hkid) {
                try {
                    PersonEntity deletePerson = getEntityByHkid(hkid);
                    personEntityList.remove(deletePerson);
//                    Lv2
//                    PersonResponseData personResponseData = new PersonResponseData(deletePerson);
//                    return personResponseData;

                    //Lv3
                    return new PersonResponseData(deletePerson);
                } catch (Exception ex) {
                    logger.warn("Delete Person Failed:  " + ex.getMessage());
                    throw ex;
                }
            }

            @Override
            public List<PersonResponseData> getByLastName(String lastName){
                List<PersonResponseData> personResponseDataList = new ArrayList<>();

                for (PersonEntity personEntity : personEntityList){
                    if (!personEntity.getLastName().equalsIgnoreCase(lastName)){
                        continue;
                    }
                    PersonResponseData personResponseData = new PersonResponseData(personEntity);
                    personResponseDataList.add(personResponseData);
                }
                return personResponseDataList;
            }
            @Override
            public boolean existedByHkid(String hkid){
                for (PersonEntity personEntity : personEntityList) {
                    if (personEntity.getHkid().equals(hkid)) {
                        return true;
                    }
                }
                return false;
            }
            @Override
            public PersonEntity getEntityByHkid(String hkid){ //check下entity入面的id對吾對到
                for (PersonEntity personEntity : personEntityList) {
                    if (personEntity.getHkid().equals(hkid)) {
                        return personEntity;
                    }
                }
                throw new PersonNotFoundException(hkid);
            }
    }










