package com.diff;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.diff.JsonDiff;

import static java.lang.Math.min;

public class JsonDiffWithArray {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        int[] array = {1,2,3,4,5};
        int[] diff = {1,2,3,4,5,6};
        String h = "[{\"Application Key\":\"122\",\"Entitlement Type\":\"UD_GROUPS_GROUPS\",\"Entitlement Name\":\"144~Network Security Role\"},{\"Application Key\":\"562\",\"Entitlement Type\":\"UD_GROUPS_GROUPS\",\"Entitlement Name\":\"565~Deployment Owners\"}]";
        String h1 = "[{\"Application Key\":\"121\",\"Entitlement Type\":\"UD_GROUPS_GROUPS\",\"Entitlement Name\":\"144~Network Security Role\"},{\"Application Key\":\"562\",\"Entitlement Type\":\"UD_GROUPS_GROUPS\",\"Entitlement Name\":\"565~Deployment Owners\"}]";
        //int size = Math.min(h.length(),h1.length());

     //   int size = min(array.length,diff.length);
     //  System.out.println(size);


        JsonNode source = mapper.valueToTree(h);
        JsonNode target = mapper.valueToTree(h1);
        // final JsonPatch jsonPatch = JsonDiff.asJsonPatch(source, target);
        //System.out.println("JSON-PATCH-Diff: " + jsonPatch + "\n");
        final JsonNode patchNode = JsonDiff.asJson(source, target);
        System.out.println("JSON-PATCH-Diff: " + patchNode.toPrettyString() + "\n");
    }
}
