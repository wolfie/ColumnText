package com.github.wolfie.columntext.client.ui;

import java.util.ArrayList;
import java.util.List;

/*
 * This class is extracted out from VColumnText, since GWT does some static
 * initialization for Widgets, which isn't what we want when unit testing.
 */

public class SplitUtil {
  private SplitUtil() {
  }
  
  public static String[] splitHTML(final String text) {
    char quote = 0;
    boolean isEscaped = false;
    boolean isTag = false;
    final List<String> tokens = new ArrayList<String>();
    
    StringBuilder token = new StringBuilder();
    for (int i = 0; i < text.length(); i++) {
      final char c = text.charAt(i);
      if (isWhitespace(c) && quote == 0 && !isTag) {
        if (token.length() > 0) {
          tokens.add(token.toString().trim());
          token = new StringBuilder();
        }
        continue;
      }

      else {
        if (c == '\\' && !isEscaped && isTag) {
          isEscaped = true;
        } else {
          
          if (c == '"' || c == '\'') {
            if (quote == 0 && !isEscaped && isTag) {
              quote = c;
            } else if (quote == c) {
              quote = 0;
            }
          }

          else if (c == '<' && quote == 0) {
            if (token.length() > 0) {
              tokens.add(token.toString().trim());
              token = new StringBuilder();
            }
            isTag = true;
          }

          else if (c == '>' && quote == 0) {
            token.append(c);
            tokens.add(token.toString().trim());
            token = new StringBuilder();
            isTag = false;
            isEscaped = false;
            continue;
          }
          
          isEscaped = false;
        }
        
        token.append(c);
      }
    }
    
    if (token.toString().trim().length() > 0) {
      tokens.add(token.toString().trim());
    }
    
    return tokens.toArray(new String[tokens.size()]);
  }
  
  public static boolean isWhitespace(final char c) {
    return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\f';
  }
  
}
