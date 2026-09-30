package com.example.tuwaiqexercise17.Repository;

import com.example.tuwaiqexercise17.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
