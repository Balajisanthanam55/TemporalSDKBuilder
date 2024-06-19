package com.Temporal.SDKBuilder.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class ServiceNowWorkflowParser {
    public static JsonNode parseWorkflow(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(json);
    }

    public static List<JsonNode> getActivities(JsonNode workflow) {
        return workflow.get("activities").findValues("activity");
    }

    public static List<JsonNode> getTransitions(JsonNode workflow) {
        return workflow.get("transitions").findValues("transition");
    }
}
