package com.coffeebeans.springnativeawslambda.functions;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.coffeebeans.springnativeawslambda.model.Request;
import com.coffeebeans.springnativeawslambda.model.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.coffeebeans.springnativeawslambda.util.DynamoConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExampleFunction implements Function<Request, Response> {
  private static AmazonDynamoDB amazonDynamoDBClient = null;

  private static Table table = null;
  @Override
  public Response apply(final Request request) {
    log.info("Converting request into a response...");
    log.info(request.getName().toString());

    amazonDynamoDBClient = AmazonDynamoDBClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain()).withRegion(Regions.AP_NORTHEAST_1).build();
    table = new DynamoDB(amazonDynamoDBClient).getTable(DynamoConstants.TABLE_NAME);

    Item item = table.getItem(DynamoConstants.PARTITION_KEY, "88881P111R111",
            DynamoConstants.SORT_KEY, "1");
    String base_point = item.get("po").toString();
    log.info("base_point: "+base_point);
    log.info("getStrLi: "+String.valueOf(request.getStrLi().length));
    log.info("getJanList: "+String.valueOf(request.getJanList().size()));
    List<String> stringList = new ArrayList<>();

    stringList.add("A234567890ABC");
    stringList.add("B234567890ABC");
    stringList.add("C234567890ABC");
    stringList.add("D234567890ABC");
    stringList.add("E234567890ABC");

    final Response response = Response.builder()
        .rank(base_point)
        .saved(true)
        .janList(request.getJanList())
        .build();

    log.info("Converted request into a response.");
    return response;
  }
}
