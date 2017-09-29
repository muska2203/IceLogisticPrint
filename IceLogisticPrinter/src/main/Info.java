package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Info {
    private String name;
    private String carNumber;
    private String car;
    private int number;

    public Info(String name, String carNumber, double number, String car) {
        this.name = this.initName(name);
        this.carNumber = carNumber;
        this.number = (int)Math.round(number);
        if(car!=null){
            this.car = car;
        } else {
            this.car = "";
        }
    }

    public String getName() {
        return name;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public int getNumber() {
        return number;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }
    
    private String initName(String name) {
        String first = name.substring(0,name.indexOf(' '));
        name = name.substring(name.indexOf(' ')+1);
        String second = name.substring(0,1)+".";
        name = name.substring(name.indexOf(' ')+1);
        String third = name.substring(0,1)+".";
        return first+" "+second+" "+ third;
    }
    
}
