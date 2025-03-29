package edu.grinnell.csc207.soundsofsorting;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.soundsofsorting.sorts.Sorts;

public class SortsTests {

    /**
     * @param <T> the carrier type of the array
     * @param arr the array to check
     * @return true iff <code>arr</code> is sorted.
     */
    public static <T extends Comparable<? super T>> boolean sorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] makeTestArray() {
        return new Integer[]{
            3, 7, 9, 1, 2,
            18, 16, 15, 19, 8,
            14, 12, 5, 13, 4,
            6, 0, 17, 11, 10
        };
    }

    public static Integer[] myTestArray1() {
        return new Integer[]{
            3, 7, -9, 1, 2,
            18, -16, 15, 19, 8,
            14, 12, 5, -13, 4,
            6, 0, -17, 11, 10
        };
    }

    public static Integer[] myTestArray2() {
        return new Integer[]{
            10, 9, 8, 7, 6
        };
    }

    public static Integer[] myTestArray3() {
        return new Integer[]{
            3, 3, 3, 3, 3, 3, 3
        };
    }

    public static Integer[] myTestArray4() {
        return new Integer[]{
            1, 2, 3, 4, 5, 6
        };
    }

    public void testSort(Consumer<Integer[]> func) {
        Integer[] arr = makeTestArray();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    public void testSort1(Consumer<Integer[]> func) {
        Integer[] arr = myTestArray1();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    public void testSort2(Consumer<Integer[]> func) {
        Integer[] arr = myTestArray2();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    public void testSort3(Consumer<Integer[]> func) {
        Integer[] arr = myTestArray3();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    public void testSort4(Consumer<Integer[]> func) {
        Integer[] arr = myTestArray4();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    @Test
    public void testBubbleSort() {
        testSort(Sorts::bubbleSort);
        testSort1(Sorts::bubbleSort);
        testSort2(Sorts::bubbleSort);
        testSort3(Sorts::bubbleSort);
        testSort4(Sorts::bubbleSort);
    }

    @Test
    public void testInsertionSort() {
        testSort(Sorts::insertionSort);
        testSort1(Sorts::insertionSort);
        testSort2(Sorts::insertionSort);
        testSort3(Sorts::insertionSort);
        testSort4(Sorts::insertionSort);
    }

    @Test
    public void testSelectionSort() {
        testSort(Sorts::selectionSort);
        testSort1(Sorts::selectionSort);
        testSort2(Sorts::selectionSort);
        testSort3(Sorts::selectionSort);
        testSort4(Sorts::selectionSort);
    }

    @Test
    public void testMergeSort() {
        testSort(Sorts::mergeSort);
        testSort1(Sorts::mergeSort);
        testSort2(Sorts::mergeSort);
        testSort3(Sorts::mergeSort);
        testSort4(Sorts::mergeSort);
    }

    @Test
    public void testQuickSort() {
        testSort(Sorts::quickSort);
        testSort1(Sorts::quickSort);
        testSort2(Sorts::quickSort);
        testSort3(Sorts::quickSort);
        testSort4(Sorts::quickSort);
    }
}
