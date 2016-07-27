import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.moskvax.playground.BinarySearch.binarySearch;

public class BinarySearchTest {

  private final List<Integer> wikipediaTestList = Arrays.asList(1, 3, 4, 6, 7, 8, 10, 13, 14);
  private final List<Integer> oneElementList = Collections.singletonList(5);
  private final List<Integer> emptyList = Collections.emptyList();

  @Test public void wikipediaExample() {
    assertEquals(2, binarySearch(wikipediaTestList, 4));
  }

  @Test public void wikipediaExampleMin() {
    assertEquals(0, binarySearch(wikipediaTestList, 1));
  }

  @Test public void wikipediaExampleSecondSmallest() {
    assertEquals(1, binarySearch(wikipediaTestList, 3));
  }

  @Test public void wikipediaExampleMax() {
    assertEquals(8, binarySearch(wikipediaTestList, 14));
  }

  @Test public void wikipediaExampleSecondBiggest() {
    assertEquals(7, binarySearch(wikipediaTestList, 13));
  }

  @Test public void wikipediaExampleTooBig() {
    assertEquals(-1, binarySearch(wikipediaTestList, 15));
  }

  @Test public void wikipediaExampleTooSmall() {
    assertEquals(-1, binarySearch(wikipediaTestList, 0));
  }

  @Test public void wikipediaExampleMissingSmall() {
    assertEquals(-1, binarySearch(wikipediaTestList, 2));
  }

  @Test public void wikipediaExampleMissingBig() {
    assertEquals(-1, binarySearch(wikipediaTestList, 12));
  }

  @Test public void wikipediaExampleMissingMedium() {
    assertEquals(-1, binarySearch(wikipediaTestList, 9));
  }

  @Test public void emptyList() {
    assertEquals(-1, binarySearch(emptyList, 0));
  }

  @Test public void oneElementTooSmall() {
    assertEquals(-1, binarySearch(oneElementList, 4));
  }

  @Test public void oneElementTooBig() {
    assertEquals(-1, binarySearch(oneElementList, 6));
  }

  @Test public void oneElementJustRight() {
    assertEquals(0, binarySearch(oneElementList, 5));
  }

}
