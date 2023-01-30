package com.diff;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.diff.JsonDiff;



public class JsonDiffWithString {
    public static void main(String[] args) {
        final ObjectMapper mapper = new ObjectMapper();
/*
        String s = """
{
  "name": {
    "first": "John",
    "last": "Doe"
  },
  "address": null,
  "birthday": "1990-01-01",
  "company": "Acme",
  "occupation": "Software engineer",
  "phones": [
    {
      "number": "000000000",
      "type": "home"
    },
    {
      "number": "999999999",
      "type": "mobile"
    }
  ]
}""";

        String patch = """
                    {
                                       "name": {
                                         "first": "Jane",
                                         "last": "Doe",
                                         "nickname": "Jenny"
                                       },
                                       "birthday": "1990-01-01",
                                       "occupation": null,
                                       "phones": [
                                         {
                                           "number": "111111111",
                                           "type": "mobile"
                                         }
                                       ],
                                       "favorite": true,
                                       "groups": [
                                         "close-friends",
                                         "gym"
                                       ]
                                     }
                """;*/
        String s = """
                {
                  "movies": [
                    {
                      "title": "Star Wars: Episode IV - A New Hope",
                      "directors": ["George Lucas"],
                      "year": 1977
                    },
                    {
                      "title": "Starship Troopers",
                      "directors": ["Paul Verhoeven"],
                      "year": 1997
                    },
                    {
                      "title": "Fight Club",
                      "directors": ["David Fincher"],
                      "year": 1999
                    },
                    {
                      "title": "Groundhog Day",
                      "directors": ["Harold Ramis"],
                      "year": 1993
                    },
                    {
                      "title": "Serenity",
                      "directors": ["Joss Wheldon"],
                      "year": 2005
                    },
                    {
                      "title": "Tron",
                      "directors": ["Steven Lisberger"],
                      "year": 1982
                    },
                    {
                      "title": "The Matrix",
                      "directors": ["Lana Wachowski", "Lilly Wachowski"],
                      "year": 1999
                    },
                    {
                      "title": "Blade Runner",
                      "directors": ["Ridley Scott"],
                      "year": 1982
                    },
                    {
                      "title": "Monty Python and the Holy Grail",
                      "directors": ["Terry Gilliam", "Terry Jones"],
                      "year": 1975
                    },
                    {
                      "title": "2001: A Space Odyssey",
                      "directors": ["Stanley Kubrick"],
                      "year": 1968
                    }
                  ]
                }""";
        String diff = """
                {
                  "movies": [
                    {
                      "title": "Star Wars: Episode IV - A New Hope",
                      "directors": ["George Lucas"],
                      "year": 1977
                    },
                    {
                      "title": "Starship Troopers",
                      "directors": ["Paul Verhoeven"],
                      "year": 1997
                    },
                    {
                      "title": "Fight Club",
                      "directors": ["David Fincher"],
                      "year": 1999
                    },
                    {
                      "title": "Groundhog Day",
                      "directors": ["Harold Ramis"],
                      "year": 1993
                    },
                    {
                      "title": "Serenity",
                      "directors": ["Joss Wheldon"],
                      "year": 2005
                    },
                    {
                      "title": "Tron",
                      "directors": ["Steven Lisberger"],
                      "year": 1982
                    },
                    {
                      "title": "The Matrix",
                      "directors": ["Lana Wachowski", "Lilly Wachowski"],
                      "year": 1999
                    },
                    {
                      "title": "Blade Runner",
                      "directors": ["Ridley Scott"],
                      "year": 1982
                    },
                    {
                      "title": "Monty Python and the Holy Grail",
                      "directors": ["Terry Gilliam"],
                      "year": 1975
                    },
                    {
                      "title": "2001: A Space Odyssey",
                      "directors": ["Stanley Kubrick"],
                      "year": 1968
                    }
                  ]
                }""";

        String array = "{\"Role Display Name\":\"Test Role Pset\",\"Role Category\":\"Default\",\"Role Name\":\"Test Role Pset\",\"Role Description\":\"Test Role Pset\",\"Organization\":\"Confluxsys\",\"Role Owner Login\":\"PBULE\",\"Role ID\":\"14350\",\"$identifier\":\"14350\",\"Entitlements\":[{\"Application Key\":\"121\",\"Entitlement Type\":\"UD_GROUPS_GROUPS\",\"Entitlement Name\":\"144~Network Security Role\"},{\"Application Key\":\"562\",\"Entitlement Type\":\"UD_GROUPS_GROUPS\",\"Entitlement Name\":\"565~Deployment Owners\"}]}";

        String diff1 = "{\"Role Display Name\":\"Test Role Pset\",\"Role Category\":\"Default\",\"Role Name\":\"Test Role Pset\",\"Role Description\":\"Test Role Pset\",\"Organization\":\"Confluxsys\",\"Role Owner Login\":\"PBULE\",\"Role ID\":\"14350\",\"$identifier\":\"14350\",\"Entitlements\":[{\"Application Key\":\"122\",\"Entitlement Type\":\"UD_GROUPS_GROUPS\",\"Entitlement Name\":\"144~Network Security Role\"},{\"Application Key\":\"562\",\"Entitlement Type\":\"UD_GROUPS_GROUPS\",\"Entitlement Name\":\"565~Deployment Owners\"}]}";
try {
    JsonNode source = mapper.valueToTree(array);
    JsonNode target = mapper.valueToTree(diff1);
     final JsonPatch jsonPatch = JsonDiff.asJsonPatch(target, source);
    //System.out.println("JSON-PATCH-Diff: " + jsonPatch + "\n");
    final JsonNode patchNode = JsonDiff.asJson(source, target);

    System.out.println("JSON-PATCH-Diff: " + patchNode.toPrettyString() + "\n");
} finally {
    System.out.println("Process Successful");
}
    }
}

