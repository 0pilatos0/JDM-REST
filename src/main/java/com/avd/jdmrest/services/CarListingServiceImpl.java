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
	 * @param id carListing id
	 * @return Optional<CarListing>
	 */
	@Override
	public Optional<CarListing> getById(Long id) {
		return carListingRepository.findById(id);
	}

	/**
	 * @InheritDoc
	 * @param carListing carListing
	 * @return CarListing
	 */
	@Override
	public CarListing createCar(CarListing carListing) {
		return carListingRepository.save(carListing);
	}

	/**
	 * @InheritDoc
	 * @param id carListing id
	 */
	@Override
	public void deleteById(Long id) {
		carListingRepository.deleteById(id);
	}

	@Override
	public Double getTCO(CarListing carListing) {
		switch (carListing.getCarType()) {
			case ICE:
				return (double)carListing.price * 10000.0;
			case BEV:
				return (double)carListing.price * 15000.0;
			case FCEV:
				return (double)carListing.price * 20000.0;
			default:
				return 0.0;
		}
	}
}
