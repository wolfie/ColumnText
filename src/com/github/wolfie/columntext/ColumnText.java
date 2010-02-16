package com.github.wolfie.columntext;

import com.github.wolfie.columntext.client.ui.VColumnText;
import com.vaadin.terminal.PaintException;
import com.vaadin.terminal.PaintTarget;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.ClientWidget;

/**
 * Server side component for the VColumnText widget.
 */
@SuppressWarnings("serial")
@ClientWidget(VColumnText.class)
public class ColumnText extends AbstractComponent {
  
  private int columns;
  private String text;
  private boolean isText;
  
  private ColumnText(final int columns) {
    setWidth("100%");
    setColumns(columns);
  }
  
  public ColumnText(final String height, final int columns) {
    this(columns);
    setHeight(height);
  }
  
  public ColumnText(final float height, final int unit, final int columns) {
    this(columns);
    setHeight(height, unit);
  }
  
  public void setColumns(final int columns) {
    if (columns > 0) {
      this.columns = columns;
      requestRepaint();
    } else {
      throw new UnsupportedOperationException(
          "You need to have more than 0 columns");
    }
  }
  
  public int getColumns() {
    return columns;
  }
  
  @Override
  public void paintContent(final PaintTarget target) throws PaintException {
    super.paintContent(target);
    
    target.addAttribute(VColumnText.COLUMNS_INT, columns);
    target.addAttribute(VColumnText.TEXT_STRING, text);
    target.addAttribute(VColumnText.IS_TEXT_BOOL, isText);
  }
  
  public void setText(final String text) {
    this.text = text;
    isText = true;
    requestRepaint();
  }
  
  public String getText() {
    return text;
  }
  
  public void setHtml(final String html) {
    text = html;
    isText = false;
    requestRepaint();
  }
}
