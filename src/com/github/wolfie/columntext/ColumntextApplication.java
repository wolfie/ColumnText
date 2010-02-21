package com.github.wolfie.columntext;

import com.vaadin.Application;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.validator.IntegerValidator;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class ColumntextApplication extends Application {
  
  @Override
  public void init() {
    final Window mainWindow = new Window("Columntext Application");
    setMainWindow(mainWindow);
    
    final TextField height = new TextField("height");
    height.setValue("100px");
    height.setColumns(5);
    height.setImmediate(true);
    
    final TextField width = new TextField("width");
    width.setValue("100%");
    width.setColumns(5);
    width.setImmediate(true);
    
    final TextField columns = new TextField("columns");
    columns.addValidator(new IntegerValidator("must be an integer"));
    columns.setValue("3");
    columns.setColumns(5);
    columns.setImmediate(true);
    
    final HorizontalLayout horizontalLayout = new HorizontalLayout();
    horizontalLayout.addComponent(height);
    horizontalLayout.addComponent(width);
    horizontalLayout.addComponent(columns);
    
    final ColumnText columnText = new ColumnText("100px", 3);
    columnText.setWidth("100%");
    columnText
        .setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
            + "Quisque eu sem metus, sit amet accumsan lorem. "
            + "Curabitur id felis arcu. Nulla facilisis dapibus facilisis. "
            + "Suspendisse cursus dignissim accumsan. "
            + "Duis pretium lorem non leo consequat commodo. "
            + "Ut tincidunt molestie quam in tempus. Cras non erat neque. "
            + "Aliquam viverra posuere nibh, ac ultrices metus iaculis non. "
            + "Duis at tortor quis nunc pharetra placerat non et mi. "
            + "Suspendisse ut ipsum velit, a malesuada nunc. "
            + "Sed consequat blandit laoreet. Duis non pharetra dolor. "
            + "Nunc aliquet lacus in ipsum fermentum dapibus. "
            + "Morbi congue dui sit amet nibh pulvinar in cursus mauris bibendum. "
            + "Vestibulum sed fermentum eros. "
            + "Aliquam molestie dignissim enim eget mollis. "
            + "Sed vel erat libero, sit amet scelerisque quam. "
            + "In vitae vulputate augue. "
            + "Maecenas et lacus vel tellus tincidunt lobortis.");
    
    final ColumnText columnHtml = new ColumnText("100px", 3);
    columnHtml.setWidth("100%");
    columnHtml
        .setHtml("<h1>Lorem ipsum dolor sit amet</h1> "
            + "<p><b>Consectetur</b> adipiscing elit. "
            + "Quisque eu sem metus, sit amet accumsan lorem. "
            + "Curabitur id felis arcu. Nulla facilisis dapibus facilisis. "
            + "Suspendisse cursus dignissim accumsan.</p> "
            + "<h2>Duis pretium lorem non leo consequat commodo.</h2> "
            + "<p>Ut tincidunt molestie quam in tempus. Cras non erat neque. "
            + "Aliquam viverra posuere nibh, ac ultrices metus iaculis non. "
            + "Duis at tortor quis nunc pharetra placerat non et mi. "
            + "Suspendisse ut ipsum velit, a malesuada nunc. "
            + "Sed consequat blandit laoreet. Duis non pharetra dolor.</p> "
            + "<h2>Nunc aliquet lacus in ipsum fermentum dapibus.</h2> "
            + "<p>Morbi congue dui sit amet nibh pulvinar in cursus mauris bibendum. "
            + "Vestibulum sed fermentum eros. "
            + "Aliquam molestie dignissim enim eget mollis. "
            + "Sed vel erat libero, sit amet scelerisque quam. "
            + "In vitae vulputate augue. "
            + "Maecenas et lacus vel tellus tincidunt lobortis.</p>");
    
    final Label spacer1 = new Label();
    spacer1.setHeight("2em");
    final Label spacer2 = new Label();
    spacer2.setHeight("2em");
    
    final Panel textPanel = new Panel("Plain text", new CssLayout());
    textPanel.addComponent(columnText);
    final Panel htmlPanel = new Panel("HTML", new CssLayout());
    htmlPanel.addComponent(columnHtml);
    
    mainWindow.addComponent(horizontalLayout);
    mainWindow.addComponent(spacer1);
    mainWindow.addComponent(textPanel);
    mainWindow.addComponent(spacer2);
    mainWindow.addComponent(htmlPanel);
    
    width.addListener(new ValueChangeListener() {
      public void valueChange(final ValueChangeEvent event) {
        columnText.setWidth((String) event.getProperty().getValue());
        columnHtml.setWidth((String) event.getProperty().getValue());
      }
    });
    
    height.addListener(new ValueChangeListener() {
      public void valueChange(final ValueChangeEvent event) {
        columnText.setHeight((String) event.getProperty().getValue());
        columnHtml.setHeight((String) event.getProperty().getValue());
      }
    });
    
    columns.addListener(new ValueChangeListener() {
      public void valueChange(final ValueChangeEvent event) {
        final int columns = Integer.parseInt((String) event.getProperty()
            .getValue());
        columnText.setColumns(columns);
        columnHtml.setColumns(columns);
      }
    });
  }
  
}
