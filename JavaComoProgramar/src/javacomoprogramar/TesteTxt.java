/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javacomoprogramar;

import java.io.FileNotFoundException;
import java.util.Formatter;

/**
 *
 * @author renan.souza
 */
public class TesteTxt {
    public static void main(String[] args) throws FileNotFoundException {
        Formatter output = new Formatter("Teste.txt");
        
        output.format("%s", "Lá vai bomba....");
        
        output.close();
    }
}
