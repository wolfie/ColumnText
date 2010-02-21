package com.github.wolfie.columntext.client.ui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.vaadin.terminal.gwt.client.ApplicationConnection;
import com.vaadin.terminal.gwt.client.Paintable;
import com.vaadin.terminal.gwt.client.UIDL;

public class VColumnTextCSS extends Composite implements Paintable {
  
  protected ApplicationConnection client;
  protected String paintableId;
  private final HTML html;
  private static final CSS css = ColumnTextResources.INSTANCE.css();
  
  static {
    css.ensureInjected();
  }
  
  /**
   * The constructor should first call super() to initialize the component and
   * then handle any initialization relevant to Vaadin.
   */
  public VColumnTextCSS() {
    html = new HTML();
    initWidget(html);
    html.setStyleName(css.className());
  }
  
  public void updateFromUIDL(final UIDL uidl, final ApplicationConnection client) {
    this.client = client;
    paintableId = uidl.getId();
    
    if (uidl.hasAttribute(VColumnText.IS_TEXT_BOOL)
        && uidl.hasAttribute(VColumnText.TEXT_STRING)) {
      final boolean isText = uidl.getBooleanAttribute(VColumnText.IS_TEXT_BOOL);
      final String text = uidl.getStringAttribute(VColumnText.TEXT_STRING);
      
      if (isText) {
        html.setText(text);
      } else {
        html.setHTML(text);
      }
    }
    
    if (uidl.hasAttribute(VColumnText.COLUMNS_INT)) {
      final int columns = uidl.getIntAttribute(VColumnText.COLUMNS_INT);
      final String columnsAsString = String.valueOf(columns);
      
      html.getElement().getStyle().setProperty("MozColumnCount",
          columnsAsString);
      html.getElement().getStyle().setProperty("webkitColumnCount",
          columnsAsString);
      html.getElement().getStyle().setProperty("columnCount", columnsAsString);
    }
  }
}
