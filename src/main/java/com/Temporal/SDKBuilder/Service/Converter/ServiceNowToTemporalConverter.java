package com.Temporal.SDKBuilder.Service.Converter;

import com.Temporal.SDKBuilder.Service.Generator.TemporalWorkflowGenerator;
import com.Temporal.SDKBuilder.Service.ServiceNowWorkflowParser;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.List;

public class ServiceNowToTemporalConverter {
    public static String convert(String servicenowJson) throws IOException {
        JsonNode workflow = ServiceNowWorkflowParser.parseWorkflow(servicenowJson);
        List<JsonNode> activities = ServiceNowWorkflowParser.getActivities(workflow);
        List<JsonNode> transitions = ServiceNowWorkflowParser.getTransitions(workflow);

        return TemporalWorkflowGenerator.generateWorkflowCode(activities, transitions);
    }
}
