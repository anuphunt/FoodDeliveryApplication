package com.fooddeliveryapp.storefront.functionalProgramming;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class AnupFunctionsTest {

    @Test
    public void sum(){
        assertEquals(4, AnupFunctions.sum.apply(2, 2));
    }
    }