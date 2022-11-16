package com.patch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonPatchWithList  {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        List<Object> list = new ArrayList<>(7);
        list.add("Ram");
        list.add("Shyam");
        list.add("Kishan");
        list.add("Mohan");
        list.add("Arjun");
        System.out.println(list);
        String patch = """
    [
       { "op": "replace", "path": "/0", "value": "Siya"},
                       { "op": "remove", "path": "/4"},
                       { "op": "add", "path": "/3", "value": "+01-123-456-7890"},
                       { "op": "add", "path": "/4", "value": "Leela"},
                       { "op": "move", "from": "/0", "path": "/1" },
                       {"op": "copy", "from": "/1", "path": "/3"},
                       {"op": "test", "path": "/0", "value": "Shyam"}
        
   ]
""";
        JsonPatch jsonPatch;
        try {
            jsonPatch = JsonPatch.fromJson(mapper.readTree(patch));
            String target = String.valueOf(jsonPatch.apply(mapper.valueToTree(list)));
            System.out.println(target);
        } catch (IOException | JsonPatchException e) {
            e.printStackTrace();
        }



    }
}
