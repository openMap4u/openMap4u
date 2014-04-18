/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author Michel Hadrbolec
 */
public class RangeSupplier {

    /**
     * Creates a range beginning with the default value 0, the given stop value
     * and the default step width of 1. <br/>
     * Example: <code>10</code> would result in a list containing
     * <code>0,1,2,3,4,5,6,7,8,9</code>
     *
     * @param stop The stop value of the range.
     * @return The resulting range.
     */
    public static final Stream<Double> range(double stop) {
        return range(stop, 1);
    }

    /**
     * Creates a range beginning with the default value 0.<br/>
     * Example: <code>100,10</code> would result in a list containing
     * <code>0,10,20,30,40,50,60,70,80,90</code>
     *
     * @param stop The stop value of the range.
     * @param step The step width of the range.
     * @return The resulting range.
     */
    public static Stream<Double> range(double stop, double step) {
        return range(0, stop, step);
    }

    /**
     * Creates a range.
     *
     * @param start The start value of the range.
     * @param stop The stop value of the range which is not included.
     * @param step The step width. Example: <code>10,100,10</code> would result
     * in a list containing <code>10,20,30,40,50,60,70,80,90</code>
     * @return The resulting range.
     */
    public static Stream<Double> range(double start, double stop,
            double step) {
        List<Double> list = new ArrayList<Double>();
        if (step > 0) {
            for (double x = start; x < stop; x += step) {
                list.add(x);
            }
        } else {
            for (double x = start; x > stop; x += step) {
                list.add(x);
            }
        }
        return list.stream();
    }

    public static Stream<Double> random(double lowerBound, double upperBound, long count) {
        return Stream.generate(() -> random(lowerBound,upperBound)).limit(count);
    }
    
    public static double random(double lowerBound, double upperBound) {
        return Math.random() * (upperBound - lowerBound) + lowerBound;
    }
    
    

    public static Stream<LocalDate> range(LocalDate start, LocalDate stop, Period stepWidth) {
        List<LocalDate> list = new ArrayList<LocalDate>();
        System.out.println(start + " " + stop + " " + stepWidth);
        if (!stepWidth.isNegative()) {
            for (LocalDate x = start; x.isBefore(stop); x = x.plus(stepWidth)) {
                list.add(x);
            }
        } else {
            for (LocalDate x = start; x.isAfter(stop); x = x.minus(stepWidth)) {
                list.add(x);
            }
        }
        return list.stream();
    }

    public static Stream<LocalDate> range(LocalDate start, Period stepWidth) {
        return range(start, LocalDate.now(), stepWidth);
    }

    public static Stream<LocalDate> range(LocalDate start) {
        return range(start, LocalDate.now(), Period.ofDays(1));
    }

    public static Stream<LocalDateTime> range(LocalDateTime start, LocalDateTime stop, Duration stepWidth) {
        List<LocalDateTime> list = new ArrayList<LocalDateTime>();
        if (!stepWidth.isNegative()) {
            for (LocalDateTime x = start; x.isBefore(stop); x = x.plus(stepWidth)) {
                list.add(x);
            }
        } else {
            for (LocalDateTime x = start; x.isAfter(stop); x = x.minus(stepWidth)) {
                list.add(x);
            }
        }
        return list.stream();
    }

    public static Stream<LocalDateTime> range(LocalDateTime start, Duration stepWidth) {
        return range(start, LocalDateTime.now(), stepWidth);
    }

    public static Stream<LocalDateTime> range(LocalDateTime start) {
        return range(start, LocalDateTime.now(), Duration.ofDays(1));
    }

}
