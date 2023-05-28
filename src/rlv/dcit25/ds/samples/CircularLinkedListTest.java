package rlv.dcit25.ds.samples;

import rlv.dcit25.ds.CircularLinkedList;
import rlv.dcit25.ds.List;

/**
 *
 * @author Russel L. Villacarlos
 */
public class CircularLinkedListTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CircularLinkedList<Integer> l = new CircularLinkedList<>();
        testAdd(l);
        testGet(l);
        testSet(l);
        testIndexOf(l);
        testRemove(l);
    }

    static void testAdd(CircularLinkedList<Integer> l) {
        System.out.println("\nTest Add");
        System.out.println("List before test: " + l);
        for (int i = 0; i <= 2; i++) {
            l.add(i);
            System.out.println("Add " + i + ": " + l);
            
            //Verify that the newly added element is bookmarked
            assertBookmarkIndex(i, l.indexOfBookmark());
            assertBookmarkValue(i, l.getBookmark());
        }

        for (int i = -1; i >= -2; i--) {
            l.add(0, i);
            System.out.println("Add " + i + " at index 0: " + l);
 
            //Verify that the newly added element is bookmarked
            assertBookmarkIndex(0, l.indexOfBookmark());
            assertBookmarkValue(i, l.getBookmark());
        }
    }

    static void testGet(CircularLinkedList<Integer> l) {
        System.out.println("\nTest Get");
        System.out.println("List before test: " + l);

        for (int i = 0; i < l.size(); i++) {
            int e = l.get(i);
            System.out.println("Element at index " + i + ": " + e);

            //Verify that the accessd element is bookmarked
            assertBookmarkIndex(i, l.indexOfBookmark());
            assertBookmarkValue(e, l.getBookmark());
        }
    }

    static void testIndexOf(CircularLinkedList<Integer> l) {
        System.out.println("\nTest IndexOf");
        System.out.println("List before test: " + l);

        for (int i = 0; i <= 2; i++) {
            System.out.println("Index of " + i + ": " + l.indexOf(i));

            //Verify that the element found is bookmarked
            assertBookmarkIndex(i, l.indexOfBookmark());
            assertBookmarkValue(i, l.getBookmark());
        }

        for (int i = -2; i <= -1; i++) {
            System.out.println("Index of " + i + ": " + l.indexOf(i));

            //Verify that failed search does not change the bookmark
            assertBookmarkIndex(2, l.indexOfBookmark());
            assertBookmarkValue(2, l.getBookmark());
        }
    }

    static void testSet(CircularLinkedList<Integer> l) {
        System.out.println("\nTest Set");

        System.out.println("List before test: " + l);

        for (int i = 0; i < l.size(); i++) {
            l.set(i, i);
            System.out.println("Set index " + i + " to " + i + ": " + l);

            //Verify that the updated element is bookmarked
            assertBookmarkIndex(i, l.indexOfBookmark());
            assertBookmarkValue(i, l.getBookmark());
        }
    }

    static void testRemove(CircularLinkedList<Integer> l) {
        System.out.println("\nTest Remove");
        System.out.println("List before test: " + l);

        for (int i = 4; i > 0; i--) {
            l.remove(i);
            System.out.println("Remove element at index " + i + ": " + l);

            //Verify that the element preceeding the removed element is bookmarked
            assertBookmarkIndex(i - 1, l.indexOfBookmark());
            assertBookmarkValue(i - 1, l.getBookmark());
        }

        l.remove(0);
        System.out.println("Remove element at index 0: " + l);
        
        //Verify that no element is bookmarked after emptying the list
        assertBookmarkIndex(-1, l.indexOfBookmark());
        assertBookmarkValue(null, l.getBookmark());

    }

    static void assertBookmarkIndex(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("Bookmark index must be " + expected
                    + " but " + actual + " is given.");
        }
    }

    static void assertBookmarkValue(Integer expected, Integer actual) {
        if (expected == null && actual != null) {
            throw new AssertionError("Bookmark value must be null but "
                    + actual + " is given.");
        } else if (expected != null && actual == null) {
            throw new AssertionError("Bookmark value must be " + expected
                    + " but null is given.");
        } else if (expected != actual) {
            throw new AssertionError("Bookmark value must be " + expected
                    + " but " + actual + " is given.");
        }
    }
}
