package lab2.component.service;

import lab2.model.Vehicle;
import lab2.model.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class SearchByTypeService {

    private final VehicleUriFactory vehicleUriFactory;

    @Autowired
    public SearchByTypeService(VehicleUriFactory vehicleUriFactory) {
        this.vehicleUriFactory = vehicleUriFactory;
    }

    public List<Vehicle> search(VehicleType type) {
        String uri = vehicleUriFactory.createWithParams("type=" + type);
        Vehicle[] vehicles = new RestTemplate().getForObject(uri, Vehicle[].class);
        return Arrays.asList(vehicles);
    }
}