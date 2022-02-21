package com.project.HMF.Configuration;



import java.text.DecimalFormat;
import java.util.Random;

public class RandomNumberGenerator {
  public  static Integer getNumber()
    {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        String otp= new DecimalFormat("000000").format(new Random().nextInt(999999));
        // this will convert any number sequence into 6 character.
        return Integer.valueOf(otp);

    }
}
