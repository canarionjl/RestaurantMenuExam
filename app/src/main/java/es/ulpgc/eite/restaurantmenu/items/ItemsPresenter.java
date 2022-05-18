package es.ulpgc.eite.restaurantmenu.items;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.restaurantmenu.app.AppMediator;

/**
 * Created by Luis on marzo, 2022
 */
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
    Log.e(TAG, "onStart()");

    // TODO: include some code if is necessary
  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    // TODO: include some code if is necessary
  }

  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");

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
  public void onFirstBtnClicked() {
    Log.e(TAG, "onFirstBtnClicked()");

    // TODO: include some code if is necessary
  }

  @Override
  public void onSecondBtnClicked() {
    Log.e(TAG, "onSecondBtnClicked()");

    // TODO: include some code if is necessary
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
