/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reechantillonnage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author willi
 */
public class ReEchantillonnage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String _nomFichier = LireNomFichier();
        int _degreFichier = LireDegreFichier(_nomFichier);
        
        switch(_degreFichier){
                case 1:
                    new Degre1(_nomFichier, _degreFichier).Process();
                    break;
                case 2:
                    new Degre2(_nomFichier, _degreFichier).Process();
                    break;
                case 3: 
                    new Degre3(_nomFichier, _degreFichier).Process();
                    break;
                default:
                    break;
            }   
    }
    
    public static String LireNomFichier(){
        Scanner scanEntree = new Scanner(System.in);
        System.out.println("Entrez le nom du fichier:" );
        return scanEntree.next();
    }
    
    public static int LireDegreFichier(String nomFichier){
        int degre = 0;
        try {
            FileReader fr = new FileReader(nomFichier);
            BufferedReader fichier = new BufferedReader(fr);
            Scanner _scanFichier = new Scanner(fichier);
            _scanFichier.useLocale( Locale.CANADA );
            //Lecture du degreFichier
            if( _scanFichier.hasNextInt() ) {
                degre = _scanFichier.nextInt();
            }
            _scanFichier.close();
            
            } catch ( FileNotFoundException e ) {
                System.out.println(e);
            }catch(Exception e){
                System.out.println(e);
                
            }
        return degre;
        
    }
}
