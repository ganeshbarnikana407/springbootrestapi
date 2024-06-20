package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.StoreInformation;

public interface StoreInformationRepository extends JpaRepository<StoreInformation, Integer> {

	List<StoreInformation> findByStoreName(String name);

	List<StoreInformation> findByStorePhoneNumber(String name);

	List<StoreInformation> findByStoreDetail(String name);

}
