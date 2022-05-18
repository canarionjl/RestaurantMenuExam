package es.ulpgc.eite.restaurantmenu.items;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.restaurantmenu.R;

/**
 * Created by Luis on marzo, 2022
 */
public class ItemsActivity
    extends AppCompatActivity implements ItemsContract.View {

  public static String TAG = "RestaurantMenu.ItemsActivity";


  private ItemsContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_items);
    getSupportActionBar().setTitle(R.string.title_items_screen);

    // do the setup
    ItemsScreen.configure(this);

    if (savedInstanceState == null) {
      presenter.onStart();

    } else {
      presenter.onRestart();
    }
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    presenter.onResume();
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();

    presenter.onBackPressed();
  }

  @Override
  protected void onPause() {
    super.onPause();

    presenter.onPause();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

    presenter.onDestroy();
  }


  public void onSecondBtnClicked(View view) {
    presenter.onSecondBtnClicked();
  }

  public void onFirstBtnClicked(View view) {
    presenter.onFirstBtnClicked();
  }


  @Override
  public void onDataUpdated(ItemsViewModel viewModel) {
    //Log.e(TAG, "onDataUpdated()");

    // deal with the data
    if (viewModel.itemsSection != null) {
      ((TextView) findViewById(R.id.tvNameFirst))
          .setText(viewModel.itemsSection.get(0).itemName);
      ((TextView) findViewById(R.id.tvPriceFirst))
          .setText(viewModel.itemsSection.get(0).itemPrice + " euros");

      ((TextView) findViewById(R.id.tvNameSecond))
          .setText(viewModel.itemsSection.get(1).itemName);
      ((TextView) findViewById(R.id.tvPriceSecond))
          .setText(viewModel.itemsSection.get(1).itemPrice + " euros");
    }
  }

  @Override
  public void navigateToPreviousScreen() {
    finish();
  }


  @Override
  public void injectPresenter(ItemsContract.Presenter presenter) {
    this.presenter = presenter;
  }


}
