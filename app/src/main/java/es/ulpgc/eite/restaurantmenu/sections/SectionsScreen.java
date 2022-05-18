package es.ulpgc.eite.restaurantmenu.sections;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.restaurantmenu.app.AppMediator;

/**
 * Created by Luis on marzo, 2022
 */
public class SectionsScreen {

  public static void configure(SectionsContract.View view) {

    /*
    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);
    */

    AppMediator mediator = AppMediator.getInstance();

    SectionsContract.Presenter presenter = new SectionsPresenter(mediator);
    SectionsContract.Model model = new SectionsModel();
    presenter.injectModel(model);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
