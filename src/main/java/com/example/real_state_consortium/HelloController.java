package com.example.real_state_consortium;

import com.example.real_state_consortium.utils.ChangeViewParticular;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class HelloController {

    public void watchCatalog(MouseEvent e)  throws IOException{
        ChangeViewParticular.watchCatalog(e);
    }
    public void enterAtLogin(MouseEvent e) throws IOException{
        ChangeViewParticular.enterAtLogin(e);
    }
    public void quoteProperty(MouseEvent e) throws IOException{
        ChangeViewParticular.quoteProperty(e);
    }
}