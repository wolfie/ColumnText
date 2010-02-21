package com.github.wolfie.columntext.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

public interface ColumnTextResources extends ClientBundle {
  public static final ColumnTextResources INSTANCE = GWT
      .create(ColumnTextResources.class);
  
  @Source("com/github/wolfie/columntext/public/columntext.css")
  CSS css();
}
