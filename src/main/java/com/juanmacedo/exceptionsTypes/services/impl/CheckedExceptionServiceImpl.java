package com.juanmacedo.exceptionsTypes.services.impl;

import com.juanmacedo.exceptionsTypes.services.CheckedExceptionService;

/** Checked Exception service interface. */
public class CheckedExceptionServiceImpl implements CheckedExceptionService {

  /**
   * Throw an exception that has to be caught.
   *
   * @param stringData String data
   * @return String data
   */
  @Override
  public String throwException(String stringData) {
    if (stringData.length() == 0) throw new IllegalArgumentException("String is empty");

    return stringData;
  }
}
