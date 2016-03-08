package com.stepavlas.quadratic;

import org.junit.Assert;
import org.junit.Test;

public class QuadraticTest {
    private Quadratic quadratic = new Quadratic();

    @Test
    public void checkSolution(){
        double[] results1 = quadratic.findX(2, 5, -3);
        double[] expected1 = {0.5, -3.0};
        Assert.assertArrayEquals(expected1, results1, 0);
        double[] results2 = quadratic.findX(4, 21, 5);
        double[] expected2 = {-0.25, -5.0};
        Assert.assertArrayEquals(expected2, results2, 0);
    }
}