/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist311.schedulingsystem;

import Controller.InitLoginController;
import Model.UserModel;
import View.LoginGUI;
import View.LoginView;

/**
 *
 * @author josieldelgadillo
 */
public class IST311SchedulingSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        LoginView view = new LoginView();
        
        
        // Initialize View
        LoginGUI gui = new LoginGUI();
        gui.setVisible(true);
        
        // Init Model
        UserModel model = new UserModel();
        
        // Init Controller
        InitLoginController cntlr = new InitLoginController(model ,gui);
        
        
    }
    
}
