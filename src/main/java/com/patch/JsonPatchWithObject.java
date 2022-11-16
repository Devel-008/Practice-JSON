package com.patch;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonPatchWithObject {
    public static void main(String[] args) {
        try {
            final ObjectMapper mapper = new ObjectMapper();

            User user = new User("kya hai yeh", "ku hai yeh", 23);
            User user1 = new User("hello", "hi", 24);
            List<User> users = new ArrayList<>();
            users.add(user);
            users.add(user1);
            JsonNode node = mapper.valueToTree(users);

            JsonNode op = mapper.readValue("""
                    [   \s
                       { "op": "replace", "path": "/0/firstName", "value": "Hello!"},
                       { "op": "remove", "path": "/0/lastName"},
                       { "op": "add", "path": "/0/phoneNumber", "value": "+01-123-456-7890"},
                       { "op": "move", "from": "/0/firstName", "path": "/0/name" },
                       {"op": "copy", "from": "/0", "path": "/1"},
                       {"op": "test", "path": "/0/age", "value": 23}
                     \s
                    ]""", JsonNode.class);

           // System.out.println("User-Data :- " + node);
           // System.out.println(op);
            final JsonPatch patch = JsonPatch.fromJson(op);
           // System.out.println("Operations :- " + patch);
            final JsonNode patched = patch.apply(node);
            System.out.println("Patched Values:- " + patched);
        }catch (JsonPatchException | IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Process Successful");
        }
    }
}
