package com.diff;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.diff.JsonDiff;

public class JsonDiffWithArray {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        int[] array = {1,2,3,4,5,6};
        int[] diff = {1,2,3,4,5};

        JsonNode source = mapper.valueToTree(array);
        JsonNode target = mapper.valueToTree(diff);
        // final JsonPatch jsonPatch = JsonDiff.asJsonPatch(source, target);
        //System.out.println("JSON-PATCH-Diff: " + jsonPatch + "\n");
        final JsonNode patchNode = JsonDiff.asJson(source, target);
        System.out.println("JSON-PATCH-Diff: " + patchNode.toPrettyString() + "\n");
    }
}
