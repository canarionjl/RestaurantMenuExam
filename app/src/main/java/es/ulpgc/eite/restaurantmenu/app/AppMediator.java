package es.ulpgc.eite.restaurantmenu.app;

import es.ulpgc.eite.restaurantmenu.items.ItemsState;
import es.ulpgc.eite.restaurantmenu.sections.SectionsState;

/**
 * Created by Luis on marzo, 2022
 */
@SuppressWarnings("unused")
public class AppMediator {

  private static AppMediator INSTANCE;

  private SectionsState sectionsState;
  private ItemsState itemsState;

  private SectionsToItemsState sectionsToItemsState;
  private ItemsToSectionsState itemsToSectionsState;

  private AppMediator() {
    sectionsState = new SectionsState();
    itemsState = new ItemsState();
  }

  public static AppMediator getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new AppMediator();
    }

    return INSTANCE;
  }

  // to reset the state when testing
  public static void resetInstance() {
    INSTANCE = null;
  }

  public SectionsState getSectionsState() {
    return sectionsState;
  }


  public ItemsState getItemsState() {
    return itemsState;
  }

  public void setSectionsToItemsState(SectionsToItemsState state) {
    sectionsToItemsState =state;
  }

  public ItemsToSectionsState getItemsToSectionsState() {
    ItemsToSectionsState state= itemsToSectionsState;
    itemsToSectionsState= null;
    return state;
  }

  public void setItemsToSectionsState(ItemsToSectionsState state) {
    itemsToSectionsState = state;
  }

  public SectionsToItemsState getSectionsToItemsState() {
    SectionsToItemsState state=sectionsToItemsState;
    sectionsToItemsState=null;
    return state;
  }
}
