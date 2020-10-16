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
    InitLoginController ctlr;
   
    public InitLoginController(){}
    
    public InitLoginController(UserModel model, LoginGUI view){
        this.model = model;
        this.view = view;
        ctlr = new InitLoginController();
        
        view.setVisible(true);
        
        initViewComponents(view);
        
    }
    
    public boolean Authenticate(String username, String password){
        
        System.out.println(username);
        System.out.println(password);
        
        return true;
    }
    
    public void initViewComponents(LoginGUI view){
        
        view.btn_login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ctlr.Authenticate(view.txt_username.getText(), view.txt_password.getText());
            }
        });
    
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
