package com.patch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

import java.io.IOException;

public class JsonPatchTestWithString {
    public static void main(String[] args) {
        final ObjectMapper mapper = new ObjectMapper();

        String s = """
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

       String patch = """
                   [
                       { "op": "replace", "path": "/title", "value":  {
                                                                                                "roleName": "newrole",
                                                                                                "orgBidNos": "neworg",
                                                                                                "updateTime": 678
                                                                                              }},
                       { "op": "remove", "path": "/tags"},
                       { "op": "add", "path": "/phoneNumber", "value": "+01-123-456-7890"}
                   
                     
                   ]
               """;
       try {
           JsonPatch jsonPatch = JsonPatch.fromJson(mapper.readTree(patch));
           String target = String.valueOf(jsonPatch.apply(mapper.readTree(s)).toPrettyString());
           System.out.println(target);

       }catch (JsonPatchException | IOException e){
           e.printStackTrace();
       }finally {
           System.out.println("Process Successful");
       }
        /*JsonNode node = mapper.readTree(Paths.get("/Users/ishasethia/Desktop/Json/java.json").toFile());
        //JsonPatch patch = JsonPatch.fromJson(node);
        System.out.println(node.path("firstName").asText());
        System.out.println(node.path("lastName").asText());
        System.out.println(node.path("age").asText());
        System.out.println(node.path("address").get(0).asText());*/

    }
}