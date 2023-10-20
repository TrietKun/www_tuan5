package com.tuan5.backend.repositories;

import com.tuan5.backend.models.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AddressRepository extends JpaRepository<Address ,Long> {
}
