package com.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AvoidDuplication {
    public AvoidDuplication() {
    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
            /*String jsonStr = "{\"Technologies\" : [\"Java\", \"Scala\", \"Python\", \"Python\"]}";
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode arrayNode = (ArrayNode) mapper.readTree(jsonStr).get("Technologies");
            if(arrayNode.isArray()) {
                for(JsonNode jsonNode : arrayNode) {
                    if(!arrayNode.has(String.valueOf(jsonNode)))
                        System.out.println(!arrayNode.has(String.valueOf(jsonNode)));
                    System.out.println(jsonNode);

                }
            }
            String[] strArr = {"one","two","three","four","four","five"};
            //convert string array to list
            List<String> tmpList = List.of(strArr);
            //create a treeset with the list, which eliminates duplicates
            TreeSet<String> unique = new TreeSet<>(tmpList);
            System.out.println(unique);*/

        Map<String, String> objectWithDuplicates = new HashMap<>();
        objectWithDuplicates.put("name", "MyName");
        objectWithDuplicates.put("email", "em@ail");
        objectWithDuplicates.put("email", "em@ail");
        String jsonStr = "{\"Technologies\" : [\"Java\", \"Scala\", \"Python\", \"Python\"]}";
        String jsonWithDuplicates = mapper.writeValueAsString(objectWithDuplicates);
        Map<String, Object> attributesWithDuplicates = mapper.readValue(jsonWithDuplicates, Map.class);

        Map<String, Object> withoutDuplicates = new HashMap<>();
        attributesWithDuplicates.forEach((key, value) -> {
            if (! withoutDuplicates.containsKey(key.toLowerCase())) {
                withoutDuplicates.put(key.toLowerCase(), value);
            }
        });
        String json = mapper.writeValueAsString(withoutDuplicates);
        System.out.println(json);
      //  JsonNode node = mapper.readTree("src/main/resources/sample.json");

    }
   /* public static void removeProperty(JsonNode node, List<String> removedField){
        JsonNode modifiedNode = node;

        for (String nodeToBeRemoved: removedField){
            String[] array = nodeToBeRemoved.split("/");
            for (int i =1;i<array.length-1;i++){
                String name=array[i];
                modifiedNode = modifiedNode.get(name);
            }
            ((ObjectNode)modifiedNode).remove(array[array.length-1]);
        }

    }
    public static JsonNode removeProperties(JsonNode node, List<String> removedField){

        for (String nodeToBeRemoved: removedField){
            removeProperty(node, Collections.singletonList(nodeToBeRemoved));
        }

        return node;
    }
*/
    }

