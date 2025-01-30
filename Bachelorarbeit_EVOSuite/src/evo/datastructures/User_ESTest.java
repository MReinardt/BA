/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 04 21:59:06 GMT 2025
 */

package evo.datastructures;

import datastructures.User_ESTest_scaffolding;
import org.junit.Test;
import static org.junit.Assert.*;
import datastructures.Account;
import datastructures.Order;
import datastructures.User;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false, useJEE = true)
public class User_ESTest extends User_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Account account0 = new Account((-954), (String) null, (-954), (-954));
      User user0 = new User((-954), (String) null, (String) null, "{D;F#}oDV$\") ", (String) null, account0);
      String string0 = user0.getPhoneNumber();
      assertEquals((-954), user0.getId());
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      User user0 = new User(0, "", "", (String) null, "", (Account) null);
      String string0 = user0.getPhoneNumber();
      assertNotNull(string0);
      assertEquals(0, user0.getId());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      User user0 = new User((-918), (String) null, (String) null, (String) null, (String) null, (Account) null);
      user0.getLastName();
      assertEquals((-918), user0.getId());
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      User user0 = new User((-1955), "(c6J8_&RhPo", "tuq;(8m", "2!%};ef*4.{'1]", "(c6J8_&RhPo", (Account) null);
      assertEquals("tuq;(8m", user0.getLastName());
      
      user0.setLastName("");
      user0.getLastName();
      assertEquals("2!%};ef*4.{'1]", user0.getEmail());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      User user0 = new User(0, "O/:av", (String) null, "O/:av", (String) null, (Account) null);
      int int0 = user0.getId();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Account account0 = new Account((-1461), "Cx", (-1461), 0.0);
      User user0 = new User((-1461), "Cx", "Cx", "Cx", "Cx", account0);
      int int0 = user0.getId();
      assertEquals((-1461), int0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Account account0 = new Account((-954), (String) null, (-954), (-954));
      User user0 = new User((-954), (String) null, (String) null, "{D;F#}oDV$\") ", (String) null, account0);
      String string0 = user0.getFirstName();
      assertNull(string0);
      assertEquals((-954), user0.getId());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Account account0 = new Account(518, "", 518, (-1601.6175996));
      User user0 = new User(518, "", "mi>", "", "", account0);
      String string0 = user0.getFirstName();
      assertEquals("", string0);
      assertEquals("mi>", user0.getLastName());
      assertEquals(518, user0.getId());
      assertEquals("", user0.getEmail());
      assertEquals("", user0.getPhoneNumber());
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Account account0 = new Account((-2916), (String) null, (-2916), 0.0);
      User user0 = new User((-870), (String) null, (String) null, (String) null, (String) null, account0);
      user0.getEmail();
      assertEquals((-870), user0.getId());
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Account account0 = new Account(1, "", 0, 1);
      User user0 = new User(0, "", "", "", "", account0);
      user0.getEmail();
      assertEquals(0, user0.getId());
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      User user0 = new User((-1955), "(c6J8_&RhPo", "tuq;(8m", "2!%};ef*4.{'1]", "(c6J8_&RhPo", (Account) null);
      user0.getAccount();
      assertEquals("2!%};ef*4.{'1]", user0.getEmail());
      assertEquals((-1955), user0.getId());
      assertEquals("(c6J8_&RhPo", user0.getPhoneNumber());
      assertEquals("tuq;(8m", user0.getLastName());
      assertEquals("(c6J8_&RhPo", user0.getFirstName());
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Account account0 = new Account(0, (String) null, 125, 125);
      User user0 = new User(0, "", "g>~S2\u0005p", (String) null, "!t5FLI]!L$C1$", account0);
      user0.getAccount();
      assertEquals("!t5FLI]!L$C1$", user0.getPhoneNumber());
      assertEquals("g>~S2\u0005p", user0.getLastName());
      assertEquals(0, user0.getId());
      assertEquals("", user0.getFirstName());
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Account account0 = new Account(1, ";<", 0, 0.0);
      User user0 = new User(244, "H", ";<", "H", ";<", account0);
      user0.getAccount();
      assertEquals(244, user0.getId());
      assertEquals(";<", user0.getPhoneNumber());
      assertEquals(";<", user0.getLastName());
      assertEquals("H", user0.getEmail());
      assertEquals("H", user0.getFirstName());
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Account account0 = new Account((-258), "_bMN", (-1), (-1));
      User user0 = new User((-258), "G-#65,Fxb,", "G-#65,Fxb,", "G-#65,Fxb,", "_bMN", account0);
      user0.getAccount();
      assertEquals("_bMN", user0.getPhoneNumber());
      assertEquals("G-#65,Fxb,", user0.getEmail());
      assertEquals("G-#65,Fxb,", user0.getFirstName());
      assertEquals((-258), user0.getId());
      assertEquals("G-#65,Fxb,", user0.getLastName());
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Account account0 = new Account(0, "Usr~i", 0, 0);
      User user0 = new User(0, "Usr~i", "Usr~i", "Usr~i", "Usr~i", account0);
      user0.setId(0);
      assertEquals(0, user0.getId());
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Account account0 = new Account(924, "/ey'", 924, 924);
      User user0 = new User(924, "/ey'", "/ey'", "/ey'", "/ey'", account0);
      user0.getPhoneNumber();
      assertEquals(924, user0.getId());
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Account account0 = new Account(924, "/ey'", 924, 924);
      User user0 = new User(924, "/ey'", "/ey'", "/ey'", "/ey'", account0);
      user0.getEmail();
      assertEquals(924, user0.getId());
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Account account0 = new Account(924, "/ey'", 924, 924);
      User user0 = new User(924, "/ey'", "/ey'", "/ey'", "/ey'", account0);
      user0.setFirstName("/ey'");
      assertEquals(924, user0.getId());
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Account account0 = new Account(23, "N\"vEIxqu0?Ak3#", 23, 23);
      User user0 = new User(23, "N\"vEIxqu0?Ak3#", "N\"vEIxqu0?Ak3#", "N\"vEIxqu0?Ak3#", "N\"vEIxqu0?Ak3#", account0);
      user0.setAccount(account0);
      assertEquals(23, user0.getId());
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      Account account0 = new Account(23, "N\"vEIxqu0?Ak3#", 23, 23);
      User user0 = new User(23, "N\"vEIxqu0?Ak3#", "N\"vEIxqu0?Ak3#", "N\"vEIxqu0?Ak3#", "N\"vEIxqu0?Ak3#", account0);
      user0.getFirstName();
      assertEquals(23, user0.getId());
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Account account0 = new Account(924, "/ey'", 924, 924);
      User user0 = new User(924, "/ey'", "/ey'", "/ey'", "/ey'", account0);
      user0.setEmail("/ey'");
      assertEquals(924, user0.getId());
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      Account account0 = new Account(924, "/ey'", 924, 924);
      User user0 = new User(924, "/ey'", "/ey'", "/ey'", "/ey'", account0);
      String string0 = user0.toString();
      assertEquals("User{User ID: 924, First Name: /ey', Last Name: /ey', Email: /ey', Phone Number: /ey', Orders: []}", string0);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Account account0 = new Account(23, "N\"vEIxqu0?Ak3#", 23, 23);
      User user0 = new User(23, "N\"vEIxqu0?Ak3#", "N\"vEIxqu0?Ak3#", "N\"vEIxqu0?Ak3#", "N\"vEIxqu0?Ak3#", account0);
      user0.getLastName();
      assertEquals(23, user0.getId());
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      Account account0 = new Account(924, "/ey'", 924, 924);
      User user0 = new User(924, "/ey'", "/ey'", "/ey'", "/ey'", account0);
      Order order0 = new Order(924, 924);
      user0.addOrder(order0);
      user0.getOrders();
      assertEquals(924, user0.getId());
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      Account account0 = new Account(924, "/ey'", 924, 924);
      User user0 = new User(924, "/ey'", "/ey'", "/ey'", "/ey'", account0);
      user0.getOrders();
      assertEquals(924, user0.getId());
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      Account account0 = new Account(23, "N\"vEIxqu0?Ak3#", 23, 23);
      User user0 = new User(23, "N\"vEIxqu0?Ak3#", "N\"vEIxqu0?Ak3#", "N\"vEIxqu0?Ak3#", "N\"vEIxqu0?Ak3#", account0);
      user0.setPhoneNumber("N\"vEIxqu0?Ak3#");
      assertEquals(23, user0.getId());
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      Account account0 = new Account(23, "N\"vEIxqu0?Ak3#", 23, 23);
      User user0 = new User(23, "N\"vEIxqu0?Ak3#", "N\"vEIxqu0?Ak3#", "N\"vEIxqu0?Ak3#", "N\"vEIxqu0?Ak3#", account0);
      int int0 = user0.getId();
      assertEquals(23, int0);
  }
}
