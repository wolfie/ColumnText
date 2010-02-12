package com.github.wolfie.columntext.client.ui;

import com.google.gwt.user.client.ui.CellPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.vaadin.terminal.gwt.client.ApplicationConnection;
import com.vaadin.terminal.gwt.client.Paintable;
import com.vaadin.terminal.gwt.client.UIDL;

public class VColumnText extends Composite implements Paintable {
  
  /** Set the CSS class name to allow styling. */
  public static final String CLASSNAME = "v-columntext";
  
  public static final String COLUMNS_INT = "cols";
  public static final String TEXT_STRING = "text";
  
  /** The client side widget identifier */
  protected String paintableId;
  
  /** Reference to the server connection object. */
  ApplicationConnection client;
  
  private final CellPanel panel = new HorizontalPanel();
  
  private String text = "";
  
  private int columns;
  
  /**
   * The constructor should first call super() to initialize the component and
   * then handle any initialization relevant to Vaadin.
   */
  public VColumnText() {
    initWidget(panel);
    
    // This method call of the Paintable interface sets the component
    // style name in DOM tree
    setStyleName(CLASSNAME);
  }
  
  /**
   * Called whenever an update is received from the server
   */
  public void updateFromUIDL(final UIDL uidl, final ApplicationConnection client) {
    if (client.updateComponent(this, uidl, true)) {
      return;
    }
    this.client = client;
    paintableId = uidl.getId();
    
    boolean needsRecalculation = false;
    if (uidl.hasAttribute(COLUMNS_INT)) {
      columns = uidl.getIntAttribute(COLUMNS_INT);
      needsRecalculation = true;
    }
    
    if (uidl.hasAttribute(TEXT_STRING)) {
      text = uidl.getStringAttribute(TEXT_STRING);
      needsRecalculation = true;
    }
    
    if (needsRecalculation) {
      recalculateColumns();
    }
    
  }
  
  private void recalculateColumns() {
    // TODO: optimize by checking where the string has been changed, and only
    // change the necessary columns.
    
    // TODO: optimize by letting each column act as a guess for the next
    // column's word count, and adjust from there.
    
    panel.clear();
    
    // the columns must be defined first, so that they occupy the required
    // horizontal space as they would.
    final String columnWidth = (100 / columns) + "%";
    for (int i = 0; i < columns; i++) {
      final Label label = new Label();
      panel.add(label);
      panel.setCellWidth(label, columnWidth);
    }
    
    final String[] tokens = text.split("\\s");
    final int widgetHeight = getOffsetHeight();
    int column = 0;
    Label label = (Label) panel.getWidget(column);
    for (final String token : tokens) {
      final String currentLabelText = label.getText();
      
      label.setText(currentLabelText + " " + token);
      if (label.getOffsetHeight() > widgetHeight) {
        label.setText(currentLabelText);
        
        column++;
        if (column >= columns) {
          break;
        }
        
        label = (Label) panel.getWidget(column);
        label.setText(token);
      }
    }
  }
}
