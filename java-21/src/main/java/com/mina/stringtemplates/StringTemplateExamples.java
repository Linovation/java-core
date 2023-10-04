package com.mina.stringtemplates;

import static java.util.FormatProcessor.FMT;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StringTemplateExamples {

  public static String greeting(String firstName, String lastName) {
    return STR."Hello! Good morning \{ firstName } \{ lastName }" ;
  }

  public static String multiplyWithArithmeticExpressions(int a, int b) {
    return STR."\{ a } times \{ b } = \{ a * b }" ;
  }

  public static String multiplyWithJavaExpression(int a, int b) {
    return STR."\{ a } times \{ b } = \{ Math.multiplyExact(a, b) }" ;
  }

  //  multiplication with floating point numbers rounded to two decimal places using the FMT template processor
  public static String multiplyFloatingNumbers(double a, double b) {
    return FMT."%.2f\{ a } times %.2f\{ b } = %.2f\{ a * b }" ;
  }

  public static String getErrorResponse(int httpStatus, String errorMessage) {
    return STR."""
    {
      "httpStatus": \{ httpStatus },
      "errorMessage": "\{ errorMessage }"
    }""" ;
  }

  public static String getCurrentDate() {
    return STR."Today's date: \{
        LocalDate.now().format(
            DateTimeFormatter.ofPattern("yyyy-MM-dd")
        ) }" ;
  }
}
