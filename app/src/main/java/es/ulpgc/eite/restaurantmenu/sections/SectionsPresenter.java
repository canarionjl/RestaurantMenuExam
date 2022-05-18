package es.ulpgc.eite.restaurantmenu.sections;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.restaurantmenu.app.AppMediator;

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
  public void onStartersBtnClicked() {
    Log.e(TAG, "onStartersBtnClicked()");

    // TODO: include some code if is necessary
  }

  @Override
  public void onMainCoursesBtnClicked() {
    Log.e(TAG, "onMainCoursesBtnClicked()");

    // TODO: include some code if is necessary
  }

  @Override
  public void onDessertsBtnClicked() {
    Log.e(TAG, "onDessertsBtnClicked()");

    // TODO: include some code if is necessary
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
