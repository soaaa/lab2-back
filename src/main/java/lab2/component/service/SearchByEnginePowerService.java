package lab2.component.service;

import lab2.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchByEnginePowerService {

    private final VehicleUriFactory vehicleUriFactory;

    @Autowired
    public SearchByEnginePowerService(VehicleUriFactory vehicleUriFactory) {
        this.vehicleUriFactory = vehicleUriFactory;
    }

    public List<Vehicle> search(float enginePowerFrom, float enginePowerTo) {
        String uri = vehicleUriFactory.createBase();
        Vehicle[] allVehicles = new RestTemplate().getForObject(uri, Vehicle[].class);
        List<Vehicle> resultList = new ArrayList<>();
        for (Vehicle vehicle : allVehicles) {
            float enginePower = vehicle.getEnginePower();
            if (enginePower >= enginePowerFrom && enginePower <= enginePowerTo) {
                resultList.add(vehicle);
            }
        }
        return resultList;
    }
}