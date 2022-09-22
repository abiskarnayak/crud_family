package com.family;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.family.entities.Family;
import com.family.repository.FamilyRepository;

@SpringBootTest
class CrudFamilyApplicationTests {
    @Autowired
	private FamilyRepository familyRepo;
	
	@Test
	void saveOneFamily() {
		Family f1 = new Family();
		f1.setFather("prakash");
		f1.setMother("priya");
		f1.setBrother("pavan");
		
		familyRepo.save(f1);
	}

	@Test
	void deleteOneFamily() {
		familyRepo.deleteById(1L);
	}
	
	@Test
	void updateOneFamily() {
		Optional<Family> findById = familyRepo.findById(3L);
		if(findById.isPresent()) {
			Family family = findById.get();
			family.setFather("ajay");
			family.setMother("kajol");
			family.setBrother("mike");
			familyRepo.save(family);
			
		}else {
			System.out.println("NO RECORD FOUND");
		}
	}
	
	@Test
	void readOneFamily() {
		Optional<Family> findById = familyRepo.findById(1L);
		if(findById.isPresent()) {
			Family family = findById.get();
			System.out.println(family.getFather());
			System.out.println(family.getMother());
			System.out.println(family.getBrother());
		}else{
			System.out.println("No Record Found");
		}
	}
	@Test
	void getAllFamily() {
		Iterable<Family> findAll = familyRepo.findAll();
		for (Family family : findAll) {
			System.out.println(family.getFather());
			System.out.println(family.getMother());
			System.out.println(family.getBrother());
		}
		
	}
}

