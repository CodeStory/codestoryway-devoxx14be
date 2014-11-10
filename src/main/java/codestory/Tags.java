package codestory;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.*;
import com.google.common.io.*;

public class Tags {
  public long count(String category, String... developerTags) {
    List<String> tagsForCategory = findAll().get(category);

    return Stream.of(developerTags).filter(tag -> tagsForCategory.contains(tag)).count();
  }

  Map<String, List<String>> findAll() {
    try {
      return new ObjectMapper().readValue(Resources.getResource("tags.json"), new TypeReference<Map<String, List<String>>>() {
      });
    } catch (IOException e) {
      throw new RuntimeException("Unable to load tags list", e);
    }
  }
}
