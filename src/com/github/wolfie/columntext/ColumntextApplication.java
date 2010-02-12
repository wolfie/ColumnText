package com.github.wolfie.columntext;

import com.vaadin.Application;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

public class ColumntextApplication extends Application {
  @Override
  public void init() {
    final Window mainWindow = new Window("Columntext Application");
    setMainWindow(mainWindow);
    mainWindow.addComponent(new Label("label"));
    
    final ColumnText columnText = new ColumnText("100px", 3);
    columnText.setWidth("500px");
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
    mainWindow.addComponent(columnText);
  }
  
}
