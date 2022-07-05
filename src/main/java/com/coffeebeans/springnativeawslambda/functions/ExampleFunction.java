package com.coffeebeans.springnativeawslambda.functions;

import com.coffeebeans.springnativeawslambda.model.Request;
import com.coffeebeans.springnativeawslambda.model.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExampleFunction implements Function<Request, Response> {

  @Override
  public Response apply(final Request request) {
    log.info("Converting request into a response...");

    List<String> stringList = new ArrayList<>();

    stringList.add("A234567890ABC");
    stringList.add("B234567890ABC");
    stringList.add("C234567890ABC");
    stringList.add("D234567890ABC");
    stringList.add("E234567890ABC");

    final Response response = Response.builder()
        .rank(request.getName())
        .saved(true)
        .janList(stringList)
        .build();

    log.info("Converted request into a response.");
    return response;
  }
}
