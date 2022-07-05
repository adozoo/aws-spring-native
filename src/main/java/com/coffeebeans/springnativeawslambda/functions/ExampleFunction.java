package com.coffeebeans.springnativeawslambda.functions;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.coffeebeans.springnativeawslambda.model.Request;
import com.coffeebeans.springnativeawslambda.model.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.coffeebeans.springnativeawslambda.util.DynamoConstants;
import com.coffeebeans.springnativeawslambda.util.DynamoManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExampleFunction implements Function<Request, Response> {

  @Override
  public Response apply(final Request request) {
    log.info("Converting request into a response...");
    Item item = DynamoManager.getTable().getItem(DynamoConstants.PARTITION_KEY, "88881P111R111",
            DynamoConstants.SORT_KEY, "1");

    String base_point = item.get("po").toString();
    String base_pd = item.get("pd").toString();
    String base_janCode = item.get("jan").toString();
    String campaign_point = item.get("h").toString();

    StringBuilder str=new StringBuilder();

    str.append("{ \"janCode\": \"");
    str.append(base_janCode);
    str.append("\", \"point \": \"");
    str.append(base_point);
    str.append("\", \"campaignPre \": \"");
    str.append(base_pd);
    str.append("\", \"campaignCode \": \"");
    str.append(campaign_point);
    str.append("\" }");

    String requestItems = str.toString();

    List<String> stringList = new ArrayList<>();

    stringList.add("A234567890ABC");
    stringList.add("B234567890ABC");
    stringList.add("C234567890ABC");
    stringList.add("D234567890ABC");
    stringList.add("E234567890ABC");

    final Response response = Response.builder()
        .rank(requestItems)
        .saved(true)
        .janList(stringList)
        .build();

    log.info("Converted request into a response.");
    return response;
  }
}
