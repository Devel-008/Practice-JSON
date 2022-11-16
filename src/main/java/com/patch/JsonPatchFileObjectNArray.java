package com.patch;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

import java.io.IOException;
import java.nio.file.Paths;

public class JsonPatchFileObjectNArray {
    public static void main(String[] args)  {
        try {
            final ObjectMapper mapper = new ObjectMapper();

            JsonNode node = mapper.readTree(Paths.get("/Users/ishasethia/Desktop/Json/java.json").toFile());
            System.out.println("com.patch.User-Data :- " + node + "\n");
            JsonNode op = mapper.readTree(Paths.get("/Users/ishasethia/Desktop/Json/op.json").toFile());
            final JsonPatch patch = JsonPatch.fromJson(op);
            System.out.println("Operations :- " + patch + "\n");
            final JsonNode patched = patch.apply(node);
            System.out.println("Patched Values:- " + patched + "\n");
        }catch (JsonPatchException | IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Process Successful");
        }
    }
}


