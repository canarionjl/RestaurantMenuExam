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
    state.data = model.getStoredData();
    prepareState();
  }

  @Override
  public void onRestart() {
  }


  @Override
  public void onResume() {

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
  }

  @Override
  public void onBackPressed() {

  }

  @Override
  public void onPause() {

  }

  @Override
  public void onDestroy() {

  }

  @Override
  public void onStartersBtnClicked() {

    state.startersButtonClicked=true;
    passDataFromSectionsToItemsState(state.data.itemsStarters);
    view.get().navigateToMenuDetailScreen();

  }

  @Override
  public void onMainCoursesBtnClicked() {

    state.mainCoursesButtonClicked=true;
    passDataFromSectionsToItemsState(state.data.itemsMainCourses);
    view.get().navigateToMenuDetailScreen();

  }

  @Override
  public void onDessertsBtnClicked() {

    state.dessertsButtonClicked=true;
    passDataFromSectionsToItemsState(state.data.itemsDesserts);
    view.get().navigateToMenuDetailScreen();

  }

  public void passDataFromSectionsToItemsState (List<MenuItem> list){
    SectionsToItemsState state = new SectionsToItemsState();
    state.itemsSection = list;
    mediator.setSectionsToItemsState(state);
  }

  public void calculateTotalPrice() {
    int starterPrice;
    int mainCoursePrice;
    int dessertsPrice;

   if(state.itemStarters!=null){
      starterPrice=state.itemStarters.itemPrice;
    } else {
     starterPrice = 0;
    }
    if(state.itemMainCourses!=null){
      mainCoursePrice=state.itemMainCourses.itemPrice;
    } else {
      mainCoursePrice = 0;
    }
    if(state.itemDesserts!=null){
      dessertsPrice=state.itemDesserts.itemPrice;
    } else {
      dessertsPrice = 0;
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
