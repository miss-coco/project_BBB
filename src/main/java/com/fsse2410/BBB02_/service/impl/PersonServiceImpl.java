package com.fsse2410.BBB02_.service.impl;

import com.fsse2410.BBB02_.data.person.domainObject.request.CreatePersonRequestData;
import com.fsse2410.BBB02_.data.person.domainObject.request.UpdatePersonRequestData;
import com.fsse2410.BBB02_.data.person.domainObject.response.CreatePersonResponseData;
import com.fsse2410.BBB02_.data.person.domainObject.response.PersonResponseData;
import com.fsse2410.BBB02_.data.person.entity.PersonEntity;
import com.fsse2410.BBB02_.exception.person.PersonExistedException;
import com.fsse2410.BBB02_.exception.person.PersonNotFoundException;
import com.fsse2410.BBB02_.repository.PersonRepository;
import com.fsse2410.BBB02_.service.PersonService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    private List<PersonEntity> personEntityList = new ArrayList<>();

    Logger logger = LoggerFactory.getLogger(PersonEntity.class);

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public CreatePersonResponseData createPerson(CreatePersonRequestData createPersonRequestData) {
        try {
            if (existedByHkid(createPersonRequestData.getHkid())) {
                throw new PersonExistedException();
            }
//            Lv2
//            PersonEntity newPersonEntity = new PersonEntity(createPersonRequestData);      //line 40,41兩個personEntity,40果個無pid,line41 save完就有pid
//           personRepository.save(newPersonEntity);          //PersonEntity personEntity = personRepository.save(newPersonEntity);
//           return new CreatePersonResponseData(newPersonEntity);
//           Lv3
           return new CreatePersonResponseData(personRepository.save(new PersonEntity(createPersonRequestData)));

        } catch (Exception ex) {
            logger.warn("Create Person Failed: " + ex.getMessage());
            throw ex;
        }
    }

@Override
    public List<PersonResponseData> getAllPerson () {
        List<PersonResponseData> personResponseDataList = new ArrayList<>();
        for (PersonEntity personEntity : personRepository.findAll()) {
            PersonResponseData personResponseData = new PersonResponseData(personEntity);
            personResponseDataList.add(personResponseData);
        }
        return personResponseDataList;
    }





        @Override
        public PersonResponseData updatePerson (UpdatePersonRequestData updatePersonRequestData) {
            try {
//                Lv2
//                for (PersonEntity personEntity : personEntityList) {
//                    if (personEntity.getHkid().equals(updatePersonRequestData.getHkid())) {
//                        personEntity.setFirstName(updatePersonRequestData.getFirstName());
//                        personEntity.setLastName(updatePersonRequestData.getLastName());
//
//                        PersonResponseData personResponseData = new PersonResponseData(personEntity);
//                        return personResponseData;
//                    }
//                }
//
//                throw new PersonNotFoundException(updatePersonRequestData.getHkid()); //exception內有string,呢度就收string hkid

//                Lv3
                PersonEntity personEntity = getEntityByHkid(updatePersonRequestData.getHkid());
                personEntity.setFirstName(updatePersonRequestData.getFirstName());
                personEntity.setLastName(updatePersonRequestData.getLastName());
//                return new PersonResponseData(personEntity);
//
//                Lv2
//                personRepository.save(personEntity);
//                return new PersonResponseData(personEntity);

//                Lv3
                return new PersonResponseData(
                        personRepository.save(personEntity)
                );
            } catch (Exception ex) {
                logger.warn("Update Person: " + ex.getMessage());
                throw ex;
            }
        }
            @Override
            @Transactional //做commit and rollback 的事情
            public PersonResponseData deletePerson(String hkid) {
                try {
                    PersonEntity deletePerson = getEntityByHkid(hkid);
                    personRepository.delete(deletePerson);
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
        return personRepository.existsByHkid(hkid);
            }

    @Override
    public PersonEntity getEntityByHkid(String hkid){
        Optional<PersonEntity > personEntityOptional = personRepository.findByHkid(hkid);
//        Lv1
//        if (personEntityOptional.isPresent()){
//            return personEntityOptional.get();
//        } else {
//            throw new PersonNotFoundException(hkid);
//        }

//        Lv2
//        if (personEntityOptional.isPresent()){
//            throw new PersonNotFoundException(hkid);
//        }
//        return personEntityOptional.get();

//        Lv3
        return personRepository.findByHkid(hkid).orElseThrow(
                () -> new PersonNotFoundException(hkid)
        );

    }


    }
