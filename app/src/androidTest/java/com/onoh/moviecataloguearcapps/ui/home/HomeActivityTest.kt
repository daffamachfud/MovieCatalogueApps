package com.onoh.moviecataloguearcapps.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.onoh.moviecataloguearcapps.R
import com.onoh.moviecataloguearcapps.utils.DataDummy
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTvShow = DataDummy.generateDummyTvShows()

    @get:Rule
    val activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun loadMovies(){
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

   @Test
   fun loadMoviesDetail(){
       onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
       onView(withId(R.id.tv_title_movie_detail)).check(matches(isDisplayed()))
       onView(withId(R.id.tv_title_movie_detail)).check(matches(withText(dummyMovie[0].title)))
       onView(withId(R.id.tv_date_movie_detail)).check(matches(isDisplayed()))
       onView(withId(R.id.tv_date_movie_detail)).check(matches(withText(dummyMovie[0].dateRelease)))
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
        onView(withId(R.id.tv_title_tv_show_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_tv_show_detail)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.tv_category_tv_show_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_category_tv_show_detail)).check(matches(withText(dummyTvShow[0].category)))
    }
}