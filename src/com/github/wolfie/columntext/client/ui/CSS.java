package com.github.wolfie.columntext.client.ui;

import com.google.gwt.resources.client.CssResource;

public interface CSS extends CssResource {
  @ClassName("v-columntext")
  String className();
  
  @ClassName("column")
  String columnClass();
  
  @ClassName("column-first")
  String columnFirstClass();
  
  @ClassName("column-last")
  String columnLastClass();
}
