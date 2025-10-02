package com.bardan.mydog24crm.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Long> {

    Iterable<Dog> findTop30ByNameIgnoreCaseStartsWithOrTel1IgnoreCaseContainingOrTel2IgnoreCaseContainingOrTel3IgnoreCaseContaining(String name, String tel1, String tel2, String tel3);

}
