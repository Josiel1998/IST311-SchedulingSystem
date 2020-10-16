/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.UserModel;
import View.LoginGUI;

/**
 *
 * @author josieldelgadillo
 */
public class InitLoginController {
    
    UserModel model;
    LoginGUI view;
   
    public InitLoginController(){}
    
    public InitLoginController(UserModel model, LoginGUI view){
        model = this.model;
        view = this.view;
    }
    
    public boolean Authenticate(String username, String password){
         
        System.out.println(username);
        System.out.println(password);
        
        return true;
    }
    
    public void LoginButtonClicked(){
        view = new LoginGUI();
    }
    
    
}
