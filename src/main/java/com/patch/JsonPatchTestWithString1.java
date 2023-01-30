package com.patch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

import java.io.IOException;

public class JsonPatchTestWithString1 {
    public static void main(String[] args) {
        final ObjectMapper mapper = new ObjectMapper();

        String s = """
                {
                 	"Groups": [
                 	],
                 	"Profiles": {
                 	},
                 	"Extra": null
                 }
                 """;

       String patch = """
               [
               	{
               		"op": "add",
               		"path": "/Groups/-",
               		"value": {
               			"a": "b"
               		}
               	},
               	{
               		"op": "add",
               		"path": "/Groups/-",
               		"value": {
               			"a": "b"
               		}
               	}
               ]
                              
               """;

       /* String patch = """
                [
                \t{
                \t\t"op": "add",
                \t\t"path": "/Roles/0/a/0/b/-",
                \t\t"value": {
                \t\t\t"ROLE": "ETL SUPPORT"
                \t\t}
                \t}
                ]""";*/
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