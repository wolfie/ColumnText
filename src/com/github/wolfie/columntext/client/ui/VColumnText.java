package com.github.wolfie.columntext.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.terminal.gwt.client.ApplicationConnection;
import com.vaadin.terminal.gwt.client.Paintable;
import com.vaadin.terminal.gwt.client.UIDL;

public class VColumnText<T extends Widget & Paintable> extends Composite
    implements Paintable {
  
  /* The class name is defined in the class CSS */
  // public static final String CLASSNAME = "v-columntext";
  
  public static final String COLUMNS_INT = "cols";
  public static final String TEXT_STRING = "text";
  public static final String IS_TEXT_BOOL = "istext";
  
  /** The client side widget identifier */
  protected String paintableId;
  
  /** Reference to the server connection object. */
  protected ApplicationConnection client;
  
  private final T containedWidget;
  
  public VColumnText() {
    containedWidget = GWT.create(VColumnTextJS.class);
    initWidget(containedWidget);
  }
  
  /**
   * Called whenever an update is received from the server
   */
  public void updateFromUIDL(final UIDL uidl, final ApplicationConnection client) {
    if (client.updateComponent(this, uidl, true)) {
      return;
    }
    
    containedWidget.updateFromUIDL(uidl, client);
  }
}
