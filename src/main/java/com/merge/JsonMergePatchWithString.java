package com.merge;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMergePatchWithString {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        String patch = """
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
    }
    String merge = """
{
    "title": "Hello!",
    "author": {
      "givenName": "Neil",
      "familyName": "Nitin"
    },
    "tags": [
      "Mohan",
      "Muskesh"
    ],
    "content": "Random comment"
}""";
}
