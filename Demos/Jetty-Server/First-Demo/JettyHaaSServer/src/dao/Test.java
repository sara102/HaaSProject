package dao;


import pojo.Medicine;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Shall
 */
public class Test {

    public static void main(String[] args) {
        try {
            byte[]image = extractBytes("C:\\img\\islamic.jpg");
            String imageString = new String(image);
            byte[]img = imageString.getBytes();
//            User user = new User( "shall@gmail.com", "shall");
            Medicine medicine = new Medicine("Third Medicine", 5, "Tablets", "22/4/2016", "2:29", 4, "said@gmail.com");
            
            UserDAO userDAO = new UserDAO();
            MedicineDAO medicineDAO = new MedicineDAO();
//            System.out.println(medicineDAO.AddMedicine(medicine));
//            userDAO.AddUser(user)?System.out.println("Success"):System.out.println("Failed");
//            System.out.println(userDAO.loginUser(new User("shall@gmail.com","shall")));
//           System.out.println(medicine.convertMedicinesIntoJson(medicineDAO.getUserMedicines("said@gmail.com")));
            System.out.println(medicineDAO.AddMedicine(medicine));
            
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static byte[]  extractBytes(String ImageName) throws IOException {
        // open image
        File imgPath = new File(ImageName);
        BufferedImage bufferedImage = ImageIO.read(imgPath);

        // get DataBufferBytes from Raster
        WritableRaster raster = bufferedImage.getRaster();
        DataBufferByte data = (DataBufferByte) raster.getDataBuffer();

        return (data.getData());
    }
}
