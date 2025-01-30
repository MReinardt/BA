package test.java.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import datastructures.Account;
import datastructures.Order;
import datastructures.User;
import exceptions.InsufficientFundsException;
import exceptions.InvalidOrderException;
import exceptions.OrderNotFoundException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.OrderService;

class OrderServiceDiffblueTest {
    /**
     * Test {@link OrderService#createOrder(User, int)}.
     * <p>
     * Method under test: {@link OrderService#createOrder(User, int)}
     */
    @Test
    @DisplayName("Test createOrder(User, int)")
    void testCreateOrder() throws InvalidOrderException {
        // Arrange
        OrderService orderService = new OrderService();
        User user = new User(1, "Jane", "Doe", "jane.doe@example.org", "6625550144", new Account(1, "42", 10, 10.0d));

        // Act
        orderService.createOrder(user, 1);

        // Assert
        List<Order> orders = user.getOrders();
        assertEquals(1, orders.size());
        Order getResult = orders.get(0);
        assertEquals("CREATED", getResult.getStatus());
        assertEquals(0, getResult.getOrderId());
        assertEquals(1, getResult.getPrice());
    }

    /**
     * Test {@link OrderService#createOrder(User, int)}.
     * <ul>
     *   <li>When {@code null}.</li>
     * </ul>
     * <p>
     * Method under test: {@link OrderService#createOrder(User, int)}
     */
    @Test
    @DisplayName("Test createOrder(User, int); when 'null'")
    @Disabled("TODO: Complete this test")
    void testCreateOrder_whenNull() throws InvalidOrderException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: User cannot be null.
        //       at main.services.OrderService.validateUser(OrderService.java:58)
        //       at main.services.OrderService.createOrder(OrderService.java:12)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        (new OrderService()).createOrder(null, 1);
    }

    /**
     * Test {@link OrderService#createOrder(User, int)}.
     * <ul>
     *   <li>When zero.</li>
     *   <li>Then throw {@link InvalidOrderException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link OrderService#createOrder(User, int)}
     */
    @Test
    @DisplayName("Test createOrder(User, int); when zero; then throw InvalidOrderException")
    void testCreateOrder_whenZero_thenThrowInvalidOrderException() throws InvalidOrderException {
        // Arrange
        OrderService orderService = new OrderService();

        // Act and Assert
        assertThrows(InvalidOrderException.class, () -> orderService.createOrder(
                new User(1, "Jane", "Doe", "jane.doe@example.org", "6625550144", new Account(1, "42", 10, 10.0d)), 0));
    }

    /**
     * Test {@link OrderService#payOrder(User, int)}.
     * <p>
     * Method under test: {@link OrderService#payOrder(User, int)}
     */
    @Test
    @DisplayName("Test payOrder(User, int)")
    void testPayOrder() throws InvalidOrderException, OrderNotFoundException {
        // Arrange
        OrderService orderService = new OrderService();

        // Act and Assert
        assertThrows(OrderNotFoundException.class, () -> orderService.payOrder(
                new User(1, "Jane", "Doe", "jane.doe@example.org", "6625550144", new Account(1, "42", 10, 10.0d)), 1));
    }

    /**
     * Test {@link OrderService#payOrder(User, int)}.
     * <p>
     * Method under test: {@link OrderService#payOrder(User, int)}
     */
    @Test
    @DisplayName("Test payOrder(User, int)")
    void testPayOrder2() throws InvalidOrderException, OrderNotFoundException {
        // Arrange
        OrderService orderService = new OrderService();

        User user = new User(1, "Jane", "Doe", "jane.doe@example.org", "6625550144", new Account(1, "42", 10, 10.0d));
        user.addOrder(new Order(1, 1));

        // Act
        orderService.payOrder(user, 1);

        // Assert
        List<Order> orders = user.getOrders();
        assertEquals(1, orders.size());
        assertEquals("PAID", orders.get(0).getStatus());
        assertEquals(9.0d, user.getAccount().getBalance());
    }

    /**
     * Test {@link OrderService#payOrder(User, int)}.
     * <p>
     * Method under test: {@link OrderService#payOrder(User, int)}
     */
    @Test
    @DisplayName("Test payOrder(User, int)")
    void testPayOrder3() throws InvalidOrderException, OrderNotFoundException {
        // Arrange
        OrderService orderService = new OrderService();

        User user = new User(1, "Jane", "Doe", "jane.doe@example.org", "6625550144", new Account(1, "42", 10, 10.0d));
        user.addOrder(new Order(2, 1));
        user.addOrder(new Order(1, 1));

        // Act
        orderService.payOrder(user, 1);

        // Assert
        List<Order> orders = user.getOrders();
        assertEquals(2, orders.size());
        assertEquals("CREATED", orders.get(0).getStatus());
        assertEquals("PAID", orders.get(1).getStatus());
        assertEquals(9.0d, user.getAccount().getBalance());
    }

    /**
     * Test {@link OrderService#payOrder(User, int)}.
     * <p>
     * Method under test: {@link OrderService#payOrder(User, int)}
     */
    @Test
    @DisplayName("Test payOrder(User, int)")
    @Disabled("TODO: Complete this test")
    void testPayOrder4() throws InvalidOrderException, OrderNotFoundException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "main.datastructures.Account.getBalance()" because the return value of "main.datastructures.User.getAccount()" is null
        //       at main.services.OrderService.validateUserBalance(OrderService.java:63)
        //       at main.services.OrderService.payOrder(OrderService.java:21)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        OrderService orderService = new OrderService();

        User user = new User(1, "Jane", "Doe", "jane.doe@example.org", "6625550144", null);
        user.addOrder(new Order(1, 1));

        // Act
        orderService.payOrder(user, 1);
    }

    /**
     * Test {@link OrderService#payOrder(User, int)}.
     * <ul>
     *   <li>Given {@code null}.</li>
     * </ul>
     * <p>
     * Method under test: {@link OrderService#payOrder(User, int)}
     */
    @Test
    @DisplayName("Test payOrder(User, int); given 'null'")
    @Disabled("TODO: Complete this test")
    void testPayOrder_givenNull() throws InvalidOrderException, OrderNotFoundException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "main.datastructures.Order.getOrderId()" because "o" is null
        //       at main.services.OrderService.lambda$findOrder$0(OrderService.java:70)
        //       at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:196)
        //       at java.base/java.util.ArrayList$ArrayListSpliterator.tryAdvance(ArrayList.java:1686)
        //       at java.base/java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:147)
        //       at java.base/java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:588)
        //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:574)
        //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        //       at java.base/java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        //       at java.base/java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:687)
        //       at main.services.OrderService.findOrder(OrderService.java:71)
        //       at main.services.OrderService.payOrder(OrderService.java:21)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        OrderService orderService = new OrderService();

        User user = new User(1, "Jane", "Doe", "jane.doe@example.org", "6625550144", new Account(1, "42", 10, 10.0d));
        user.addOrder(null);

        // Act
        orderService.payOrder(user, 1);
    }

    /**
     * Test {@link OrderService#payOrder(User, int)}.
     * <ul>
     *   <li>Then throw {@link InsufficientFundsException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link OrderService#payOrder(User, int)}
     */
    @Test
    @DisplayName("Test payOrder(User, int); then throw InsufficientFundsException")
    void testPayOrder_thenThrowInsufficientFundsException() throws InvalidOrderException, OrderNotFoundException {
        // Arrange
        OrderService orderService = new OrderService();

        User user = new User(1, "Jane", "Doe", "jane.doe@example.org", "6625550144", new Account(1, "42", 10, 0.5d));
        user.addOrder(new Order(1, 1));

        // Act and Assert
        assertThrows(InsufficientFundsException.class, () -> orderService.payOrder(user, 1));
    }

    /**
     * Test {@link OrderService#payOrder(User, int)}.
     * <ul>
     *   <li>Then throw {@link OrderNotFoundException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link OrderService#payOrder(User, int)}
     */
    @Test
    @DisplayName("Test payOrder(User, int); then throw OrderNotFoundException")
    void testPayOrder_thenThrowOrderNotFoundException() throws InvalidOrderException, OrderNotFoundException {
        // Arrange
        OrderService orderService = new OrderService();

        User user = new User(1, "Jane", "Doe", "jane.doe@example.org", "6625550144", new Account(1, "42", 10, 10.0d));
        user.addOrder(new Order(2, 1));

        // Act and Assert
        assertThrows(OrderNotFoundException.class, () -> orderService.payOrder(user, 1));
    }

    /**
     * Test {@link OrderService#payOrder(User, int)}.
     * <ul>
     *   <li>When {@code null}.</li>
     * </ul>
     * <p>
     * Method under test: {@link OrderService#payOrder(User, int)}
     */
    @Test
    @DisplayName("Test payOrder(User, int); when 'null'")
    @Disabled("TODO: Complete this test")
    void testPayOrder_whenNull() throws InvalidOrderException, OrderNotFoundException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "main.datastructures.User.getOrders()" because "user" is null
        //       at main.services.OrderService.findOrder(OrderService.java:69)
        //       at main.services.OrderService.payOrder(OrderService.java:21)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        (new OrderService()).payOrder(null, 1);
    }

    /**
     * Test {@link OrderService#deliverOrder(User, int)}.
     * <p>
     * Method under test: {@link OrderService#deliverOrder(User, int)}
     */
    @Test
    @DisplayName("Test deliverOrder(User, int)")
    void testDeliverOrder() throws InvalidOrderException, OrderNotFoundException {
        // Arrange
        OrderService orderService = new OrderService();

        // Act and Assert
        assertThrows(OrderNotFoundException.class, () -> orderService.deliverOrder(
                new User(1, "Jane", "Doe", "jane.doe@example.org", "6625550144", new Account(1, "42", 10, 10.0d)), 1));
    }

    /**
     * Test {@link OrderService#deliverOrder(User, int)}.
     * <ul>
     *   <li>Given {@code null}.</li>
     * </ul>
     * <p>
     * Method under test: {@link OrderService#deliverOrder(User, int)}
     */
    @Test
    @DisplayName("Test deliverOrder(User, int); given 'null'")
    @Disabled("TODO: Complete this test")
    void testDeliverOrder_givenNull() throws InvalidOrderException, OrderNotFoundException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "main.datastructures.Order.getOrderId()" because "o" is null
        //       at main.services.OrderService.lambda$findOrder$0(OrderService.java:70)
        //       at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:196)
        //       at java.base/java.util.ArrayList$ArrayListSpliterator.tryAdvance(ArrayList.java:1686)
        //       at java.base/java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:147)
        //       at java.base/java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:588)
        //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:574)
        //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        //       at java.base/java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        //       at java.base/java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:687)
        //       at main.services.OrderService.findOrder(OrderService.java:71)
        //       at main.services.OrderService.getOrderState(OrderService.java:52)
        //       at main.services.OrderService.updateOrderStatusIfValid(OrderService.java:36)
        //       at main.services.OrderService.deliverOrder(OrderService.java:31)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        OrderService orderService = new OrderService();

        User user = new User(1, "Jane", "Doe", "jane.doe@example.org", "6625550144", new Account(1, "42", 10, 10.0d));
        user.addOrder(null);

        // Act
        orderService.deliverOrder(user, 1);
    }

    /**
     * Test {@link OrderService#deliverOrder(User, int)}.
     * <ul>
     *   <li>Then throw {@link InvalidOrderException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link OrderService#deliverOrder(User, int)}
     */
    @Test
    @DisplayName("Test deliverOrder(User, int); then throw InvalidOrderException")
    void testDeliverOrder_thenThrowInvalidOrderException() throws InvalidOrderException, OrderNotFoundException {
        // Arrange
        OrderService orderService = new OrderService();

        User user = new User(1, "Jane", "Doe", "jane.doe@example.org", "6625550144", new Account(1, "42", 10, 10.0d));
        user.addOrder(new Order(1, 1));

        // Act and Assert
        assertThrows(InvalidOrderException.class, () -> orderService.deliverOrder(user, 1));
    }

    /**
     * Test {@link OrderService#deliverOrder(User, int)}.
     * <ul>
     *   <li>Then throw {@link InvalidOrderException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link OrderService#deliverOrder(User, int)}
     */
    @Test
    @DisplayName("Test deliverOrder(User, int); then throw InvalidOrderException")
    void testDeliverOrder_thenThrowInvalidOrderException2() throws InvalidOrderException, OrderNotFoundException {
        // Arrange
        OrderService orderService = new OrderService();

        User user = new User(1, "Jane", "Doe", "jane.doe@example.org", "6625550144", new Account(1, "42", 10, 10.0d));
        user.addOrder(new Order(2, 1));
        user.addOrder(new Order(1, 1));

        // Act and Assert
        assertThrows(InvalidOrderException.class, () -> orderService.deliverOrder(user, 1));
    }

    /**
     * Test {@link OrderService#deliverOrder(User, int)}.
     * <ul>
     *   <li>Then throw {@link OrderNotFoundException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link OrderService#deliverOrder(User, int)}
     */
    @Test
    @DisplayName("Test deliverOrder(User, int); then throw OrderNotFoundException")
    void testDeliverOrder_thenThrowOrderNotFoundException() throws InvalidOrderException, OrderNotFoundException {
        // Arrange
        OrderService orderService = new OrderService();

        User user = new User(1, "Jane", "Doe", "jane.doe@example.org", "6625550144", new Account(1, "42", 10, 10.0d));
        user.addOrder(new Order(2, 1));

        // Act and Assert
        assertThrows(OrderNotFoundException.class, () -> orderService.deliverOrder(user, 1));
    }

    /**
     * Test {@link OrderService#deliverOrder(User, int)}.
     * <ul>
     *   <li>When {@code null}.</li>
     * </ul>
     * <p>
     * Method under test: {@link OrderService#deliverOrder(User, int)}
     */
    @Test
    @DisplayName("Test deliverOrder(User, int); when 'null'")
    @Disabled("TODO: Complete this test")
    void testDeliverOrder_whenNull() throws InvalidOrderException, OrderNotFoundException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: User cannot be null.
        //       at main.services.OrderService.validateUser(OrderService.java:58)
        //       at main.services.OrderService.getOrderState(OrderService.java:51)
        //       at main.services.OrderService.updateOrderStatusIfValid(OrderService.java:36)
        //       at main.services.OrderService.deliverOrder(OrderService.java:31)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        (new OrderService()).deliverOrder(null, 1);
    }
}
