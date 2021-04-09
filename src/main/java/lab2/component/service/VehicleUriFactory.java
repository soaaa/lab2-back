package lab2.component.service;

import org.springframework.stereotype.Service;

@Service
public class VehicleUriFactory {

    private final String baseUrl =
            "http://localhost:" + System.getenv("SOA_PORT") + System.getenv("VEHICLE_ENDPOINT");

    public String createBase() {
        return baseUrl;
    }

    public String createWithParams(String params) {
        return baseUrl + "?" + params;
    }
}