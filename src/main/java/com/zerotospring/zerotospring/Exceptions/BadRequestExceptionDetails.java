package com.zerotospring.zerotospring.Exceptions;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class BadRequestExceptionDetails extends ExceptionDetails {
  private String devMessage;
}
