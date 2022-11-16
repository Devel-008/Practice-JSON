package com.diff;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.diff.JsonDiff;

import java.util.ArrayList;
import java.util.List;

public class JsonDiffWithObject {
    public static void main(String[] args) {
        final ObjectMapper mapper = new ObjectMapper();

        User  user = new User("ASAP", "Rocky", 23);
        User user1 = new User("hello", "hi", 24);

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);

        JsonNode source = mapper.valueToTree(user);
        JsonNode target = mapper.valueToTree(user1);
        // final JsonPatch jsonPatch = JsonDiff.asJsonPatch(source, target);
        //System.out.println("JSON-PATCH-Diff: " + jsonPatch + "\n");
        final JsonNode patchNode = JsonDiff.asJson(source, target);
        System.out.println("JSON-PATCH-Diff: " + patchNode.toPrettyString() + "\n");

    }
}
