/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.UserModel;
import View.LoginGUI;
import View.MainMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josieldelgadillo
 */
public class InitLoginController implements ActionListener {
    
    UserModel model;
    LoginGUI view;
    MainMenuView mainView;
    InitLoginController ctlr;
    final String path = System.getProperty("user.dir") + "/src/Data/";
   
    public InitLoginController(){}
    
    public InitLoginController(UserModel model, LoginGUI view){
        this.model = model;
        this.view = view;
        ctlr = new InitLoginController();
        
        view.setVisible(true);
        
        initViewComponents(view);
        
    }
    
    public boolean Authenticate(String username, String password){
        
        HashMap<String, String> userCredentials = new HashMap<String, String>();
        Boolean auth = false;
        
        //Get user list
        try {
          File file = new File(path + "db.txt");
          Scanner myReader = new Scanner(file);
          while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] creds = data.split(",");
            userCredentials.put(creds[0], creds[1]);
          }
          myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        
        
        //Compare Login attempt
        for(Map.Entry<String, String> cred : userCredentials.entrySet()) {
            String u = cred.getKey();
            String p = cred.getValue();

            // Compare username and password
            if(!auth){
                if(username.equals(cred.getKey())){
                    if(password.equals(cred.getValue())){
                        auth = true;
                    }
                    else{
                        auth = false;
                    }
                }            
            }  
        }
        
        
        return auth;
    }
    
    public void createUser(String username, String password){
        
        //Get relative path
         //String path = System.getProperty("user.dir") + "/src/Data/";
        
        //Create File
        File file = new File(path + "db.txt");
        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(InitLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Write to File - create account
        try {
            FileWriter myWriter = new FileWriter(path + "db.txt",true);
            myWriter.write(username + "," + password + ";" + System.getProperty( "line.separator" ));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }
    
    public void initViewComponents(LoginGUI view){
        
        view.btn_login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Authenticate user
                if(ctlr.Authenticate(view.txt_username.getText(), view.txt_password.getText())){
                    view.setVisible(false);
                    mainView = new MainMenuView();
                    mainView.setVisible(true);
                }
                else{
                    view.lbl_feedback.setText("Incorrect Credentials");
                    System.out.println("Incorrect Credentials");
                }
                //System.out.println(ctlr.Authenticate(view.txt_username.getText(), view.txt_password.getText()));
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
