package com.thoughtworks.tdd.loan;

import static com.thoughtworks.tdd.loan.utils.Stubs.uuid;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.path.json.config.JsonPathConfig.jsonPathConfig;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

class LoanControllerAcceptanceTest {

  private String accountId = uuid();

  @AcceptanceTest
  void shouldRequestNewLoanAndSeeAmountAndInterestRate() {
    var response =
            given().
                    baseUri("http://docker.local").
                    port(8080).
                    contentType(JSON).
                    body("{\"amount\": 200, \"durationInDays\": 365}").
                    when().
                    post("/api/v1/accounts/{accountId}/loans/", accountId).
                    then().
                    statusCode(202).
                    body("status", equalTo("ok")).
                    body("location.url", notNullValue()).
                    extract();

    String newLoanUrl = response.body().jsonPath(jsonPathConfig()).getString("location.url");

    given().
            baseUri("http://docker.local").
            port(8080).
            when().
            get(newLoanUrl).
            then().
            statusCode(200).
            body("amount", equalTo(200)).
            body("interestRate", equalTo(10)).
            body("interestBasis", equalTo(365)).
            body("durationInDays", equalTo(365));
  }
}