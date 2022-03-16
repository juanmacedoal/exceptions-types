package com.juanmacedo.exceptionsTypes.controller.impl;

import com.juanmacedo.exceptionsTypes.controller.UncheckedExceptionsControllers;
import com.juanmacedo.exceptionsTypes.model.Description;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

/**
 * UncheckedExceptions or runtimeExceptions are those that occur during the execution of the
 * program.
 */
@RestController
public class UncheckedExceptionsControllersImpl implements UncheckedExceptionsControllers {

  /**
   * NullPointer uncheckedException when a null is tested.
   *
   * @return Description model.
   */
  @Override
  public Description nullPointerException() {
    Description description = null;

    try {
      description.setError(
          "This is going to provoke a null pointer because the description object it is not initialize");
    } catch (NullPointerException e) {
      description = new Description();
      description.setMessage("NullPointerException cause for trying to access to a null value");
      description.setError(e.toString());
    }
    return description;
  }

  /**
   * ArrayIndexOutBoundException uncheckedException when try to access to a position array that not
   * exist.
   *
   * @return Description model
   */
  @Override
  public Description arrayIndexOutBoundException() {
    Description description = new Description();

    int a[] = new int[3];

    try {
      a[5] = 2;
    } catch (ArrayIndexOutOfBoundsException e) {
      System.err.println("Error");
      description.setMessage(
          "ArrayIndexOutBoundException cause for try to access to an non existing position");
      description.setError(e.toString());
    }
    return description;
  }

  /**
   * IndexOutBoundException uncheckedException when try to access to a position array that not
   * exist.
   *
   * @return Description model
   */
  @Override
  public Description indexOutBoundException() {
    Description description = new Description();

    List<String> stringList = new ArrayList<String>();

    try {
      stringList.get(5);
    } catch (IndexOutOfBoundsException e) {
      description.setMessage(
          "IndexOutBoundException cause for try to access to an non existing position");
      description.setError(e.toString());
    }
    return description;
  }

  /**
   * IllegalArgumentException uncheckedException when a value of a argument is not right.
   *
   * @return Description model
   */
  @Override
  public Description illegalArgumentException(String stringData) {
    Description description = new Description();
    try {
      if (stringData == null)
        throw new IllegalArgumentException("StringData must have a string value");
    } catch (IllegalArgumentException e) {
      description.setMessage(e.getMessage());
      description.setError(e.toString());
    }

    return description;
  }

  /**
   * IllegalStateException uncheckedException when a state that already exist.
   *
   * @return Description model
   */
  @Override
  public Description illegalStateException(String stringData) {
    Description description = new Description();
    try {
      if (stringData.equals("exist")) throw new IllegalStateException("StringData already exist");
    } catch (IllegalStateException e) {
      description.setMessage(e.getMessage());
      description.setError(e.toString());
    }

    return description;
  }
}
