package com.juanmacedo.controller.impl;

import com.juanmacedo.controller.Controllers;
import java.util.Random;

/** ControllersImpl. */
public class ControllersImpl implements Controllers {

  /**
   * Return randome doubles to String.
   *
   * @return String data.
   */
  @Override
  public String getRandomInfo() {
    Random randomInstance = new Random();
    return randomInstance.doubles().toString();
  }
}
