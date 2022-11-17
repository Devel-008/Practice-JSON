package com.diff;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.diff.JsonDiff;

import java.io.IOException;

public class JsonDiffWithString {
    public static void main(String[] args) {
        final ObjectMapper mapper = new ObjectMapper();

        String s = """
{
  "name": {
    "first": "John",
    "last": "Doe"
  },
  "address": null,
  "birthday": "1990-01-01",
  "company": "Acme",
  "occupation": "Software engineer",
  "phones": [
    {
      "number": "000000000",
      "type": "home"
    },
    {
      "number": "999999999",
      "type": "mobile"
    }
  ]
}""";

        String patch = """
                    {
                                       "name": {
                                         "first": "Jane",
                                         "last": "Doe",
                                         "nickname": "Jenny"
                                       },
                                       "birthday": "1990-01-01",
                                       "occupation": null,
                                       "phones": [
                                         {
                                           "number": "111111111",
                                           "type": "mobile"
                                         }
                                       ],
                                       "favorite": true,
                                       "groups": [
                                         "close-friends",
                                         "gym"
                                       ]
                                     }
                """;
       // String s = "{\"name\":\"isha\"}";
        //String patch = "{\"name\":\"nisha\",\"f\":\"b\"}" ;
try {
    JsonNode source = mapper.readTree(s);
    JsonNode target = mapper.readTree(patch);
    // final JsonPatch jsonPatch = JsonDiff.asJsonPatch(source, target);
    //System.out.println("JSON-PATCH-Diff: " + jsonPatch + "\n");
    final JsonNode patchNode = JsonDiff.asJson(source, target);
    System.out.println("JSON-PATCH-Diff: " + patchNode.toPrettyString() + "\n");
}catch (IOException e){
    e.printStackTrace();
}finally {
    System.out.println("Process Successful");
}
    }
}

