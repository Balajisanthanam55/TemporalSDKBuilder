package com.Temporal.SDKBuilder.Controller;

import com.Temporal.SDKBuilder.Service.Converter.ServiceNowToTemporalConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class Controller {

    @GetMapping("/Convert")
    public String SDKBuilder(){
        String pathToJson = "src/main/resources/workflow-sample.json";
        try {
            String servicenowJson = new String(Files.readAllBytes(Paths.get(pathToJson)));
            return ServiceNowToTemporalConverter.convert(servicenowJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Something went wrong";
    }
}
