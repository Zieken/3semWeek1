/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Kasper Jeppesen
 */
public class Animal 
{
    int birthyear;
    String type, sound;
    
    public Animal(){}
    
    public Animal(int birthyear, String type, String sound)
    {
        this.birthyear = birthyear;
        this.type = type;
        this.sound = sound;
    }
}
