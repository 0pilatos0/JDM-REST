package com.avd.jdmrest.services;

import com.avd.jdmrest.domain.CarListing;

import java.util.Optional;

public interface CarListingService
{
	Iterable<CarListing> getAll();
	Optional<CarListing> getById(Long id);

	CarListing createCar(CarListing carListing);
}
