package com.diff;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.diff.JsonDiff;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class DiffString {

    public static void main(String[] args) {
        Map<JsonPointer, Set<String>> map;
        final ObjectMapper mapper = new ObjectMapper();
        String refJsonStr = """
                {
                  "id": 1,
                  "name": {
                    "first": "Yong",
                    "last": "Mook Kim"
                  },
                  "contact": [
                    {
                      "type": "phone/home",
                      "ref": "221-222-2222",
                      "info": "phone"
                    },
                    {
                      "type": "phone/work",
                      "ref": "222-222-2222"
                    }
                  ]
                }
                """;


        String newJsonStr = """
                {
                  "id": 1,
                  "name": {
                    "first": "Yong",
                    "last": "Mook Kim"
                  },
                  "contact": [
                    {
                      "type": "phone/work",
                      "ref": "222-222-2222"
                    }
                  ]
                }
                """;

        // String s = "{\"name\":\"isha\"}";
        //String patch = "{\"name\":\"nisha\",\"f\":\"b\"}" ;
        try {
            JsonNode source = mapper.readTree(refJsonStr);
            JsonNode target = mapper.readTree(newJsonStr);
            final JsonNode patchNode = JsonDiff.asJson(source, target);
            System.out.println("JSON-PATCH-Diff: " + patchNode.toPrettyString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Process Successful");
        }
    }
}
