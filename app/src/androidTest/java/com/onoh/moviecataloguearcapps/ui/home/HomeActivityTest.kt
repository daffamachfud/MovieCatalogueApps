package com.onoh.moviecataloguearcapps.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.onoh.moviecataloguearcapps.R
import com.onoh.moviecataloguearcapps.utils.DataDummy
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import com.onoh.moviecataloguearcapps.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovie = DataDummy.generateDummyMoviesResponse()
    private val dummyTvShow = DataDummy.generateDummyTvShowsResponse()

    @get:Rule
    val activityRule = ActivityTestRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun loadMovies(){
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

   @Test
   fun loadMoviesDetail(){
       onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
       onView(withId(R.id.nested_scrollview_detail_mv)).perform(swipeUp())
       onView(withId(R.id.tv_detail_movie_title)).check(matches(isDisplayed()))
       onView(withId(R.id.tv_detail_movie_title)).check(matches(withText(dummyMovie[0].title)))
       onView(withId(R.id.tv_detail_movie_overview)).check(matches(isDisplayed()))
       onView(withId(R.id.tv_detail_movie_overview)).check(matches(withText(dummyMovie[0].overview)))
   }

    @Test
    fun loadTvShow(){
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadTvShowDetail(){
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.nested_scrollview_detail_tv)).perform(swipeUp())
        onView(withId(R.id.tv_detail_tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_tv_title)).check(matches(withText(dummyTvShow[0].originalName)))
        onView(withId(R.id.tv_detail_tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_tv_overview)).check(matches(withText(dummyTvShow[0].overview)))
    }
}