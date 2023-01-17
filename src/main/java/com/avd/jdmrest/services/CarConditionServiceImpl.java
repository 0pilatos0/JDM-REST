package com.avd.jdmrest.services;

import com.avd.jdmrest.domain.CarCondition;
import com.avd.jdmrest.repository.CarConditionRepository;
import org.springframework.stereotype.Service;

@Service
public class CarConditionServiceImpl implements CarConditionService {

	private CarConditionRepository carConditionRepository;

	public CarConditionServiceImpl(CarConditionRepository carConditionRepository) {
		this.carConditionRepository = carConditionRepository;
	}

	/**
	 * @InheritDoc
	 * @param carCondition car condition
	 * @return CarCondition
	 */
	@Override
	public CarCondition createCarCondition(CarCondition carCondition) {
		return carConditionRepository.save(carCondition);

	}
}

