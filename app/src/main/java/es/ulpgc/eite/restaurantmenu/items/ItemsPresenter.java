package es.ulpgc.eite.restaurantmenu.items;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.restaurantmenu.app.AppMediator;
import es.ulpgc.eite.restaurantmenu.app.ItemsToSectionsState;
import es.ulpgc.eite.restaurantmenu.app.SectionsToItemsState;
import es.ulpgc.eite.restaurantmenu.data.MenuItem;

/**
 * Created by Luis on marzo, 2022
 */

//Repositorio de github: https://github.com/canarionjl/RestaurantMenuExam

public class ItemsPresenter implements ItemsContract.Presenter {

  public static String TAG = "RestaurantMenu.ItemsPresenter";

  private WeakReference<ItemsContract.View> view;
  private ItemsState state;
  private ItemsContract.Model model;
  private AppMediator mediator;

  public ItemsPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getItemsState();
  }

  @Override
  public void onStart() {
  }

  @Override
  public void onRestart() {
  }

  @Override
  public void onResume() {

    SectionsToItemsState sectionToItemState = mediator.getSectionsToItemsState();
    if(sectionToItemState!=null) {
        state.itemsSection = sectionToItemState.itemsSection;
    }

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
  public void onFirstBtnClicked() {
    state.menuItemClicked=state.itemsSection.get(0);
    passDataFromItemsToSectionsState();
    view.get().navigateToPreviousScreen();
  }

  @Override
  public void onSecondBtnClicked() {
    state.menuItemClicked=state.itemsSection.get(1);
    passDataFromItemsToSectionsState();
    view.get().navigateToPreviousScreen();
  }

  public void passDataFromItemsToSectionsState (){
    ItemsToSectionsState itemsToSectionsState = new ItemsToSectionsState();
    itemsToSectionsState.itemSection=state.menuItemClicked;
    mediator.setItemsToSectionsState(itemsToSectionsState);
  }

  @Override
  public void injectView(WeakReference<ItemsContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ItemsContract.Model model) {
    this.model = model;
  }

}
