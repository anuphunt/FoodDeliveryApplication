package com.fooddeliveryapp.storefront.functionalProgramming;

import com.fooddeliveryapp.storefront.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SamsherFunctionsTest {
    private List<User> userList;
    List<Order> allOrders;

    @BeforeEach
    public void setUp() {
        userList = Arrays.asList(
                new User("1355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "sham.sher", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "Shamsher", "Rana", "example@example.com", "9999999999", "Fairfield", UserRole.CUSTOMER, 0),
                new User("2355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "user1", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "User1", "Acharya1", "example1@example.com", "098756", "Fairfield", UserRole.CUSTOMER, 0),
                new User("3355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "user2", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "User2", "Acharya2", "example2@example.com", "098756", "Fairfield", UserRole.CUSTOMER, 0),
                new User("4355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "user3", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "User3", "Acharya3", "example3@example.com", "098756", "Fairfield", UserRole.CUSTOMER, 0),
                new User("5355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "user4", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "User4", "Acharya4", "example4@example.com", "098756", "Fairfield", UserRole.CUSTOMER, 0),
                new User("6355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "user5", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "User5", "Acharya5", "example5@example.com", "098756", "Fairfield", UserRole.CUSTOMER, 0),
                new User("7355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "user6", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "User6", "Acharya6", "example6@example.com", "098756", "Fairfield", UserRole.CUSTOMER, 0),
                new User("8355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "user7", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "User7", "Acharya7", "example7@example.com", "098756", "Fairfield", UserRole.CUSTOMER, 0),
                new User("9355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "user8", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "User8", "Acharya8", "example8@example.com", "098756", "Fairfield", UserRole.CUSTOMER, 0),
                new User("1055a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "user9", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "User9", "Acharya9", "example90@example.com", "098756", "Fairfield", UserRole.CUSTOMER, 0),

                new User("105io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "Driver1", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "Driver1", "driver1", "driver1@example.com", "098756", "Fairfield", UserRole.DRIVER, 0),
                new User("205io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "Driver2", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "Driver2", "driver2", "driver2@example.com", "098756", "Fairfield", UserRole.DRIVER, 0),
                new User("305io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "Driver3", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "Driver3", "driver3", "driver3@example.com", "098756", "Fairfield", UserRole.DRIVER, 0),
                new User("405io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "Driver4", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "Driver4", "driver4", "driver4@example.com", "098756", "Fairfield", UserRole.DRIVER, 0),
                new User("505io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "Driver5", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "Driver5", "driver5", "driver5@example.com", "098756", "Fairfield", UserRole.DRIVER, 0),
                new User("605io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "Driver6", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "Driver6", "driver6", "driver6@example.com", "098756", "Fairfield", UserRole.DRIVER, 0),
                new User("705io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "Driver7", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "Driver7", "driver7", "driver7@example.com", "098756", "Fairfield", UserRole.DRIVER, 0),
                new User("805io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "Driver8", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "Driver8", "driver8", "driver8@example.com", "098756", "Fairfield", UserRole.DRIVER, 0),
                new User("905io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "Driver9", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "Driver9", "driver9", "driver9@example.com", "098756", "Fairfield", UserRole.DRIVER, 0),
                new User("100io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "Driver10", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "Driver10", "driver10", "driver10@example.com", "098756", "Fairfield", UserRole.DRIVER, 0),
                new User("11io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460ndd865", "Driver11", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "Driver11", "driver11", "driver11@example.com", "098756", "Fairfield", UserRole.DRIVER, 0),
                new User("12io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a2746n0dd865", "Driver12", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "Driver12", "driver12", "driver12@example.com", "098756", "Fairfield", UserRole.DRIVER, 0),

                new User("2355a46b19d348dc2f57c04tyf8ef63d4538ebb936000f3c9ee954a27460dd865", "restaurent1", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "Restaurent1", "Restaurent", "restaurent1@example.com", "098756", "Fairfield", UserRole.RESTAURANT, 0,41.0178239,-91.9678598),//argiro center
                new User("2355a46b19d348dc2f57c046f8eg63d4538ebb936000f3c9ee954a2746l0dd865", "restaurent2", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "Restaurent2", "Restaurent", "restaurent2@example.com", "098756", "Fairfield", UserRole.RESTAURANT, 0,41.0178239,-91.9678598),//argiro center
                new User("2355a46b19d348dc2f57c046f8ef63jk538ebb936000f3c9ee954a2746j0dd865", "restaurent3", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "Restaurent3", "Restaurent", "restaurent3@example.com", "098756", "Fairfield", UserRole.RESTAURANT, 0,41.0178239,-91.9678598),//argiro center
                new User("2355a46b19d348dc2f57c046f8df63d4538ebb936000f3c9ee954a27460dmd865", "restaurent4", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "Restaurent4", "Restaurent", "restaurent4@example.com", "098756", "Fairfield", UserRole.RESTAURANT, 0,41.0178239,-91.9678598),//argiro center
                new User("2355a46b19d348dc2f57c046f8ef63d4538ebbj576000f3c9ee954a27460dd865", "restaurent5", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "Restaurent5", "Restaurent", "restaurent5@example.com", "098756", "Fairfield", UserRole.RESTAURANT, 0,41.0038032,-92.3977244)//ottomuwa city
        );
        OrderEntity orderEntity = new OrderEntity("4355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", 5);
        allOrders = Arrays.asList(
                new Order("53c234e5e8472b6ac51c1ae1caghfe06fad053beb8ebfd8977b010655bfdd3c3", "1355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", Arrays.asList(orderEntity), "105io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", OrderState.REJECTED, "105io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865",24.00),
                new Order("53c234e5e8472b6ac51c1ae1cgh3ke06fad053beb8ebfd8977b010655bfdd3c3", "1355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", Arrays.asList(orderEntity), "105io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", OrderState.REJECTED, "105io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865",24.00),
                new Order("53c234e5e8472b6ac51c1ae1cab3fexdbvfad053beb8fd8977b010655bfdd3c3", "1355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", Arrays.asList(orderEntity), "105io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", OrderState.REJECTED, "105io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865",24.00),
                new Order("53c234e5e8472b6ac51c1ae1cab3fe06fad053beb8ebfd89yub010655bfdd3c3", "1355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", Arrays.asList(orderEntity), "105io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", OrderState.REJECTED, "105io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865",24.00),
                new Order("53c234e5e8472b6ac5fg1ae1cab3fe06fad053beb8ebfd8977b010655bfdd3c3", "1355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", Arrays.asList(orderEntity), "105io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", OrderState.REJECTED, "105io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865",24.00),
                new Order("53c234e5e8472b6ac51c1ae1cab3fe06fad053beb8ebfd8977b01065iopfd3c3", "1355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", Arrays.asList(orderEntity), "105io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", OrderState.REJECTED, "105io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865",24.00),
                new Order("53c234ere8472b6ac51c1ae1cab3fe06fad053beb8ebfd8977b010655bfdd3c3", "1355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", Arrays.asList(orderEntity), "105io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", OrderState.REJECTED, "105io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865",24.00),
                new Order("53c234e5e8472b6ac5jk1ae1cab3fe06fad053beb8ebfd8977b010655bfdd3c3", "1355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", Arrays.asList(orderEntity), "105io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", OrderState.REJECTED, "105io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865",24.00),
                new Order("53c234e5e8472b6ac51c1de1cab3fe06fa23053beb8ebfd8977b010655bfdd3c3", "1355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", Arrays.asList(orderEntity), "105io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", OrderState.REJECTED, "105io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865",24.00),
                new Order("53c234e5e8472b6ac51dfdae1cab3fe06fad053beb8ebfd8977b010655bfdd3c3", "1355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", Arrays.asList(orderEntity), "105io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", OrderState.REJECTED, "105io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865",24.00),

                new Order("53c234e5e8472b6ac51dfdae1cabrtfe06fio053bebbfd8977b01u0655bfdd3c3", "2355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "2355a46b19d348dc2f57c046f8eg63d4538ebb936000f3c9ee954a2746l0dd865", Arrays.asList(orderEntity), "11io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460ndd865", OrderState.REJECTED, "11io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460ndd865",24.00),
                new Order("53c234e5e8472b6ac51dfdae1cab3fe06fad345beb8ebfd8977b010655bfdd3c3", "2355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "2355a46b19d348dc2f57c046f8eg63d4538ebb936000f3c9ee954a2746l0dd865", Arrays.asList(orderEntity), "11io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460ndd865", OrderState.REJECTED, "11io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460ndd865",24.00),
                new Order("53c234e5e8472b6ac51dfdae1cab3fe06fad053beb8ebfd8wh7b010655bfdd3c3", "2355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "2355a46b19d348dc2f57c046f8eg63d4538ebb936000f3c9ee954a2746l0dd865", Arrays.asList(orderEntity), "11io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460ndd865", OrderState.REJECTED, "11io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460ndd865",24.00),
                new Order("53c234e5e8472b6ac51dfdadsfcab3fe06fad053beb8ebfd8977b010655bfdd33", "2355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "2355a46b19d348dc2f57c046f8eg63d4538ebb936000f3c9ee954a2746l0dd865", Arrays.asList(orderEntity), "11io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460ndd865", OrderState.DELIVERED, "11io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460ndd865",24.00),
                new Order("53c234e5e8472b6ac51dfdae1cab3fe06fad0512seb8ebfd8977b010655bfddc3", "2355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "2355a46b19d348dc2f57c046f8eg63d4538ebb936000f3c9ee954a2746l0dd865", Arrays.asList(orderEntity), "11io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460ndd865", OrderState.DELIVERED, "11io46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460ndd865",24.00)
        );

    }
    @Test
    public void getMostCanceledUsers() {
        List<User> result = SamsherFunctions.mostCanceledUsers.apply(allOrders, userList, 1);
        assertEquals(2, result.size());
    }
    @Test
    public void getTopDrivers() {

        List<User> result = SamsherFunctions.topDrivers.apply(allOrders, userList);
        assertEquals(2, result.size());
    }
    @Test void distanceTest(){
        Double distance = SamsherFunctions.distanceFormula.apply(41.023227,-91.966059,41.0178239,-91.9678598);
        assertEquals(0.6195008600589809,distance);

        Double distance2 = SamsherFunctions.distanceFormula.apply(41.0178239,-91.9678598,41.0178239,-91.9678598);
        assertEquals(0.000,distance2);
    }
    @Test void rearestRestaurentsTest(){
        List<User> restaurents = SamsherFunctions.rearestRestaurents.apply(userList,41.0178239,-91.9678598,20d);//with argiro center as center point
        //List<User> restaurents = SamsherFunctions.rearestRestaurents.apply(userList,41.0038032,-92.3977244,20d);// with Ottumwa as center point
        assertEquals(4,restaurents.size());
    }

}
