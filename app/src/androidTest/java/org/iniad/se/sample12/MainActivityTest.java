package org.iniad.se.sample12;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testOnClick1() {
        onView(withId(R.id.etX))
                .perform(clearText());
        onView(withId(R.id.etY))
                .perform(clearText());
        onView(withId(R.id.etX))
                .perform(typeText("1.0"), closeSoftKeyboard());
        onView(withId(R.id.etY))
                .perform(typeText("2.0"), closeSoftKeyboard());
        onView(withId(R.id.btnPlus)).perform(click());

        onView(withId(R.id.tvResult))
                .check(matches(withText("1.0 + 2.0 = 3.0")));
    }

    @Test
    public void testOnClick2() {
        onView(withId(R.id.etX))
                .perform(clearText());
        onView(withId(R.id.etY))
                .perform(clearText());
        onView(withId(R.id.etX))
                .perform(typeText("a"), closeSoftKeyboard());
        onView(withId(R.id.etY))
                .perform(typeText("2.0"), closeSoftKeyboard());
        onView(withId(R.id.btnPlus)).perform(click());

        onView(withId(R.id.tvResult))
                .check(matches(withText("Invalid format.")));
    }


    @Test
    public void testOnClick3() {
        onView(withId(R.id.etX))
                .perform(clearText());
        onView(withId(R.id.etY))
                .perform(clearText());
        onView(withId(R.id.etX))
                .perform(typeText("2.0"), closeSoftKeyboard());
        onView(withId(R.id.etY))
                .perform(typeText("a"), closeSoftKeyboard());
        onView(withId(R.id.btnPlus)).perform(click());

        onView(withId(R.id.tvResult))
                .check(matches(withText("Invalid format.")));
    }
}