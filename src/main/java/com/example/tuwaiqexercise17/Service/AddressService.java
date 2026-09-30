package com.example.tuwaiqexercise17.Service;

import com.example.tuwaiqexercise17.Api.ApiException;
import com.example.tuwaiqexercise17.DTO.AddressDTO;
import com.example.tuwaiqexercise17.Model.Address;
import com.example.tuwaiqexercise17.Model.Teacher;
import com.example.tuwaiqexercise17.Repository.AddressRepository;
import com.example.tuwaiqexercise17.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAllAddresses() {
        List<Address> result = addressRepository.findAll();
        if (result.isEmpty()) {
            throw new ApiException("Address list is empty");
        }
        return result;
    }

    public void addAddress(AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findById(addressDTO.getTeacher_id())
                .orElseThrow(() -> new ApiException("Teacher was not found"));

        Address address = new Address(
                null,
                addressDTO.getArea(),
                addressDTO.getStreet(),
                addressDTO.getBuildingNumber(),
                teacher
        );

        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO) {
        Address address = addressRepository.findById(addressDTO.getTeacher_id())
                .orElseThrow(() -> new ApiException("Address was not found"));

        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());

        addressRepository.save(address);
    }

    public void deleteAddress(Integer id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ApiException("Address was not found"));
        addressRepository.delete(address);
    }
}
