package com.bardan.mydog24crm.application;

import com.bardan.mydog24crm.domain.Dog;
import com.bardan.mydog24crm.domain.DogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DogService {

    private final DogRepository dogRepository;

    public Iterable<Dog> findDogByNameOrTelephone(String q) {
        return dogRepository.findTop30ByNameIgnoreCaseStartsWithOrTel1IgnoreCaseContainingOrTel2IgnoreCaseContainingOrTel3IgnoreCaseContaining(q,q,q,q);
    }


}
