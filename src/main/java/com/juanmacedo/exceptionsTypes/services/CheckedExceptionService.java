package com.juanmacedo.exceptionsTypes.services;

/** Checked Exception service interface. */
public interface CheckedExceptionService {

  /**
   * Throw an exception that has to be caught.
   *
   * @param stringData String data
   * @return String data
   */
  String throwException(String stringData);
}
