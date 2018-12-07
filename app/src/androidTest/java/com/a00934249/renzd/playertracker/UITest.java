package com.a00934249.renzd.playertracker;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.*;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


public class UITest {
    String[] playername;

    @Before
    public void Setup() {
        playername = new String[] {"Steph", "Curry", " "};
    }

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        return new TypeSafeMatcher<View>() {
            int currentIndex = 0;

            @Override
            public void describeTo(Description description) {
                description.appendText("with index: ");
                description.appendValue(index);
                matcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                return matcher.matches(view) && currentIndex++ == index;
            }
        };
    }

    @Test
    public void checkMenuButtons() {
        onView(withId(R.id.action_search)).perform(click());
        onView(withId(R.id.action_search)).perform(click());
        onView(withId(R.id.action_back)).perform(click());
        onView(withId(R.id.action_back)).perform(click());
    }

    @Test
    public void clickPlayer() {
        onView(withIndex(withId(R.id.player_name), 0)).perform(click());
        onView(withId(R.id.action_back)).perform(click());
        onView(withId(R.id.action_search)).perform(click());
        onView(withIndex(withId(R.id.player_name3), 1)).perform(click());
        onView(withIndex(withId(R.id.player_name3), 2)).perform(click());
        onView(withIndex(withId(R.id.player_name3), 3)).perform(click());
        onView(withIndex(withId(R.id.player_name3), 4)).perform(click());
    }

    @Test
    public void searchPlayer1(){
        onView(withId(R.id.action_search)).perform(click());
        onView(withId(R.id.action_search)).perform(click());
        onView(withId(R.id.Name)).perform(typeText(playername[0]),closeSoftKeyboard());
        onView(withId(R.id.SearchButton)).perform(click());
    }

    @Test
    public void searchPlayer2(){
        onView(withId(R.id.action_search)).perform(click());
        onView(withId(R.id.action_search)).perform(click());
        onView(withId(R.id.Name)).perform(typeText(playername[1]),closeSoftKeyboard());
        onView(withId(R.id.SearchButton)).perform(click());
        onView(withIndex(withId(R.id.player_name3), 1)).perform(click());
    }

    @Test
    public void searchPlayer3(){
        onView(withId(R.id.action_search)).perform(click());
        onView(withId(R.id.action_search)).perform(click());
        onView(withId(R.id.Name)).perform(typeText(playername[2]),closeSoftKeyboard());
        onView(withId(R.id.SearchButton)).perform(click());
        onView(withIndex(withId(R.id.player_name3), 1)).perform(click());
    }
}
