package lab2.component.service;

import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;

@Service
public class VehicleUriFactory {

    static {
        HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession) -> "localhost".equals(hostname));
    }

    private final String baseUrl;

    {
        String host = System.getenv("VEHICLE_HOST");
        String port = System.getenv("VEHICLE_PORT");
        String endpoint = System.getenv("VEHICLE_ENDPOINT");

        baseUrl = "https://" + host + ":" + port + "/" + endpoint;
    }

    public String createBase() {
        return baseUrl;
    }

    public String createWithParams(String params) {
        return baseUrl + "?" + params;
    }
}