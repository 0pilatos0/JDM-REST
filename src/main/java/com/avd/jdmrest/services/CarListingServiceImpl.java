package com.avd.jdmrest.services;

import com.avd.jdmrest.domain.CarListing;
import com.avd.jdmrest.repository.CarListingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarListingServiceImpl implements CarListingService
{
	private final CarListingRepository carListingRepository;

	public CarListingServiceImpl(CarListingRepository carListingRepository) {
		this.carListingRepository = carListingRepository;
	}

	/**
	 * @InheritDoc
	 * @return Iterable<CarListing>
	 */
	@Override
	public Iterable<CarListing> getAll() {
		return carListingRepository.findAll();
	}

	/**
	 * @InheritDoc
	 * @param id
	 * @return Optional<CarListing>
	 */
	@Override
	public Optional<CarListing> getById(Long id) {
		return carListingRepository.findById(id);
	}

	/**
	 * @InheritDoc
	 * @param carListing
	 * @return CarListing
	 */
	@Override
	public CarListing createCar(CarListing carListing) {
		return carListingRepository.save(carListing);
	}

	/**
	 * @InheritDoc
	 * @param id
	 * @return void
	 */
	@Override
	public void deleteById(Long id) {
		carListingRepository.deleteById(id);
	}
}
