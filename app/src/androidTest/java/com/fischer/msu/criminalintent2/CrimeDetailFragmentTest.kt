package com.fischer.msu.criminalintent2

import android.view.View
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.util.regex.Matcher

class CrimeDetailFragmentTest {

    //testing to see if i need an isVisible property:


    private lateinit var scenario: FragmentScenario<CrimeDetailFragment>

    @Before
    fun setUp() {
        scenario = launchFragmentInContainer()
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun checkBoxStateEqualsCrimeSolvedState() {
        scenario.onFragment { fragment ->
            // Check that the checkbox is visible
            onView(withId(R.id.crime_solved)).check(matches(isDisplayed()))

            // Check that the checkbox is unchecked by default
            onView(withId(R.id.crime_solved)).check(matches(isNotChecked()))

            // Simulate clicking the checkbox to mark the crime as solved
            onView(withId(R.id.crime_solved)).perform(click())

            // Check that the checkbox is now checked
            onView(withId(R.id.crime_solved)).check(matches(isChecked()))

            // Check that the crime is now marked as solved
            assert(fragment.crime.isSolved)
        }
    }
}
