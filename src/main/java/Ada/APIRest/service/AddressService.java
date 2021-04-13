package Ada.APIRest.service;

import Ada.APIRest.entity.Address;
import Ada.APIRest.entity.Student;
import Ada.APIRest.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepo;

    public Address save(Address address) {
        return this.addressRepo.save(address);
    }
}
