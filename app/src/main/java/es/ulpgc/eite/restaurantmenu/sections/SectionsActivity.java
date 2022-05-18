package es.ulpgc.eite.restaurantmenu.sections;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.restaurantmenu.R;
import es.ulpgc.eite.restaurantmenu.items.ItemsActivity;

/**
 * Created by Luis on marzo, 2022
 */
public class SectionsActivity
    extends AppCompatActivity implements SectionsContract.View {

  public static String TAG = "RestaurantMenu.SectionsActivity";

  private SectionsContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sections);
    getSupportActionBar().setTitle(R.string.title_sections_screen);


    // do the setup
    SectionsScreen.configure(this);

    setOnClickListeners();

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


  public void onStartersBtnClicked(View view) {
    presenter.onStartersBtnClicked();
  }

  public void onMainCoursesBtnClicked(View view) {
    presenter.onMainCoursesBtnClicked();
  }

  public void onDessertsBtnClicked(View view) {
    presenter.onDessertsBtnClicked();
  }

  public void setOnClickListeners(){
    ((LinearLayout) findViewById(R.id.btnStarters)).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onStartersBtnClicked(view);
      }
    });

    ((LinearLayout) findViewById(R.id.btnMainCourses)).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onMainCoursesBtnClicked(view);
      }
    });

    ((LinearLayout) findViewById(R.id.btnDesserts)).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onDessertsBtnClicked(view);
      }
    });

  }

  @Override
  public void navigateToMenuDetailScreen() {
    Intent intent = new Intent(this, ItemsActivity.class);
    startActivity(intent);
  }

  @Override
  public void onDataUpdated(SectionsViewModel viewModel) {
    //Log.e(TAG, "onDataUpdated()");

    // deal with the data
    if (viewModel.itemStarters != null) {
      ((TextView) findViewById(R.id.tvItemStarters))
          .setText(viewModel.itemStarters.itemName);
      ((TextView) findViewById(R.id.tvPriceStarters))
          .setText(viewModel.itemStarters.itemPrice + " euros");
    }

    if (viewModel.itemDesserts != null) {
      ((TextView) findViewById(R.id.tvItemDesserts))
          .setText(viewModel.itemDesserts.itemName);
      ((TextView) findViewById(R.id.tvPriceDesserts))
          .setText(viewModel.itemDesserts.itemPrice + " euros");
    }

    if (viewModel.itemMainCourses != null) {
      ((TextView) findViewById(R.id.tvItemMainCourses))
          .setText(viewModel.itemMainCourses.itemName);
      ((TextView) findViewById(R.id.tvPriceMainCourses))
          .setText(viewModel.itemMainCourses.itemPrice + " euros");
    }


    ((TextView) findViewById(R.id.tvPriceMenu))
        .setText(viewModel.priceMenu + " euros");
  }


  @Override
  public void navigateToNextScreen() {
    Intent intent = new Intent(this, ItemsActivity.class);
    startActivity(intent);
  }

  @Override
  public void injectPresenter(SectionsContract.Presenter presenter) {
    this.presenter = presenter;
  }


}
