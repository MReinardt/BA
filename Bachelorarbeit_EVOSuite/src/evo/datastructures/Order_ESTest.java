/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 04 21:54:09 GMT 2025
 */

package evo.datastructures;

import datastructures.Order_ESTest_scaffolding;
import org.junit.Test;
import static org.junit.Assert.*;
import datastructures.Order;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false, useJEE = true)
public class Order_ESTest extends Order_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Order order0 = new Order(0, 0);
      assertEquals("CREATED", order0.getStatus());
      
      order0.setStatus((String) null);
      order0.getStatus();
      assertEquals(0, order0.getOrderId());
      assertEquals(0, order0.getPrice());
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Order order0 = new Order(1, 1);
      assertEquals("CREATED", order0.getStatus());
      
      order0.setStatus("");
      order0.getStatus();
      assertEquals(1, order0.getOrderId());
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Order order0 = new Order(0, 0);
      int int0 = order0.getPrice();
      assertEquals(0, order0.getOrderId());
      assertEquals("CREATED", order0.getStatus());
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Order order0 = new Order(0, (-2535));
      int int0 = order0.getPrice();
      assertEquals("CREATED", order0.getStatus());
      assertEquals((-2535), int0);
      assertEquals(0, order0.getOrderId());
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      Order order0 = new Order(0, 0);
      int int0 = order0.getOrderId();
      assertEquals(0, int0);
      assertEquals(0, order0.getPrice());
      assertEquals("CREATED", order0.getStatus());
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      Order order0 = new Order((-3551), 0);
      int int0 = order0.getOrderId();
      assertEquals("CREATED", order0.getStatus());
      assertEquals(0, order0.getPrice());
      assertEquals((-3551), int0);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      Order order0 = new Order(3498, 3498);
      String string0 = order0.getStatus();
      assertEquals(3498, order0.getPrice());
      assertEquals(3498, order0.getOrderId());
      assertEquals("CREATED", string0);
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      Order order0 = new Order(3498, 3498);
      String string0 = order0.toString();
      assertEquals("Order{Order ID: 3498, Status: CREATED, Price: 3498}", string0);
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      Order order0 = new Order(3498, 3498);
      int int0 = order0.getPrice();
      assertEquals(3498, order0.getOrderId());
      assertEquals("CREATED", order0.getStatus());
      assertEquals(3498, int0);
  }

  @Test(timeout = 4000)
  public void test9()  throws Throwable  {
      Order order0 = new Order(3498, 3498);
      int int0 = order0.getOrderId();
      assertEquals(3498, int0);
      assertEquals(3498, order0.getPrice());
      assertEquals("CREATED", order0.getStatus());
  }
}
