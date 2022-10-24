package com.avd.jdmrest.services;

import com.avd.jdmrest.domain.RentCondition;
import com.avd.jdmrest.repository.RentConditionRepository;
import org.springframework.stereotype.Service;

@Service
public class RentConditionServiceImpl implements RentConditionService {

    private RentConditionRepository rentConditionRepository;

    public RentConditionServiceImpl(RentConditionRepository rentConditionRepository) {
        this.rentConditionRepository = rentConditionRepository;
    }

    /**
     * @InheritDoc
     * @param rentCondition rent condition
     * @return RentCondition
     */
    @Override
    public RentCondition createRentCondition(RentCondition rentCondition) {
        return rentConditionRepository.save(rentCondition);

    }
}

