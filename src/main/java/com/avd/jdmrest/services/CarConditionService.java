package com.avd.jdmrest.services;

import com.avd.jdmrest.domain.CarCondition;

public interface CarConditionService {

	/**
	 * Create a new car condition
	 * @param carCondition car condition
	 * @return CarCondition
	 */
	public CarCondition createCarCondition(CarCondition carCondition);
}
