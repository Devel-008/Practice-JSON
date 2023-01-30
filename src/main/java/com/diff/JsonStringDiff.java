package com.diff;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.diff.JsonDiff;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class JsonStringDiff {

        public static void main(String[] args) {
            Map<JsonPointer,Set<String>> map;
            final ObjectMapper mapper = new ObjectMapper();
            String s = """
                       "RoleInVem": [
                                 {
                                   "roleName": "Role1",
                                   "orgBidNumber": "11111111",
                                   "updateTime": 1234
                                 },
                             {
                                   "roleName": "Role2",
                                   "orgBidNumber": "11111111",
                                   "updateTime": 1234
                                 }
                       
                               ]
                       
                    """;
            String diff = """
                                       "RoleInVem": [
                                 {
                                   "roleName": "Role3",
                                   "orgBidNumber": "11111111",
                                   "updateTime": 1234
                                 },
                             {
                                   "roleName": "Role2",
                                   "orgBidNumber": "xxxxxxx",
                                   "updateTime": 1234
                                 }
                       
                               ]
                       
                    """;

            // String s = "{\"name\":\"isha\"}";
            //String patch = "{\"name\":\"nisha\",\"f\":\"b\"}" ;
            try {
                JsonNode source = mapper.readTree(s);
                JsonNode target = mapper.readTree(diff);
                final JsonPatch jsonPatch = JsonDiff.asJsonPatch(source, target);
                System.out.println("JSON-PATCH-Diff: " + jsonPatch );
                final JsonNode patchNode = JsonDiff.asJson(source, target);
                System.out.println("JSON-PATCH-Diff: " + patchNode.toPrettyString() + "\n");
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                System.out.println("Process Successful");
            }
        }
    }



