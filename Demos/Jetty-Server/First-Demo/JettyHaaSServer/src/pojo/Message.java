/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import com.google.gson.Gson;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Shall
 */
@XmlRootElement
public class Message {

    boolean result;
//    User user;

    public Message() {
    }

    public Message(boolean result) {
        this.result = result;
    }

//    public Message(boolean result, User user) {
//        this.result = result;
//        this.user = user;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String convertMessageIntoJson(Message message) {
        Gson gson = new Gson();
        return gson.toJson(message);
    }
}
