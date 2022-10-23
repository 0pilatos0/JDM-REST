package com.avd.jdmrest.services;

import com.avd.jdmrest.domain.RentCondition;

public interface RentConditionService {

    /**
     * Create a new rent condition
     * @param rentCondition rent condition
     * @return RentCondition
     */
    public RentCondition createRentCondition(RentCondition rentCondition);
}
