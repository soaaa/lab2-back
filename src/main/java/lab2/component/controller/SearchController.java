package lab2.component.controller;

import lab2.component.service.SearchByEnginePowerService;
import lab2.component.service.SearchByTypeService;
import lab2.model.Vehicle;
import lab2.model.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final SearchByTypeService searchByTypeService;
    private final SearchByEnginePowerService searchByEnginePowerService;

    @Autowired
    public SearchController(SearchByTypeService searchByTypeService,
                            SearchByEnginePowerService searchByEnginePowerService) {
        this.searchByTypeService = searchByTypeService;
        this.searchByEnginePowerService = searchByEnginePowerService;
    }

    @RequestMapping(value = "/by-type/{type}", method = RequestMethod.GET)
    public ResponseEntity<List<Vehicle>> byType(@PathVariable("type") String typeValue) {
        String uppercaseTypeValue = typeValue.toUpperCase();
        for (VehicleType type : VehicleType.values()) {
            if (type.name().equals(uppercaseTypeValue)) {
                List<Vehicle> foundVehicles = searchByTypeService.search(type);
                return ResponseEntity.ok(foundVehicles);
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value = "/by-engine-power/{from}/{to}", method = RequestMethod.GET)
    public List<Vehicle> byEnginePower(@PathVariable("from") float from,
                                       @PathVariable("to") float to) {
        return searchByEnginePowerService.search(from, to);
    }
}