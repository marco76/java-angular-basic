package dev.marco.example.springboot.feature;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The goal of this controller is to show the test of the services and some REST methods
 */
@RestController
@CrossOrigin(origins =  {"${app.dev.frontend.local"})
public class FeatureController {

    @Autowired
    FeatureService featureService;

    @GetMapping(value = "/feature", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getSum(@RequestBody OperationValues operationValues) throws JSONException {
        Integer sumResult = featureService.getSum(operationValues.getValueA(), operationValues.getValueB());
        JSONObject result = new JSONObject();
        result.put("result", sumResult);
        return ResponseEntity.ok(result.toString());
    }

    @PostMapping(value = "/feature", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postSum(@RequestBody OperationValues operationValues) throws JSONException {
        Integer sumResult = featureService.getSum(operationValues.getValueA(), operationValues.getValueB());
        JSONObject result = new JSONObject();
        result.put("result", sumResult);
        return ResponseEntity.ok(result.toString());
    }

}
