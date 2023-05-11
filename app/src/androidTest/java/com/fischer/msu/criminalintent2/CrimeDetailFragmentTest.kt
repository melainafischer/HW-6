package com.fischer.msu.criminalintent2

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CrimeDetailFragmentTest {

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
    fun editText() {
        val scenario: FragmentScenario<CrimeDetailFragment> =
            launchFragmentInContainer()
        onView(withId(R.id.crime_title)).perform(typeText("New Crime Title"))
        scenario.onFragment { fragment ->
            assertEquals(fragment.crime.title, "New Crime Title")
        }
    }

    @Test
    fun checkBox() {
        val scenario: FragmentScenario<CrimeDetailFragment> =
            launchFragmentInContainer()
        onView(withId(R.id.crime_solved)).perform(click())
        scenario.onFragment { fragment ->
            assertTrue(fragment.crime.isSolved)
        }
    }
}