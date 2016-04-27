/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.DatabaseConnection;
import pojo.Medicine;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shall
 */
public class MedicineDAO {

    Connection databaseConnection;

    public MedicineDAO() {
        databaseConnection = DatabaseConnection.initDatabaseConnection();
    }

    public boolean AddMedicine(Medicine medicine) {
        if (!isMedicineExists(medicine)) {
            InputStream inputStream = null;
            String query = "insert into medicines (medicine_name,medicine_image,medicine_dose,medicine_type,medicine_date,medicine_time,medicine_repititions,user_email) values(?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);

                preparedStatement.setString(1, medicine.getMedicineName());
                preparedStatement.setBlob(2, inputStream);
                preparedStatement.setInt(3, medicine.getMedicineDose());
                preparedStatement.setString(4, medicine.getMedicineType());
                preparedStatement.setString(5, medicine.getMedicineDate());
                preparedStatement.setString(6, medicine.getMedicineTime());
                preparedStatement.setInt(7, medicine.getMedicineRepition());
                preparedStatement.setString(8, medicine.getUserEmail());

                int result = preparedStatement.executeUpdate();
                System.out.println(result);
                if (result > 0) {
                    preparedStatement.close();
                    //databaseConnection.close();
                    System.out.println("success adding Medicine");
                    return true;
                } else {
                    preparedStatement.close();
                    //databaseConnection.close();
                    System.out.println("failed to add Medicine");
                    return false;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return false;
    }

    public boolean AddUserMedicine(Medicine medicine) {
        if (!isMedicineExists(medicine)) {
            String image = medicine.getMedicineImage();
            InputStream inputStream = null;
            if (image != null) {

                try {
                    inputStream = new ByteArrayInputStream(image.getBytes("utf-8"));
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(MedicineDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            String query = "insert into medicines (medicine_name,medicine_image,medicine_dose,medicine_type,medicine_date,medicine_time,medicine_repititions,user_email) values(?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);

                preparedStatement.setString(1, medicine.getMedicineName());
                preparedStatement.setBlob(2, inputStream);
                preparedStatement.setInt(3, medicine.getMedicineDose());
                preparedStatement.setString(4, medicine.getMedicineType());
                preparedStatement.setString(5, medicine.getMedicineDate());
                preparedStatement.setString(6, medicine.getMedicineTime());
                preparedStatement.setInt(7, medicine.getMedicineRepition());
                preparedStatement.setString(8, medicine.getUserEmail());

                int result = preparedStatement.executeUpdate();
                System.out.println(result);
                if (result > 0) {
                    preparedStatement.close();
                    //databaseConnection.close();
                    System.out.println("success adding Medicine");
                    return true;
                } else {
                    preparedStatement.close();
                    //databaseConnection.close();
                    System.out.println("failed to add Medicine");
                    return false;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return false;
    }

    public boolean AddMedicines(ArrayList<Medicine> medicines) {
        for (Medicine medicine : medicines) {
            if (!isMedicineExists(medicine)) {
                String image = medicine.getMedicineImage();
                InputStream inputStream = null;
                try {
                    inputStream = new ByteArrayInputStream(image.getBytes("utf-8"));
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(MedicineDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                String query = "insert into medicines (medicine_name,medicine_image,medicine_dose,medicine_type,medicine_date,medicine_time,medicine_repititions,user_email) values(?,?,?,?,?,?,?,?)";
                try {
                    PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);

                    preparedStatement.setString(1, medicine.getMedicineName());
                    preparedStatement.setBlob(2, inputStream);
                    preparedStatement.setInt(3, medicine.getMedicineDose());
                    preparedStatement.setString(4, medicine.getMedicineType());
                    preparedStatement.setString(5, medicine.getMedicineDate());
                    preparedStatement.setString(6, medicine.getMedicineTime());
                    preparedStatement.setInt(7, medicine.getMedicineRepition());
                    preparedStatement.setString(8, medicine.getUserEmail());

                    int result = preparedStatement.executeUpdate();
                    System.out.println(result);
                    if (result > 0) {
                        preparedStatement.close();
                        //databaseConnection.close();
                        System.out.println("success adding Medicine");
                        return true;
                    } else {
                        preparedStatement.close();
                        //databaseConnection.close();
                        System.out.println("failed to add Medicine");
                        return false;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    public boolean deleteAllMedicines() {
        ArrayList<Medicine> medicines = getAllMedicines();
        if (medicines.isEmpty()) {
            return true;
        } else {

            PreparedStatement preparedStatement;
            try {
                String query = "DELETE FROM medicines ";
                preparedStatement = databaseConnection.prepareStatement(query);

                int rowsNum = preparedStatement.executeUpdate();

                if (rowsNum > 0) {
                    System.out.println(rowsNum + " Medicines deleted");
                    return true;
                } else {
                    System.out.println("Couldn't delete Medicines");
                    return false;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    public ArrayList<Medicine> getAllMedicines() {
        ArrayList<Medicine> medicines = new ArrayList<>();
        String query = "select * from medicines";
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Blob blob = resultSet.getBlob("medicine_image");
                int blobLength = (int) blob.length();
                byte[] image = blob.getBytes(1, blobLength);
                String imageString = new String(image, "utf-8");
                blob.free();
                Medicine medicine = new Medicine();
                medicine.setMedicineId(resultSet.getInt("medicine_id"));
                medicine.setMedicineName(resultSet.getString("medicine_name"));
                medicine.setMedicineImage(imageString);
                medicine.setMedicineDose(resultSet.getInt("medicine_dose"));
                medicine.setMedicineDate(resultSet.getString("medicine_date"));
                medicine.setMedicineRepition(resultSet.getInt("medicine_repititions"));
                medicine.setMedicineDate(resultSet.getString("medicine_date"));
                medicine.setMedicineTime(resultSet.getString("medicine_time"));
                medicine.setUserEmail(resultSet.getString("user_email"));
                medicines.add(medicine);
            }
            System.out.println("Number of users: " + medicines.size());
            preparedStatement.close();
            //databaseConnection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicines;
    }

    //--------------------------------------------------------------------------------
    public ArrayList<Medicine> getUserMedicines(String userEmail) {
        ArrayList<Medicine> medicines = new ArrayList<>();
        String query = "select * from medicines where user_email=?";
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
            preparedStatement.setString(1, userEmail);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Medicine medicine = new Medicine();
                medicine.setMedicineId(resultSet.getInt("medicine_id"));
                medicine.setMedicineName(resultSet.getString("medicine_name"));
                medicine.setMedicineImage(null);
                medicine.setMedicineDose(resultSet.getInt("medicine_dose"));
                medicine.setMedicineType(resultSet.getString("medicine_type"));
                medicine.setMedicineRepition(resultSet.getInt("medicine_repititions"));
                medicine.setMedicineDate(resultSet.getString("medicine_date"));
                medicine.setMedicineTime(resultSet.getString("medicine_time"));
                medicine.setUserEmail(resultSet.getString("user_email"));
                medicines.add(medicine);
            }
            System.out.println("Number of users: " + medicines.size());
            preparedStatement.close();
            //databaseConnection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicines;
    }
    //--------------------------------------------------------------------------------

    public ArrayList<Medicine> getAllUsersMedicines(String userEmail) {
        ArrayList<Medicine> medicines = new ArrayList<>();
        String query = "select * from medicines where user_email=?";
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
            preparedStatement.setString(1, userEmail);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Blob blob = resultSet.getBlob("medicine_image");
                int blobLength = (int) blob.length();
                byte[] image = blob.getBytes(1, blobLength);
                String imageString = new String(image, "utf-8");
                blob.free();
                Medicine medicine = new Medicine();
                medicine.setMedicineId(resultSet.getInt("medicine_id"));
                medicine.setMedicineName(resultSet.getString("medicine_name"));
                medicine.setMedicineImage(imageString);
                medicine.setMedicineDose(resultSet.getInt("medicine_dose"));
                medicine.setMedicineType(resultSet.getString("medicine_type"));
                medicine.setMedicineRepition(resultSet.getInt("medicine_repititions"));
                medicine.setMedicineDate(resultSet.getString("medicine_date"));
                medicine.setMedicineTime(resultSet.getString("medicine_time"));
                medicine.setUserEmail(resultSet.getString("user_email"));
                medicines.add(medicine);
            }
            System.out.println("Number of users: " + medicines.size());
            preparedStatement.close();
            //databaseConnection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicines;
    }

    //-----------------------------------------------------------------------------------
    //      This method checks if there is a medicine with the same name and type
    //-----------------------------------------------------------------------------------
    public boolean isMedicineExists(Medicine medicine) {
        String query = "select * from medicines where medicine_name=? and medicine_type=? and user_email=?";
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
            preparedStatement.setString(1, medicine.getMedicineName());
            preparedStatement.setString(2, medicine.getMedicineType());
            preparedStatement.setString(3, medicine.getUserEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                preparedStatement.close();
                //databaseConnection.close();
                System.out.println("Medicine Already Exists");
                return true;

            } else {
                preparedStatement.close();
                //databaseConnection.close();
                System.out.println("Medicine Doesn't Exist");
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
