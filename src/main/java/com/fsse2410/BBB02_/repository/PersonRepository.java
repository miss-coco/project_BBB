package com.fsse2410.BBB02_.repository;

import com.fsse2410.BBB02_.data.person.domainObject.response.PersonResponseData;
import com.fsse2410.BBB02_.data.person.entity.PersonEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity,Integer> {
    boolean existsByHkid(String hkid);

    @Query(
            value = "SELECT * FROM PERSON WHERE `hkid` = ?1",
            nativeQuery = true
    )

    Optional<PersonEntity> findByHkid(String hkid);
}
