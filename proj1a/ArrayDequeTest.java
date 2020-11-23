import java.util.ArrayDeque;
import java.util.Deque;

/** Performs some basic linked list tests. */
public class ArrayDequeTest {

    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }
    public static class operations {
        /*
        1: Add front.
        2: Add back.
        3: Remove front.
        4: Remove end.
        */
        int opType = 0;

        int val = 0;
        public operations(int op, int value) {
            opType = op;
            val = value;
        }

    }
    public static boolean testHelper(operations[] ops) {
        Deque deque_correct = new ArrayDeque();
        ArrayDeque<Integer> deque_to_test = new ArrayDeque<Integer>();
        for (int ii = 0; ii < ops.length; ++ii) {
            operations op = ops[ii];
            switch (op.opType) {
                case 1:
                    deque_correct.addFirst(op.val);
                    deque_to_test.addFirst(op.val);
                    break;
                case 2:
                    deque_correct.addLast(op.val);
                    deque_to_test.addLast(op.val);
                    break;
                case 3:
                    deque_correct.removeFirst();
                    deque_to_test.removeFirst();
                    break;
                case 4:
                    deque_correct.removeLast();
                    deque_to_test.removeLast();
                    break;
                default:
                    System.out.println("Invalid op type");
                    return false;
            }
            String errorMsg = "";
            if (deque_correct.size() != deque_to_test.size()) {
                errorMsg = "Size is not correct. Fail on op" + ii;
                System.out.println(errorMsg);
                return false;
            }
        }
        String expect="", res="";
        for (int jj = deque_correct.size(); jj > 0; --jj) {
            expect += deque_correct.getFirst() + "-";
            res += deque_to_test.getFirst() + "-";
            deque_correct.removeFirst();
            deque_to_test.removeFirst();
        }
        //System.out.println("Doesnot match. \nExpect " + expect + " \nresult " +res);
        if (!expect.equals(res)) {
            System.out.println("Doesnot match. \nExpect " + expect + " \nresult " +res);
            return false;
        }
        return true;
    }

    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");

        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, lld1.size()) && passed;
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.addLast("middle");
        passed = checkSize(2, lld1.size()) && passed;

        lld1.addLast("back");
        passed = checkSize(3, lld1.size()) && passed;

        //lld1.printDeque();

        printTestStatus(passed);

    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");


        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
		/*// should be empty
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty 
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeFirst();
		// should be empty 
		passed = checkEmpty(true, lld1.isEmpty()) && passed;*/

       /* lld1.addLast(6);
        lld1.addLast(7);
        lld1.addLast(8);
        lld1.addLast(9);
        lld1.addFirst(1);
        lld1.addFirst(2);
        lld1.addFirst(3);
        lld1.addFirst(4);
        lld1.addFirst(5);
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeLast();
        lld1.removeLast();
        lld1.removeLast();*/
        operations[] test1 = {
                new operations(2, 6),
                new operations(2, 7),
                new operations(2, 8),
                new operations(2, 9),
                new operations(1, 1),
                new operations(1, 2),
                new operations(1, 3),
                new operations(1, 4),
                new operations(1, 5),
                new operations(3, 0),
                new operations(4, 0),
                new operations(4, 0),
                new operations(4, 0),
                new operations(4, 0)
        };
        if (!testHelper(test1)) {
            System.out.println("test1 fails");
        }
        operations[] test2 = {
                new operations(2, 6),
                new operations(2, 7),
                new operations(2, 8),
                new operations(2, 9),
                new operations(1, 1),
                new operations(1, 2),
                new operations(1, 3),
                new operations(1, 4),
                new operations(1, 5),
                new operations(1, 6),
                new operations(1, 7),
                new operations(3, 0),
                new operations(4, 0),
                new operations(3, 0),
                new operations(4, 0),
                new operations(4, 0),
                new operations(4, 0),
                new operations(4, 0),
                new operations(4, 0)
        };
        if (!testHelper(test2)) {
            System.out.println("test2 fails");
        }
        //System.out.println(lld1.get(1));
        //boolean passed = (lld1.get(2) == 3);
        //passed = (lld1.get(4) == 5) && passed;
        //passed = (lld1.removeFirst() == 9) && passed;
        //passed = (lld1.removeLast() == 8) && passed;
        //printTestStatus(passed);
    }

    public static void getTest() {

        System.out.println("Running get test.");
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        lld1.addLast(10);
        lld1.addLast(20);
        lld1.addLast(30);
        /*boolean passed = (lld1.get(0) == 10);
        printTestStatus(passed);*/

    }




    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
        getTest();
    }
} 