package test;

import com.company.algos.Numbers;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AssertionTest {
    @Test
    public void simpleTests() {
        assertTrue(Numbers.hasUniqueChars(""));
        assertTrue(Numbers.hasUniqueChars("abc"));
        assertFalse(Numbers.hasUniqueChars("a b c"));
        assertFalse(Numbers.hasUniqueChars("abbc"));
    }
}
