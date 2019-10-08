/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reechantillonnage;

/**
 *
 * @author willi
 */
public class Degre2 extends Fichier{
    private double _teta;
    private double _a;
    private double _b;
    public Degre2(String nomFichier, int degreFichier){
        _nomFichier = nomFichier;
        _degreFichier = degreFichier;
        
    }
    
    @Override
    protected void InitialiserVariables(int y, double premierX){
        
    }
     @Override
    protected double ExecutePolynome(double entree){
        return (_a * entree) + _b;
    }
    
}
