package com.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertNotNull;


public class JokerTest {

   @Test
   public void getJoke() {
       assertNotNull(new Joker().getJoke());
   }
}
