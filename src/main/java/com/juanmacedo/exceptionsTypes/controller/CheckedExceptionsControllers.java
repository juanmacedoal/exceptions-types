package com.juanmacedo.exceptionsTypes.controller;

import com.juanmacedo.exceptionsTypes.model.Description;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/** Controllers interface. */
public interface CheckedExceptionsControllers {

  /**
   * IOException checked by the compiler.
   *
   * @return String data
   */
  @GetMapping(value = "/ioException")
  Description ioException();
}
