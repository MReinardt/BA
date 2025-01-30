/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 04 21:56:45 GMT 2025
 */

package evo.datastructures;

import datastructures.Transaction_ESTest_scaffolding;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import datastructures.Transaction;
import datastructures.TransactionType;
import java.time.LocalDateTime;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.time.MockLocalDateTime;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false, useJEE = true)
public class Transaction_ESTest extends Transaction_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      LocalDateTime localDateTime0 = MockLocalDateTime.now();
      Transaction transaction0 = new Transaction(466, (TransactionType) null, 466, "$gl}m]a5Iu", localDateTime0);
      transaction0.getType();
      assertEquals(466.0, transaction0.getAmount(), 0.01);
      assertEquals(466, transaction0.getTransactionId());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      TransactionType transactionType0 = TransactionType.WITHDRAWAL;
      Transaction transaction0 = new Transaction(0, transactionType0, 0, "");
      int int0 = transaction0.getTransactionId();
      assertEquals(0, int0);
      assertEquals(0.0, transaction0.getAmount(), 0.01);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      TransactionType transactionType0 = TransactionType.DEPOSIT;
      Transaction transaction0 = new Transaction((-3133), transactionType0, (-3133), "");
      int int0 = transaction0.getTransactionId();
      assertEquals((-3133), int0);
      assertEquals((-3133.0), transaction0.getAmount(), 0.01);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      TransactionType transactionType0 = TransactionType.TRANSFER;
      Transaction transaction0 = new Transaction(1, transactionType0, 0.0, (String) null);
      transaction0.getDescription();
      assertEquals(0.0, transaction0.getAmount(), 0.01);
      assertEquals(1, transaction0.getTransactionId());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      TransactionType transactionType0 = TransactionType.DEPOSIT;
      Transaction transaction0 = new Transaction((-3133), transactionType0, (-3133), "");
      transaction0.getDescription();
      assertEquals((-3133.0), transaction0.getAmount(), 0.01);
      assertEquals((-3133), transaction0.getTransactionId());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      TransactionType transactionType0 = TransactionType.WITHDRAWAL;
      Transaction transaction0 = new Transaction(288, transactionType0, 0.0, "M8p|q:fHYxq&", (LocalDateTime) null);
      double double0 = transaction0.getAmount();
      assertEquals(288, transaction0.getTransactionId());
      assertEquals(0.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      TransactionType transactionType0 = TransactionType.WITHDRAWAL;
      Transaction transaction0 = new Transaction((-2078), transactionType0, (-1517.460942799), "");
      double double0 = transaction0.getAmount();
      assertEquals((-1517.460942799), double0, 0.01);
      assertEquals((-2078), transaction0.getTransactionId());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      TransactionType transactionType0 = TransactionType.WITHDRAWAL;
      Transaction transaction0 = new Transaction(288, transactionType0, 0.0, "M8p|q:fHYxq&", (LocalDateTime) null);
      // Undeclared exception!
      try { 
        transaction0.toString();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // temporal
         //
         verifyException("java.util.Objects", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      TransactionType transactionType0 = TransactionType.WITHDRAWAL;
      Transaction transaction0 = new Transaction(1, transactionType0, 1, (String) null, (LocalDateTime) null);
      // Undeclared exception!
      try { 
        transaction0.getTimestamp();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // temporal
         //
         verifyException("java.util.Objects", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      TransactionType transactionType0 = TransactionType.WITHDRAWAL;
      LocalDateTime localDateTime0 = MockLocalDateTime.now();
      Transaction transaction0 = new Transaction(1803, transactionType0, 1803, "R=@aR[E", localDateTime0);
      double double0 = transaction0.getAmount();
      assertEquals(1803.0, double0, 0.01);
      assertEquals(1803, transaction0.getTransactionId());
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      TransactionType transactionType0 = TransactionType.WITHDRAWAL;
      LocalDateTime localDateTime0 = MockLocalDateTime.now();
      Transaction transaction0 = new Transaction(1803, transactionType0, 1803, "R=@aR[E", localDateTime0);
      String string0 = transaction0.toString();
      assertEquals("Transaction{Transaction ID: 1803, Type: WITHDRAWAL, Amount: 1803.0, Date: 14.02.2014 20:21:21, Description: R=@aR[E}", string0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      TransactionType transactionType0 = TransactionType.WITHDRAWAL;
      LocalDateTime localDateTime0 = MockLocalDateTime.now();
      Transaction transaction0 = new Transaction(1803, transactionType0, 1803, "R=@aR[E", localDateTime0);
      transaction0.getType();
      assertEquals(1803.0, transaction0.getAmount(), 0.01);
      assertEquals(1803, transaction0.getTransactionId());
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      TransactionType transactionType0 = TransactionType.WITHDRAWAL;
      Transaction transaction0 = new Transaction(128, transactionType0, 128, (String) null);
      String string0 = transaction0.getTimestamp();
      assertEquals(128, transaction0.getTransactionId());
      assertEquals("14.02.2014 20:21:21", string0);
      assertEquals(128.0, transaction0.getAmount(), 0.01);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      TransactionType transactionType0 = TransactionType.WITHDRAWAL;
      LocalDateTime localDateTime0 = MockLocalDateTime.now();
      Transaction transaction0 = new Transaction(1803, transactionType0, 1803, "R=@aR[E", localDateTime0);
      transaction0.getDescription();
      assertEquals(1803.0, transaction0.getAmount(), 0.01);
      assertEquals(1803, transaction0.getTransactionId());
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      TransactionType transactionType0 = TransactionType.WITHDRAWAL;
      LocalDateTime localDateTime0 = MockLocalDateTime.now();
      Transaction transaction0 = new Transaction(1803, transactionType0, 1803, "R=@aR[E", localDateTime0);
      int int0 = transaction0.getTransactionId();
      assertEquals(1803.0, transaction0.getAmount(), 0.01);
      assertEquals(1803, int0);
  }
}
