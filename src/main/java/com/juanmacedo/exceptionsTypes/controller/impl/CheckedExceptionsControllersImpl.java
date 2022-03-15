package com.juanmacedo.exceptionsTypes.controller.impl;

import com.juanmacedo.exceptionsTypes.controller.CheckedExceptionsControllers;
import com.juanmacedo.exceptionsTypes.model.Description;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.springframework.web.bind.annotation.RestController;

/** CheckedExceptionsControllersImpl, Exceptions that are checked by the compiler. */
@RestController
public class CheckedExceptionsControllersImpl implements CheckedExceptionsControllers {

  /**
   * IOException checked by the compiler.
   *
   * @return String data
   */
  @Override
  public Description ioException() {

    Description description = new Description();
    description.setMessage("This API pass through an checked IOException and print some logs");
    String pathFile = "C:/file_does_not_exist_provoke_error.txt";

    BufferedReader bufferedReader = null;
    String curline;

    try {
      bufferedReader = new BufferedReader(new FileReader(pathFile));

      while ((curline = bufferedReader.readLine()) != null) {
        System.out.println(curline);
      }
    } catch (
        IOException
            e) { // This exception has been ask by the compiler to continue programming (CHECKED)
      System.err.println("File does not exist: " + e);
      description.setError(e.toString());
    } finally {
      try {
        if (bufferedReader != null) {
          bufferedReader.close();
        }
      } catch (
          IOException
              e2) { // This exception has been ask by the compiler to continue programming (CHECKED)
        description.setError(e2.toString());
        e2.printStackTrace();
      }
    }

    return description;
  }

  /**
   * ClassNotFoundException checked by the compiler. Launch when the JVM doesnt found the class
   *
   * @return Description object
   */
  @Override
  public Description classNotFoundException() {
    Description description = new Description();

    try {
      Class loadedClass = Class.forName("NotFound");
      System.out.println("Class found: " + loadedClass);
    } catch (ClassNotFoundException e) {
      System.err.println("Class does not exist: " + e);
      description.setMessage("Class does not exist, checked exception: " + e.getMessage());
      description.setError(e.toString());
    }
    return description;
  }

  /**
   * InvocationTargetException checked by the compiler.
   *
   * @return Description object
   */
  @Override
  public Description invocationTargetException() {
    Description description = new Description();
    try {
      Class<?> class1 =
          Class.forName("com.juanmacedo.exceptionsTypes.services.impl.CheckedExceptionServiceImpl");
      Object instantce1 = class1.newInstance();
      Method[] methods = class1.getMethods();

      for (Method method : methods) {
        String methodName = method.getName();
        if (methodName.contains("throwException")) {
          method.setAccessible(true);
          Object returnValue = method.invoke(instantce1, "");
          System.out.format("%s() returned: %d%n", methodName, returnValue);
        }
      }
    } catch (IllegalAccessException
        | InstantiationException
        | InvocationTargetException
        | ClassNotFoundException e) {
      description.setMessage(e.getCause().getMessage());
      description.setError(e.toString());
      e.printStackTrace();
    }

    return description;
  }
}
