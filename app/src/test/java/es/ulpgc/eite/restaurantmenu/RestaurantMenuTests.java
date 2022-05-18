package es.ulpgc.eite.restaurantmenu;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.RobolectricTestRunner;

/**
 * Created by Luis on mayo, 2022
 */
@RunWith(RobolectricTestRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RestaurantMenuTests {

  RestaurantMenuSteps steps = new RestaurantMenuSteps();


  @Test
  public void T01ChooseStarter() {

    // Given
    steps.appStartScreen("Menu Sections");
    steps.appShowTextOnSection("Choose one...", "Starters");
    steps.appShowPriceOnSection("0 euros", "Starters");
    steps.appShowTextOnSection("Choose one...", "Main Courses");
    steps.appShowPriceOnSection("0 euros", "Main Courses");
    steps.appShowTextOnSection("Choose one...", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Total Price");

    // When
    steps.userPressSection("Starters");

    // Then
    steps.appStartScreen("Menu Items");
    steps.appShowPriceOnItem("10 euros", "First Starter");
    steps.appShowPriceOnItem("9 euros", "Second Starter");

    // Reset
    steps.resetTest();
  }


  @Test
  public void T02ChooseMainCourse() {

    // Given
    steps.appStartScreen("Menu Sections");
    steps.appShowTextOnSection("Choose one...", "Starters");
    steps.appShowPriceOnSection("0 euros", "Starters");
    steps.appShowTextOnSection("Choose one...", "Main Courses");
    steps.appShowPriceOnSection("0 euros", "Main Courses");
    steps.appShowTextOnSection("Choose one...", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Total Price");

    // When
    steps.userPressSection("Main Courses");

    // Then
    steps.appStartScreen("Menu Items");
    steps.appShowPriceOnItem("15 euros", "Main Courses");
    steps.appShowPriceOnItem("18 euros", "Main Courses");

    // Reset
    steps.resetTest();
  }


  @Test
  public void T03ChooseDessert() {

    // Given
    steps.appStartScreen("Menu Sections");
    steps.appShowTextOnSection("Choose one...", "Starters");
    steps.appShowPriceOnSection("0 euros", "Starters");
    steps.appShowTextOnSection("Choose one...", "Main Courses");
    steps.appShowPriceOnSection("0 euros", "Main Courses");
    steps.appShowTextOnSection("Choose one...", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Total Price");

    // When
    steps.userPressSection("Desserts");

    // Then
    steps.appStartScreen("Menu Items");
    steps.appShowPriceOnItem("7 euros", "First Starter");
    steps.appShowPriceOnItem("8 euros", "Second Starter");

    // Reset
    steps.resetTest();
  }


  // ------------------------------------------------------------------------

  @Test
  public void T04ChooseFirstStarter() {

    // Given
    steps.appStartScreen("Menu Sections");
    steps.userPressSection("Starters");
    steps.appStartScreen("Menu Items");

    // When
    steps.userPressItem("First Starter");

    // Then
    steps.appResumeScreen("Menu Sections");
    steps.appShowTextOnSection("First Starter", "Starters");
    steps.appShowPriceOnSection("10 euros", "Starters");
    steps.appShowTextOnSection("Choose one...", "Main Courses");
    steps.appShowPriceOnSection("0 euros", "Main Courses");
    steps.appShowTextOnSection("Choose one...", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Desserts");
    steps.appShowPriceOnSection("10 euros", "Total Price");

    // Reset
    steps.resetTest();
  }


  @Test
  public void T05ChooseSecondStarter() {

    // Given
    steps.appStartScreen("Menu Sections");
    steps.userPressSection("Starters");
    steps.appStartScreen("Menu Items");

    // When
    steps.userPressItem("Second Starter");

    // Then
    steps.appResumeScreen("Menu Sections");
    steps.appShowTextOnSection("Second Starter", "Starters");
    steps.appShowPriceOnSection("9 euros", "Starters");
    steps.appShowTextOnSection("Choose one...", "Main Courses");
    steps.appShowPriceOnSection("0 euros", "Main Courses");
    steps.appShowTextOnSection("Choose one...", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Desserts");
    steps.appShowPriceOnSection("9 euros", "Total Price");

    // Reset
    steps.resetTest();
  }




  @Test
  public void T06ChooseFirstMainCourse() {

    // Given
    steps.appStartScreen("Menu Sections");
    steps.userPressSection("Main Courses");
    steps.appStartScreen("Menu Items");

    // When
    steps.userPressItem("First Main Course");

    // Then
    steps.appResumeScreen("Menu Sections");
    steps.appShowTextOnSection("Choose one...", "Starters");
    steps.appShowPriceOnSection("0 euros", "Starters");
    steps.appShowTextOnSection("First Main Course", "Main Courses");
    steps.appShowPriceOnSection("15 euros", "Main Courses");
    steps.appShowTextOnSection("Choose one...", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Desserts");
    steps.appShowPriceOnSection("15 euros", "Total Price");

    // Reset
    steps.resetTest();
  }


  @Test
  public void T07ChooseSecondMainCourse() {

    // Given
    steps.appStartScreen("Menu Sections");
    steps.userPressSection("Main Courses");
    steps.appStartScreen("Menu Items");

    // When
    steps.userPressItem("Second Main Course");

    // Then
    steps.appResumeScreen("Menu Sections");
    steps.appShowTextOnSection("Choose one...", "Starters");
    steps.appShowPriceOnSection("0 euros", "Starters");
    steps.appShowTextOnSection("Second Main Course", "Main Courses");
    steps.appShowPriceOnSection("18 euros", "Main Courses");
    steps.appShowTextOnSection("Choose one...", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Desserts");
    steps.appShowPriceOnSection("18 euros", "Total Price");

    // Reset
    steps.resetTest();
  }



  @Test
  public void T08ChooseFirstDessert() {

    // Given
    steps.appStartScreen("Menu Sections");
    steps.userPressSection("Desserts");
    steps.appStartScreen("Menu Items");

    // When
    steps.userPressItem("First Dessert");

    // Then
    steps.appResumeScreen("Menu Sections");
    steps.appShowTextOnSection("Choose one...", "Starters");
    steps.appShowPriceOnSection("0 euros", "Starters");
    steps.appShowTextOnSection("Choose one...", "Main Courses");
    steps.appShowPriceOnSection("0 euros", "Main Courses");
    steps.appShowTextOnSection("First Dessert", "Desserts");
    steps.appShowPriceOnSection("7 euros", "Desserts");
    steps.appShowPriceOnSection("7 euros", "Total Price");

    // Reset
    steps.resetTest();
  }


  @Test
  public void T09ChooseSecondDessert() {

    // Given
    steps.appStartScreen("Menu Sections");
    steps.userPressSection("Desserts");
    steps.appStartScreen("Menu Items");

    // When
    steps.userPressItem("Second Dessert");

    // Then
    steps.appResumeScreen("Menu Sections");
    steps.appShowTextOnSection("Choose one...", "Starters");
    steps.appShowPriceOnSection("0 euros", "Starters");
    steps.appShowTextOnSection("Choose one...", "Main Courses");
    steps.appShowPriceOnSection("0 euros", "Main Courses");
    steps.appShowTextOnSection("Second Dessert", "Desserts");
    steps.appShowPriceOnSection("8 euros", "Desserts");
    steps.appShowPriceOnSection("8 euros", "Total Price");

    // Reset
    steps.resetTest();
  }


  // ------------------------------------------------------------------------

  @Test
  public void T10ChooseFirstMainCourseAndSecondDessert() {

    // Given
    steps.appStartScreen("Menu Sections");
    steps.userPressSection("Main Courses");
    steps.appStartScreen("Menu Items");
    steps.userPressItem("First Main Course");
    steps.appResumeScreen("Menu Sections");
    steps.userPressSection("Desserts");
    steps.appStartScreen("Menu Items");

    // When
    steps.userPressItem("Second Dessert");

    // Then
    steps.appResumeScreen("Menu Sections");
    steps.appShowTextOnSection("Choose one...", "Starters");
    steps.appShowPriceOnSection("0 euros", "Starters");
    steps.appShowTextOnSection("First Main Course", "Main Courses");
    steps.appShowPriceOnSection("15 euros", "Main Courses");
    steps.appShowTextOnSection("Second Dessert", "Desserts");
    steps.appShowPriceOnSection("8 euros", "Desserts");
    steps.appShowPriceOnSection("23 euros", "Total Price");


    // Reset
    steps.resetTest();

  }

  @Test
  public void T11ChooseFirstStarterAndSecondMainCourse() {

    // Given
    steps.appStartScreen("Menu Sections");
    steps.userPressSection("Starters");
    steps.appStartScreen("Menu Items");
    steps.userPressItem("First Starter");
    steps.appResumeScreen("Menu Sections");
    steps.userPressSection("Main Courses");
    steps.appStartScreen("Menu Items");

    // When
    steps.userPressItem("Second Main Course");

    // Then
    steps.appResumeScreen("Menu Sections");
    steps.appShowTextOnSection("First Starter", "Starters");
    steps.appShowPriceOnSection("10 euros", "Starters");
    steps.appShowTextOnSection("Second Main Course", "Main Courses");
    steps.appShowPriceOnSection("18 euros", "Main Courses");
    steps.appShowTextOnSection("Choose one...", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Desserts");
    steps.appShowPriceOnSection("28 euros", "Total Price");


    // Reset
    steps.resetTest();

  }


  @Test
  public void T12ChooseFirstStarterAndSecondDessert() {

    // Given
    steps.appStartScreen("Menu Sections");
    steps.userPressSection("Starters");
    steps.appStartScreen("Menu Items");
    steps.userPressItem("First Starter");
    steps.appResumeScreen("Menu Sections");
    steps.userPressSection("Desserts");
    steps.appStartScreen("Menu Items");

    // When
    steps.userPressItem("Second Dessert");

    // Then
    steps.appResumeScreen("Menu Sections");
    steps.appShowTextOnSection("First Starter", "Starters");
    steps.appShowPriceOnSection("10 euros", "Starters");
    steps.appShowTextOnSection("Choose one...", "Main Courses");
    steps.appShowPriceOnSection("0 euros", "Main Courses");
    steps.appShowTextOnSection("Second Dessert", "Desserts");
    steps.appShowPriceOnSection("8 euros", "Desserts");
    steps.appShowPriceOnSection("18 euros", "Total Price");


    // Reset
    steps.resetTest();

  }


  // ------------------------------------------------------------------------


  @Test
  public void T13ChooseFirstStarterAndFirstMainCourseAndFirstDessert() {

    // Given
    steps.appStartScreen("Menu Sections");
    steps.userPressSection("Starters");
    steps.appStartScreen("Menu Items");
    steps.userPressItem("First Starter");
    steps.appResumeScreen("Menu Sections");
    steps.userPressSection("Desserts");
    steps.appStartScreen("Menu Items");
    steps.userPressItem("First Dessert");
    steps.appResumeScreen("Menu Sections");
    steps.userPressSection("Main Courses");
    steps.appStartScreen("Menu Items");

    // When
    steps.userPressItem("First Main Course");

    // Then
    steps.appResumeScreen("Menu Sections");
    steps.appShowTextOnSection("First Starter", "Starters");
    steps.appShowPriceOnSection("10 euros", "Starters");
    steps.appShowTextOnSection("First Main Course", "Main Courses");
    steps.appShowPriceOnSection("15 euros", "Main Courses");
    steps.appShowTextOnSection("First Dessert", "Desserts");
    steps.appShowPriceOnSection("7 euros", "Desserts");
    steps.appShowPriceOnSection("32 euros", "Total Price");

    // Reset
    steps.resetTest();

  }


  @Test
  public void T14ChooseSecondStarterAndSecondMainCourseAndSecondDessert() {

    // Given
    steps.appStartScreen("Menu Sections");
    steps.userPressSection("Starters");
    steps.appStartScreen("Menu Items");
    steps.userPressItem("Second Starter");
    steps.appResumeScreen("Menu Sections");
    steps.userPressSection("Desserts");
    steps.appStartScreen("Menu Items");
    steps.userPressItem("Second Dessert");
    steps.appResumeScreen("Menu Sections");
    steps.userPressSection("Main Courses");
    steps.appStartScreen("Menu Items");

    // When
    steps.userPressItem("Second Main Course");

    // Then
    steps.appResumeScreen("Menu Sections");
    steps.appShowTextOnSection("Second Starter", "Starters");
    steps.appShowPriceOnSection("9 euros", "Starters");
    steps.appShowTextOnSection("Second Main Course", "Main Courses");
    steps.appShowPriceOnSection("18 euros", "Main Courses");
    steps.appShowTextOnSection("Second Dessert", "Desserts");
    steps.appShowPriceOnSection("8 euros", "Desserts");
    steps.appShowPriceOnSection("35 euros", "Total Price");

    // Reset
    steps.resetTest();

  }


  // ------------------------------------------------------------------------

  @Test
  public void T15ChooseFirstMainCourseAndBackOnChooseDessert() {


    // Given
    steps.appStartScreen("Menu Sections");
    steps.userPressSection("Main Courses");
    steps.appStartScreen("Menu Items");
    steps.userPressItem("First Main Course");
    steps.appResumeScreen("Menu Sections");
    steps.userPressSection("Desserts");
    steps.appStartScreen("Menu Items");

    // When
    steps.userPressBackOnScreen("Menu Items");

    // Then
    steps.appResumeScreen("Menu Sections");
    steps.appShowTextOnSection("Choose one...", "Starters");
    steps.appShowPriceOnSection("0 euros", "Starters");
    steps.appShowTextOnSection("First Main Course", "Main Courses");
    steps.appShowPriceOnSection("15 euros", "Main Courses");
    steps.appShowTextOnSection("Choose one...", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Desserts");
    steps.appShowPriceOnSection("15 euros", "Total Price");


    // Reset
    steps.resetTest();

  }

  @Test
  public void T16ChooseFirstStarterAndBackOnChooseMainCourse() {

    // Given
    steps.appStartScreen("Menu Sections");
    steps.userPressSection("Starters");
    steps.appStartScreen("Menu Items");
    steps.userPressItem("First Starter");
    steps.appResumeScreen("Menu Sections");
    steps.userPressSection("Main Courses");
    steps.appStartScreen("Menu Items");

    // When
    steps.userPressBackOnScreen("Menu Items");

    // Then
    steps.appResumeScreen("Menu Sections");
    steps.appShowTextOnSection("First Starter", "Starters");
    steps.appShowPriceOnSection("10 euros", "Starters");
    steps.appShowTextOnSection("Choose one...", "Main Courses");
    steps.appShowPriceOnSection("0 euros", "Main Courses");
    steps.appShowTextOnSection("Choose one...", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Desserts");
    steps.appShowPriceOnSection("10 euros", "Total Price");


    // Reset
    steps.resetTest();

  }


  @Test
  public void T17ChooseSecondDessertAndBackOnChooseStarter() {


    // Given
    steps.appStartScreen("Menu Sections");
    steps.userPressSection("Desserts");
    steps.appStartScreen("Menu Items");
    steps.userPressItem("Second Dessert");
    steps.appResumeScreen("Menu Sections");
    steps.userPressSection("Starters");
    steps.appStartScreen("Menu Items");

    // When
    steps.userPressBackOnScreen("Menu Items");


    // Then
    steps.appResumeScreen("Menu Sections");
    steps.appShowTextOnSection("Choose one...", "Starters");
    steps.appShowPriceOnSection("0 euros", "Starters");
    steps.appShowTextOnSection("Choose one...", "Main Courses");
    steps.appShowPriceOnSection("0 euros", "Main Courses");
    steps.appShowTextOnSection("Second Dessert", "Desserts");
    steps.appShowPriceOnSection("8 euros", "Desserts");
    steps.appShowPriceOnSection("8 euros", "Total Price");


    // Reset
    steps.resetTest();

  }


  // ------------------------------------------------------------------------



  @Test
  public void T18ChooseFirstMainCourseAndSecondDessertAndRotate() {

    // Given
    steps.appStartScreen("Menu Sections");
    steps.userPressSection("Main Courses");
    steps.appStartScreen("Menu Items");
    steps.userPressItem("First Main Course");
    steps.appResumeScreen("Menu Sections");
    steps.userPressSection("Desserts");
    steps.appStartScreen("Menu Items");
    steps.userPressItem("Second Dessert");
    steps.appResumeScreen("Menu Sections");

    // When
    steps.userRotateScreen("Menu Sections");

    // Then
    steps.appShowTextOnSection("Choose one...", "Starters");
    steps.appShowPriceOnSection("0 euros", "Starters");
    steps.appShowTextOnSection("First Main Course", "Main Courses");
    steps.appShowPriceOnSection("15 euros", "Main Courses");
    steps.appShowTextOnSection("Second Dessert", "Desserts");
    steps.appShowPriceOnSection("8 euros", "Desserts");
    steps.appShowPriceOnSection("23 euros", "Total Price");


    // Reset
    steps.resetTest();

  }

  @Test
  public void T19ChooseFirstStarterAndSecondMainCourseAndRotate() {

    // Given
    steps.appStartScreen("Menu Sections");
    steps.userPressSection("Starters");
    steps.appStartScreen("Menu Items");
    steps.userPressItem("First Starter");
    steps.appResumeScreen("Menu Sections");
    steps.userPressSection("Main Courses");
    steps.appStartScreen("Menu Items");
    steps.userPressItem("Second Main Course");
    steps.appResumeScreen("Menu Sections");

    // When
    steps.userRotateScreen("Menu Sections");

    // Then
    steps.appShowTextOnSection("First Starter", "Starters");
    steps.appShowPriceOnSection("10 euros", "Starters");
    steps.appShowTextOnSection("Second Main Course", "Main Courses");
    steps.appShowPriceOnSection("18 euros", "Main Courses");
    steps.appShowTextOnSection("Choose one...", "Desserts");
    steps.appShowPriceOnSection("0 euros", "Desserts");
    steps.appShowPriceOnSection("28 euros", "Total Price");


    // Reset
    steps.resetTest();

  }


  @Test
  public void T20ChooseFirstStarterAndSecondDessertAndRotate() {


    // Given
    steps.appStartScreen("Menu Sections");
    steps.userPressSection("Starters");
    steps.appStartScreen("Menu Items");
    steps.userPressItem("First Starter");
    steps.appResumeScreen("Menu Sections");
    steps.userPressSection("Desserts");
    steps.appStartScreen("Menu Items");
    steps.userPressItem("Second Dessert");
    steps.appResumeScreen("Menu Sections");

    // When
    steps.userRotateScreen("Menu Sections");

    // Then
    steps.appShowTextOnSection("First Starter", "Starters");
    steps.appShowPriceOnSection("10 euros", "Starters");
    steps.appShowTextOnSection("Choose one...", "Main Courses");
    steps.appShowPriceOnSection("0 euros", "Main Courses");
    steps.appShowTextOnSection("Second Dessert", "Desserts");
    steps.appShowPriceOnSection("8 euros", "Desserts");
    steps.appShowPriceOnSection("18 euros", "Total Price");


    // Reset
    steps.resetTest();

  }

}
