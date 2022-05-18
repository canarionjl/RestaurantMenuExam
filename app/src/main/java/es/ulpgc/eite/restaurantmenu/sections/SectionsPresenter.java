package es.ulpgc.eite.restaurantmenu.sections;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.restaurantmenu.app.AppMediator;
import es.ulpgc.eite.restaurantmenu.app.ItemsToSectionsState;
import es.ulpgc.eite.restaurantmenu.app.SectionsToItemsState;
import es.ulpgc.eite.restaurantmenu.data.MenuItem;

/**
 * Created by Luis on marzo, 2022
 */
public class SectionsPresenter implements SectionsContract.Presenter {

  public static String TAG = "RestaurantMenu.SectionsPresenter";

  private WeakReference<SectionsContract.View> view;
  private SectionsState state;
  private SectionsContract.Model model;
  private AppMediator mediator;

  public SectionsPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getSectionsState();
  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");
    state.data = model.getStoredData();
    prepareState();

  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    // TODO: include some code if is necessary
  }


  @Override
  public void onResume() {
    Log.e(TAG, "onResumeSection()");

    ItemsToSectionsState itemsToSectionsState = mediator.getItemsToSectionsState();
    if(itemsToSectionsState!=null){

      if(state.startersButtonClicked){
        state.startersButtonClicked=false;
        state.itemStarters=itemsToSectionsState.itemSection;
      }
      if(state.mainCoursesButtonClicked){

        state.mainCoursesButtonClicked=false;
        state.itemMainCourses=itemsToSectionsState.itemSection;
      }
      if(state.dessertsButtonClicked) {
        state.dessertsButtonClicked = false;
        state.itemDesserts = itemsToSectionsState.itemSection;

      }
    }

    calculateTotalPrice();
    view.get().onDataUpdated(state);
    // TODO: include some code if is necessary
  }

  @Override
  public void onBackPressed() {
    Log.e(TAG, "onBackPressed()");

    // TODO: include some code if is necessary
  }

  @Override
  public void onPause() {
    Log.e(TAG, "onPause()");

    // TODO: include some code if is necessary
  }

  @Override
  public void onDestroy() {
    Log.e(TAG, "onDestroy()");

    // TODO: include some code if is necessary
  }

  @Override
  public void onStartersBtnClicked() {
    Log.e(TAG, "onStartersBtnClicked()");

    state.startersButtonClicked=true;
    passDataFromSectionsToItemsState(state.data.itemsStarters);
    view.get().navigateToMenuDetailScreen();

    // TODO: include some code if is necessary
  }

  @Override
  public void onMainCoursesBtnClicked() {
    Log.e(TAG, "onMainCoursesBtnClicked()");

    state.mainCoursesButtonClicked=true;
    passDataFromSectionsToItemsState(state.data.itemsMainCourses);
    view.get().navigateToMenuDetailScreen();

    // TODO: include some code if is necessary
  }

  @Override
  public void onDessertsBtnClicked() {
    Log.e(TAG, "onDessertsBtnClicked()");

    state.dessertsButtonClicked=true;
    passDataFromSectionsToItemsState(state.data.itemsDesserts);
    view.get().navigateToMenuDetailScreen();

    // TODO: include some code if is necessary
  }

  public void passDataFromSectionsToItemsState (List<MenuItem> list){
    SectionsToItemsState state = new SectionsToItemsState();
    state.itemsSection = list;
    mediator.setSectionsToItemsState(state);
  }

  public void calculateTotalPrice(){
    int starterPrice=0;
    int mainCoursePrice=0;
    int dessertsPrice=0;
   if(state.itemStarters!=null){
      starterPrice=state.itemStarters.itemPrice;
    }
    if(state.itemMainCourses!=null){
      mainCoursePrice=state.itemMainCourses.itemPrice;
    }
    if(state.itemDesserts!=null){
      dessertsPrice=state.itemDesserts.itemPrice;
    }

    state.priceMenu=starterPrice+mainCoursePrice+dessertsPrice;

  }
  public void prepareState (){

    state.dessertsButtonClicked=false;
    state.startersButtonClicked=false;
    state.mainCoursesButtonClicked=false;
  }
  @Override
  public void injectView(WeakReference<SectionsContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(SectionsContract.Model model) {
    this.model = model;
  }

}
