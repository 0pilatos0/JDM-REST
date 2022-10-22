package com.avd.jdmrest.services;

import com.avd.jdmrest.domain.CarListing;

import java.util.Optional;

public interface CarListingService
{
	/**
	 * Get all car listings
	 * @return Iterable<CarListing>
	 */
	Iterable<CarListing> getAll();

	/**
	 * Get car listing by id
	 * @param id carListing id
	 * @return Optional<CarListing>
	 */
	Optional<CarListing> getById(Long id);

	/**
	 * Create a new car listing
	 * @param carListing carListing
	 * @return CarListing
	 */

	CarListing createCar(CarListing carListing);

	/**
	 * Delete car listing by id
	 * @param id carListing id
	 * @return void
	 */

    void deleteById(Long id);


	Double getTCO(CarListing carListing);
}
