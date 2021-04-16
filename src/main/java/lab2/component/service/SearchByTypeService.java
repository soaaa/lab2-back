package lab2.component.service;

import lab2.model.Vehicle;
import lab2.model.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

@Service
public class SearchByTypeService {

    private final VehicleUriFactory vehicleUriFactory;
    private final RestTemplateFactory restTemplateFactory;

    @Autowired
    public SearchByTypeService(VehicleUriFactory vehicleUriFactory,
                               RestTemplateFactory restTemplateFactory) {
        this.vehicleUriFactory = vehicleUriFactory;
        this.restTemplateFactory = restTemplateFactory;
    }

    public List<Vehicle> search(VehicleType type) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        String uri = vehicleUriFactory.createWithParams("type=" + type);
        Vehicle[] vehicles = restTemplateFactory.create().getForObject(uri, Vehicle[].class);
        return Arrays.asList(vehicles);
    }
}