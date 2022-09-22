package com.family.repository;

import org.springframework.data.repository.CrudRepository;

import com.family.entities.Family;

public interface FamilyRepository extends CrudRepository<Family, Long> {

}
