package com.juanmacedo.exceptionsTypes.controller.impl;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.juanmacedo.exceptionsTypes.controller.CheckedExceptionsControllers;
import com.juanmacedo.exceptionsTypes.model.Description;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
}
