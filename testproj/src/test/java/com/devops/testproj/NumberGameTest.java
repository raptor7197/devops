package com.devops.testproj; // Make sure this matches your project's package

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NumberGameTest {

    
    @Test
    public void testGuessIsTooLow() {
        // Arrange: Define our inputs and what we expect the output to be.
        int secretNumber = 50;
        int guess = 30;
        String expectedResult = "Too low! Try again.";
        
        // Act: Call the method from our main code to get the actual result.
        String actualResult = NumberGame.checkGuess(guess, secretNumber);
        
        // Assert: Use assertEquals to check if the actual result matches what we expected.
        // If they are not equal, this test will fail.
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Test case for when the user's guess is higher than the secret number.
     */
    @Test
    public void testGuessIsTooHigh() {
        String expected = "Too high! Try again.";
        String actual = NumberGame.checkGuess(70, 50);
        
        // Assert that the method correctly identifies a high guess.
        assertEquals(expected, actual);
    }

    /**
     * Test case for when the user's guess is correct.
     */
    @Test
    public void testGuessIsCorrect() {
        String expected = "Correct!";
        String actual = NumberGame.checkGuess(50, 50);
        
        // Assert that the method correctly identifies a correct guess.
        assertEquals(expected, actual);
    }
}
