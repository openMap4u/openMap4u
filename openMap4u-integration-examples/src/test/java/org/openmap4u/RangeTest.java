/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zwotti
 */
public class RangeTest {

    public RangeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testRangeSupplierLocalDate() {
        RangeSupplier.range(23).forEach(value -> System.out.println(value));

        RangeSupplier.range(LocalDate.of(2014, Month.JANUARY, 28)).forEach(value -> System.out.println(value));
        RangeSupplier.range(LocalDateTime.of(2014, Month.JANUARY, 28, 22, 36)).forEach(value -> System.out.println(value));

    }

}
