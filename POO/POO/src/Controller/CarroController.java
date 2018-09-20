/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CarroDAO;
import Model.CarroModel;
import java.util.ArrayList;

/**
 *
 * @author hique
 */
public class CarroController {

    public void GravarDAO(CarroModel c) {
        CarroDAO d = new CarroDAO();
        d.openToWrite("Carro");
        d.gravaCarro(c);
        d.closeAfterWrite();
    }

     public ArrayList<CarroModel> getItens(){
        ArrayList<CarroModel> c = new ArrayList<>();
        CarroDAO car = new CarroDAO();
        car.openToRead("Carro");
        c = car.retornaArrayCarro();
        car.closeAfterRead();
        return c;
    }
    public boolean removeCarro (String placa){
        boolean remove = false;
        ArrayList<CarroModel> c = new ArrayList<>();
        CarroDAO car = new CarroDAO();
        car.openToRead("Carro");
        c = car.retornaArrayCarro();
        car.closeAfterRead();
        
        for (int i = 0; i < c.size(); i++) {
            if(placa.compareToIgnoreCase(c.get(i).getPlaca()) == 0){
                c.remove(i);
                remove = true;
            }
        }
        if (remove == true){
            CarroDAO d = new CarroDAO();
            d.openToReWrite("Carro");
            for (int i = 0; i < c.size(); i++) {
                GravarDAO(c.get(i));
            }
            d.closeAfterWrite();
        }
        return remove;
    }
    public boolean removeCarroRG (String RG){
        boolean remove = false;
        ArrayList<CarroModel> c = new ArrayList<>();
        CarroDAO car = new CarroDAO();
        car.openToRead("Carro");
        c = car.retornaArrayCarro();
        car.closeAfterRead();
        
        for (int i = 0; i < c.size(); i++) {
            if(RG.compareToIgnoreCase(c.get(i).getRG()) == 0){
                c.remove(i);
                remove = true;
            }
        }
        if (remove == true){
            CarroDAO d = new CarroDAO();
            d.openToReWrite("Carro");
            for (int i = 0; i < c.size(); i++) {
                GravarDAO(c.get(i));
            }
            d.closeAfterWrite();
        }
        return remove;
    }
}
