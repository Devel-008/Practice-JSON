package com.diff;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.diff.JsonDiff;

import java.util.ArrayList;
import java.util.List;

public class JsonDiffWithList {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<Integer> diff = new ArrayList<>();
        diff.add(1);
        diff.add(2);
        diff.add(3);
        diff.add(4);
        diff.add(5);


        JsonNode source = mapper.valueToTree(list);
        JsonNode target = mapper.valueToTree(diff);
        // final JsonPatch jsonPatch = JsonDiff.asJsonPatch(source, target);
        //System.out.println("JSON-PATCH-Diff: " + jsonPatch + "\n");
        final JsonNode patchNode = JsonDiff.asJson(source, target);
        System.out.println("JSON-PATCH-Diff: " + patchNode.toPrettyString() + "\n");

    }
}
