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
public abstract class Fichier {
    
    protected String _nomFichier;
    protected int _degreFichier;
    protected double _distance; 
    protected double _premiereValeure;
    protected double [] _listeValeures;
    
    protected final double H1 = 0.25;
    protected final double H2 = 0.50;
    protected final double H3 = 0.75;
    
    protected double [] _listeTroisPoints = new double [3];

    protected abstract void InitialiserVariables(int y, double premierX); 
    protected abstract double ExecutePolynome(double entree); 

    public void Process(){
        InitialiserFichier();
        Calcul();
    }
    
    public void InitialiserFichier(){
        try {
            FileReader fr = new FileReader(_nomFichier);
            BufferedReader fichier = new BufferedReader(fr);
            Scanner scanFichier = new Scanner(fichier);
            scanFichier.useLocale( Locale.CANADA );
            //Le degre est deja defini
            scanFichier.next();
            
            //Lecture de _distance
            if( scanFichier.hasNextDouble() ) {
                _distance = scanFichier.nextDouble();
            }
            //Lecture de _premiereValeure
            if( scanFichier.hasNextDouble() ) {
                _premiereValeure = scanFichier.nextDouble();
            }
            //initialiser la tableau de liste des valeures();
            InitialiserTableauValeures();
            //Lecture du reste du fichier
            for(int i = 0; scanFichier.hasNextDouble(); i++){
                _listeValeures[i] = scanFichier.nextDouble();
            }           
            scanFichier.close();
            } catch ( FileNotFoundException e ) {
             // Traitement d'erreur ici.
            }catch(Exception e){
                System.out.println(e);
                
            }
        
    }
    
    protected void InitialiserListeTroisPoints(double premiereValeure){
        _listeTroisPoints[0] = premiereValeure + (H1 * _distance);
        _listeTroisPoints[1] = premiereValeure + (H2 * _distance);
        _listeTroisPoints[2] = premiereValeure + (H3 * _distance);
        
    }
    
    private void InitialiserTableauValeures(){
        try {
            FileReader fr = new FileReader(_nomFichier);
            BufferedReader fichier = new BufferedReader(fr);
            Scanner scanFichier = new Scanner(fichier);
            scanFichier.useLocale( Locale.CANADA );
            
            int nbLigne = 0;
            while (scanFichier.hasNextDouble()) {
                nbLigne++;
                scanFichier.nextDouble();
            }         
            scanFichier.close();
            
            _listeValeures = new double [nbLigne - 3];
            } catch ( FileNotFoundException e ) {
             // Traitement d'erreur ici.
            }catch(Exception e){
                System.out.println(e);
                
            }
    }
    
    private void Calcul(){
        double premierX;
        System.out.println(ExecutePolynome(_premiereValeure));
        for(int i = 0; i <= _listeValeures.length - _degreFichier - 1; i++){
            premierX = _premiereValeure + (i  * _distance);
            InitialiserVariables(i,premierX);
            InitialiserListeTroisPoints(premierX);
            for(int j = 0; j < _listeTroisPoints.length; j++){
                System.out.println(ExecutePolynome(_listeTroisPoints[j]));
            }
            System.out.println(ExecutePolynome(premierX + _distance));
            
        }
    }
    
}
