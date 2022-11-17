package com.diff;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.diff.JsonDiff;

import java.io.IOException;
import java.nio.file.Paths;

public class JsonDiffWithFile {
    public static void main(String[] args) {
            try {
                final ObjectMapper mapper = new ObjectMapper();

                JsonNode node = mapper.readTree(Paths.get("/Users/ishasethia/Desktop/Json/test.json").toFile());
                JsonNode diff = mapper.readTree(Paths.get("/Users/ishasethia/Desktop/Json/diff.json").toFile());
                JsonNode source = mapper.valueToTree(node);
                JsonNode target = mapper.valueToTree(diff);
                // final JsonPatch jsonPatch = JsonDiff.asJsonPatch(source, target);
                //System.out.println("JSON-PATCH-Diff: " + jsonPatch + "\n");
                final JsonNode patchNode = JsonDiff.asJson(source, target);
                System.out.println("JSON-PATCH-Diff: " + patchNode.toPrettyString() + "\n");

            }catch (IOException e) {
                e.printStackTrace();
            }finally {
                System.out.println("Process Successful");
            }
        }

    }

