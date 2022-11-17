package com.diff;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.diff.JsonDiff;

import java.util.HashMap;
import java.util.Map;

public class JsonDiffWithMap {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        Map<String , String> map = new HashMap<>();
        map.put("1","Amit");
        map.put("3","Rahul");
        map.put("5","Jai");
        map.put("7","Amit");

        Map<String , String> diff = new HashMap<>();
        diff.put("1","Amit");
        diff.put("3","Rahul");
        diff.put("5","Rohit");
        diff.put("7","Amit");
        diff.put("9","Sunil");


        JsonNode source = mapper.valueToTree(map);
        JsonNode target = mapper.valueToTree(diff);
        // final JsonPatch jsonPatch = JsonDiff.asJsonPatch(source, target);
        //System.out.println("JSON-PATCH-Diff: " + jsonPatch + "\n");
        final JsonNode patchNode = JsonDiff.asJson(source, target);
        System.out.println("JSON-PATCH-Diff: " + patchNode.toPrettyString() + "\n");
    }
}
