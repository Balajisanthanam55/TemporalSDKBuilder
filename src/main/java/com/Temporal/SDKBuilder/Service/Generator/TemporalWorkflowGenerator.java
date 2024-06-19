package com.Temporal.SDKBuilder.Service.Generator;

import com.Temporal.SDKBuilder.Service.Mapper.ActivityMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public class TemporalWorkflowGenerator {
    public static String generateWorkflowCode(List<JsonNode> activities, List<JsonNode> transitions) {
        StringBuilder code = new StringBuilder();
        code.append("import io.temporal.workflow.Workflow;\n");
        code.append("import io.temporal.activity.Activity;\n\n");
        code.append("public class MyWorkflowImpl implements MyWorkflow {\n");
        code.append("    @Override\n");
        code.append("    public void myWorkflowMethod() {\n");

        for (JsonNode activity : activities) {
            code.append("        ").append(ActivityMapper.mapActivity(activity)).append("();\n");
        }

        for (JsonNode transition : transitions) {
            code.append("        ").append(ActivityMapper.mapTransition(transition)).append("();\n");
        }

        code.append("    }\n");
        code.append("}\n");

        return code.toString();
    }
}
