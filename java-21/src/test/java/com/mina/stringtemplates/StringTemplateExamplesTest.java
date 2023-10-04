package com.mina.stringtemplates;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;

class StringTemplateExamplesTest {

  @Test
  public void testGreeting() {
    String expectedGreeting = "Hello! Good morning Mina Rahidi";
    String actualGreeting = StringTemplateExamples.greeting("Mina", "Rahidi");

    assertEquals(expectedGreeting, actualGreeting);
  }

  @Test
  public void testMultiplyWithArithmeticExpressions() {
    String expectedResult = "2 times 3 = 6";
    String actualResult = StringTemplateExamples.multiplyWithArithmeticExpressions(2, 3);

    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testMultiplyWithJavaExpression() {
    String expectedResult = "2 times 3 = 6";
    String actualResult = StringTemplateExamples.multiplyWithJavaExpression(2, 3);

    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testMultiplyFloatingNumbers() {
    String expectedResult = "2.57 times 3.50 = 8.99";
    String actualResult = StringTemplateExamples.multiplyFloatingNumbers(2.569, 3.5);

    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testGetErrorResponse() {
    String expectedErrorResponse = """
        {
          "httpStatus": 404,
          "errorMessage": "Not Found"
        }""";
    String actualErrorResponse = StringTemplateExamples.getErrorResponse(404, "Not Found");

    assertEquals(expectedErrorResponse, actualErrorResponse);
  }

  @Test
  public void testGetCurrentDate() {
    String expectedCurrentDate = "Today's date: " + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    String actualCurrentDate = StringTemplateExamples.getCurrentDate();

    assertEquals(expectedCurrentDate, actualCurrentDate);
  }
}