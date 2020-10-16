/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.UserModel;
import View.LoginGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author josieldelgadillo
 */
public class InitLoginController implements ActionListener {
    
    UserModel model;
    LoginGUI view;
   
    public InitLoginController(){}
    
    public InitLoginController(UserModel model, LoginGUI view){
        super();
        model = this.model;
        view = this.view;
    }
    
    public boolean Authenticate(String username, String password){
        
        view.txt_username.setText(username);
        view.txt_password.setText(password);
        
        System.out.println(username);
        System.out.println(password);
        
        return true;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
       
        //Login Button Click
        view.btn_login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Click Button");
                //Authenticate(view.txt_username.getText(), view.txt_password.getText());
            }
        });
        
    }
    
    
}
