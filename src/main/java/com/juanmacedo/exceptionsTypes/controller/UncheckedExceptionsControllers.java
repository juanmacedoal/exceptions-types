package com.juanmacedo.exceptionsTypes.controller;

import com.juanmacedo.exceptionsTypes.model.Description;
import javax.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * UncheckedExceptions or runtimeExceptions are those that occur during the execution of the
 * program.
 */
public interface UncheckedExceptionsControllers {

  /**
   * NullPointer uncheckedException when a null is tested.
   *
   * @return Description model.
   */
  @GetMapping("/nullPointerException")
  Description nullPointerException();

  /**
   * ArrayIndexOutBoundException uncheckedException when try to access to a position array that not
   * exist.
   *
   * @return Description model
   */
  @GetMapping("/arrayIndexOutBoundException")
  Description arrayIndexOutBoundException();

  /**
   * IndexOutBoundException uncheckedException when try to access to a position array that not
   * exist.
   *
   * @return Description model
   */
  @GetMapping("/indexOutBoundException")
  Description indexOutBoundException();

  /**
   * IllegalArgumentException uncheckedException when a value of a argument is not right.
   *
   * @return Description model
   */
  @GetMapping("/illegalArgumentException")
  Description illegalArgumentException(@PathParam("stringData") String stringData);

  /**
   * IllegalStateException uncheckedException when a state that already exist.
   *
   * @return Description model
   */
  @GetMapping("/illegalStateException")
  Description illegalStateException(@PathParam("stringData") String stringData);
}
