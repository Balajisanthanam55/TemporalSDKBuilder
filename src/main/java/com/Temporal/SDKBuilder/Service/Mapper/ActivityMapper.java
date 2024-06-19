package com.Temporal.SDKBuilder.Service.Mapper;

import com.fasterxml.jackson.databind.JsonNode;

public class ActivityMapper {
    public static String mapActivity(JsonNode activity) {
        // Map ServiceNow activity types to Temporal activities
        String type = activity.get("type").asText();
        switch (type) {
            case "start":
                return "startActivity";
            case "task":
                return "taskActivity";
            case "end":
                return "endActivity";
            default:
                throw new IllegalArgumentException("Unknown activity type: " + type);
        }
    }

    public static String mapTransition(JsonNode transition) {
        return "transition_" + transition.get("id").asText();
    }
}
