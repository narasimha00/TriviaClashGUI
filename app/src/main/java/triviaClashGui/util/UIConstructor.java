package triviaClashGui.util;

import java.awt.Component;

public interface UIConstructor {
    void construct();
    void destroy();
    void initializeWindow();
    void initializeComponents();
    Component getPanel();
}
