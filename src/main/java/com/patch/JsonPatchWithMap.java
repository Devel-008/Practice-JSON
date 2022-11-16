package com.patch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonPatchWithMap {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String , String > map = new HashMap<>();
        map.put("1","Amit");
        map.put("3","Rahul");
        map.put("5","Jai");
        map.put("7","Amit");
        String patch = """
    [
       { "op": "replace", "path": "/1", "value": "Siya"},
                       { "op": "remove", "path": "/5"},
                       { "op": "add", "path": "/3", "value": "+01-123-456-7890"},
                       { "op": "add", "path": "/4", "value": "Leela"},
                       { "op": "move", "from": "/3", "path": "/5" },
                       {"op": "copy", "from": "/1", "path": "/2"},
                        {"op": "test", "path": "/1", "value": "Siya"}
                      
        
   ]
""";
        JsonPatch jsonPatch;
        try {
            jsonPatch = JsonPatch.fromJson(mapper.readTree(patch));
            String target = String.valueOf(jsonPatch.apply(mapper.valueToTree(map)));
            System.out.println(target);
        } catch (IOException | JsonPatchException e) {
            e.printStackTrace();
        }
    }
}
