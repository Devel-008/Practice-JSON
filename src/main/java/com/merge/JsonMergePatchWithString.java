package com.merge;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;

public class JsonMergePatchWithString {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        String patch = """
{
    "title": "Goodbye!",
    "author": {
      "givenName": "John",
      "familyName": "Doe"
    },
    "tags": [
      "example",
      "sample"
    ],
    "content": "This will be unchanged"
}""";

        String merge = """
{
    "title": "Hello!",
    "message":"Have a great day",
    "author": {
      "givenName": "Neil",
      "familyName": "Nitin",
      "lastName" : "jd"
    },
    "tags": [
      "Mohan",
      "Mukesh",
      "Random"
    ],
    "content": "Random comment"
}""";
        try {
            JsonNode node = mapper.readTree(merge);
            JsonNode op = mapper.readTree(patch);
            final JsonMergePatch mergePatch = JsonMergePatch.fromJson(op);
            final JsonNode patched = mergePatch.apply(node);
            System.out.println(patched);

        } catch (JsonProcessingException | JsonPatchException e) {
            e.printStackTrace();
        }

    }

}
