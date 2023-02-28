package org.jfree.data;

import static org.junit.Assert.*;
import org.junit.*;

public class RangeTest {
    private Range exampleRange1;
    private Range exampleRange2;
    private Range exampleRange3;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /* Before, creates the object with some example values. */
    @Before
    public void setUp() throws Exception {
        exampleRange1 = new Range(-100, 100);
        exampleRange2 = new Range(-450, 25);
    }

    /* Test, tests methods for the object, with one assert statement per stub. */
    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -100 and 100 should be 0", 0, exampleRange1.getCentralValue(), .000000001d);
    }

    /*----------------------------------------------------------------------------------------------------------------------*/
    /* contains() method testing. */
    @Test
    public void testContainLower() {
        assertEquals("Lower bound of -100 should be in range", true, exampleRange1.contains(-100));
    }

    @Test
    public void testContainUpper() {
        assertEquals("Upper bound 100 should be in range", true, exampleRange1.contains(100));
    }

    @Test
    public void testContainBLB() {
        int BLB = -500;
        assertEquals("Value of " + BLB + " should not be in the range", false, exampleRange1.contains(BLB));
    }

    @Test
    public void testContainBUB() {
        int AUB = 1000;
        assertEquals("Value of " + AUB + " should not be in the range", false, exampleRange1.contains(AUB));
    }

    @Test
    public void testContainNom() {
        assertEquals("Value of 56 should be present in the range", true, exampleRange1.contains(56));
    }

    /*----------------------- TESTS FOR COMBINE(Range r1, Range r2) ---------------------------------*/
    @Test
    public void testCombineValidMin() {
        exampleRange3 = Range.combine(exampleRange1, exampleRange2);
        assertEquals("Min value is incorrect ", -450, exampleRange3.getLowerBound(), .000000001d);
    }

    @Test /* FAILED */
    public void testCombineValidMax() {
        exampleRange3 = Range.combine(exampleRange1, exampleRange2);
        assertEquals("Max value is incorrect ", 100, exampleRange3.getUpperBound(), .000000001d);
    }

    @Test /* FAILED */
    public void testCombineNom() {
        exampleRange3 = Range.combine(exampleRange1, exampleRange2);
        assertEquals("Value should exist in range ", true, exampleRange3.contains(25));
    }

    @Test
    public void testCombineOutofBounds() {
        exampleRange3 = Range.combine(exampleRange1, exampleRange2);
        assertEquals("Value should not exist in range ", false, exampleRange3.contains(-500));
    }

    @Test // Should return the existing range, when one is null
    public void testCombineOneNull() {
        exampleRange1 = null;
        exampleRange3 = Range.combine(exampleRange1, exampleRange2);
        assertEquals("New Range returned wrong value ", exampleRange2, exampleRange3);
    }

    @Test
    public void testCombineBothNull() {
        exampleRange1 = null;
        exampleRange2 = null;
        exampleRange3 = Range.combine(exampleRange1, exampleRange2);
        assertEquals("New Range returned a value when it should not have ", null, exampleRange3);
    }

    /*----------------------- TESTS FOR expandToInclude(Range r1, double value) ---------------------------------*/
    @Test
    public void testExpandNom() {
        exampleRange3 = Range.expandToInclude(exampleRange2, 45);
        assertEquals("Value was not found ", true, exampleRange3.contains(-100));
    }

    @Test
    public void testExpandUpper() /* FAILED */
    {
        exampleRange3 = Range.expandToInclude(exampleRange2, 55);
        assertEquals("Value was not the correct upper bound ", 55, exampleRange3.getUpperBound(), .000000001d);
    }

    @Test
    public void testExpandLower() /* FAILED: Defective method */
    {
        exampleRange3 = Range.expandToInclude(exampleRange2, -500);
        assertEquals("Value was not the correct upper bound ", -500, exampleRange3.getLowerBound(), .000000001d);
    }

    @Test
    public void testExpandInvalid() {
        exampleRange3 = Range.expandToInclude(exampleRange1, 0);
        assertEquals("Value was found ", false, exampleRange3.contains(45));
    }

    @Test
    public void testExpandValid() {
        exampleRange3 = Range.expandToInclude(exampleRange1, 45);
        assertEquals("Value was not found ", true, exampleRange3.contains(42));
    }

    /*------------------------------ TESTS FOR INSERSECTS(double lower, double upper) ---------------------*/
    @Test
    public void testIntersectOverlap() {
        /* Using exampleRange2 = [-450, 25] */
        assertEquals("Range should've intersected ", true, exampleRange2.intersects(-345, 24));
    }

    @Test
    public void testIntersectPartialOverlap() // FAILED METHOD
    {
        assertEquals("Range should have intersected ", true, exampleRange2.intersects(-345, 28));
    }

    @Test
    public void testIntersectNoOverlapAbove() {
        assertEquals("Value should not have intersected ", false, exampleRange2.intersects(100, 500));
    }

    @Test
    public void testIntersectNoOverlapBelow() // FAILED METHOD
    {
        assertEquals("Value should not have intersected ", false, exampleRange2.intersects(-1000, -700));
    }

    /*--------------------------------- TESTS FOR SHIFT(Range r1, double delta) ---------------------------------*/
    @Test
    public void testShiftUpperPos() // DEFECTIVE
    {
        /* Using exampleRange1: [-100, 100] */
        exampleRange3 = Range.shift(exampleRange1, 100);
        assertEquals("Upper bound is not correct ", 200, exampleRange3.getUpperBound(), .000000001d);
    }

    @Test
    public void testShiftLowerPos() {
        exampleRange3 = Range.shift(exampleRange1, 100);
        assertEquals("Lower bound is not correct ", 0, exampleRange3.getLowerBound(), .000000001d);
    }

    @Test
    public void testShiftNom() // DEFECTIVE
    {
        exampleRange3 = Range.shift(exampleRange1, 230);
        assertEquals("Value should exist in range ", true, exampleRange3.contains(189));
    }

    @Test
    public void testShiftUpperNeg() // DEFECTIVE
    {
        /* Using exampleRange1: [-100, 100] */
        exampleRange3 = Range.shift(exampleRange1, -100);
        assertEquals("Upper bound is not correct ", 0, exampleRange3.getUpperBound(), .000000001d);
    }

    @Test
    public void testShiftLowerNeg() {
        exampleRange3 = Range.shift(exampleRange1, -100);
        assertEquals("Lower bound is not correct ", -200, exampleRange3.getLowerBound(), .000000001d);
    }

    /*-----------------------------------------------------------------------------------------------------------------------*/
    /* After, destroys the object, Java has automatic garbage collection. */
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
