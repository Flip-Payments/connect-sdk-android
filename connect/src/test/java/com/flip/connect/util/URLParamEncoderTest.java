package com.flip.connect.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by JGabrielFreitas on 18/04/17.
 */
public class URLParamEncoderTest {

  @Test public void encode() throws Exception {

    String googleHost = "https://google.com/";
    Assert.assertEquals("https:%2F%2Fgoogle.com%2F", URLParamEncoder.encode(googleHost));
  }
}