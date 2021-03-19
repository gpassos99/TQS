import jdk.jfr.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class ITqsStackTest {

    private ITqsStack<Integer> testStack;
    private Logger log = Logger.getLogger("Stack");

    @BeforeEach
    void setUp() {
        testStack = new ITqsStack<>();
    }

    @DisplayName("Testing if it's empty")
    @org.junit.jupiter.api.Test
     void isEmptyOnConstruction() {
        log.info("Testing if it's empty");
        assertTrue(testStack.IsEmpty());
        log.info("OK!");

    }

    @DisplayName("Testing if size is 0")
    @org.junit.jupiter.api.Test
    void sizeOnConstruction() {
        log.info("Testing if size is 0");
        assertEquals(0, testStack.size());
        log.info("OK!");

    }

    @DisplayName("Testing if size has the correct amount after a push")
    @org.junit.jupiter.api.Test
    void sizeAfterPush() {
        log.info("Testing if size has the correct amount after a push");

        int i;
        for (i = 0; i < 5; i++) testStack.push(i);

        assertFalse(testStack.IsEmpty());
        assertEquals(5, testStack.size());
        log.info("OK!");

    }

    @DisplayName("Testing if the pushed value is the one who is popped")
    @org.junit.jupiter.api.Test
    void PushPop() {
        log.info("Testing if the pushed value is the one who is popped");
        testStack.push(123);
        assertEquals(123, testStack.pop());
        log.info("OK!");
    }

    @DisplayName("Testing if the pushed value is the one who is peeked but the size stays the same")
    @org.junit.jupiter.api.Test
    void PushPeek() {
        log.info("Testing if the pushed value is the one who is peeked but the size stays the same");
        testStack.push(123);
        int s = testStack.size();

        assertEquals(123, testStack.peek());
        assertEquals(s, testStack.size());
        log.info("OK!");
    }

    @DisplayName("Testing exception when we pop an empty stack")
    @org.junit.jupiter.api.Test
    void popEmptyStack() {
        log.info("Testing exception when we pop an empty stack");
        assertThrows(NoSuchElementException.class, () -> {
            testStack.pop();
        });
        log.info("OK!");
    }

    @DisplayName("Testing exception when we peek an empty stack")
    @org.junit.jupiter.api.Test
    void peekEmptyStack() {
        log.info("Testing exception when we peek an empty stack");
        assertThrows(NoSuchElementException.class, () -> {
            testStack.peek();
        });
        log.info("OK!");
    }

    @DisplayName("Testing exception when we push into a full stack")
    @org.junit.jupiter.api.Test
    void pushFullStack() {
        log.info("Testing exception when we pop an empty stack");
        testStack = new ITqsStack<>(3);

        int i;
        for (i = 0; i < 3; i++) testStack.push(i);

        assertThrows(IllegalStateException.class, () -> {
            testStack.push(4);
        });
        log.info("OK!");
    }

}