package com.zerotospring.zerotospring.Exceptions;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ExceptionDetails {
  protected String devMessage;
}
