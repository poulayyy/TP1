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
public class Degre3 extends Fichier{
    private double _teta1;
    private double _teta2;
    private double _teta3;
    private double _a;
    private double _b;
    private double _c;
    private double _d;
    public Degre3(String nomFichier, int degreFichier){
        _nomFichier = nomFichier;
        _degreFichier = degreFichier;
        
        
    }
    
  
    
    @Override
    protected void InitialiserVariables(int y, double premierX){
        double tetaI = _listeValeures[y+1] - _listeValeures[y];
        double tetaI1 = _listeValeures[y+2] - _listeValeures[y+1];
        double tetaI2 = _listeValeures[y+3] - _listeValeures[y+2];
        _teta1 = tetaI;
        _teta2 = tetaI1 - _teta1;
        double teta2I1 = tetaI2 - tetaI1;
        _teta3 = teta2I1 - _teta2;
        _a = _teta3 / (6 * Math.pow(_distance, 3));
        _b = (_teta2 / (2 * Math.pow(_distance,2))) - 
                _a *(premierX + (premierX + (_distance * 1)) + (premierX + (_distance * 2)));
        _c = (_teta1 / _distance)-(_b*(premierX + (premierX + (_distance * 1))))-(_a * (Math.pow(premierX, 2) + (premierX * (premierX + (_distance *1))) + Math.pow((premierX + (_distance * 1)), 2)));
        _d = _listeValeures[y] - (_c * premierX) - (_b * Math.pow(premierX,2)) - (_a * Math.pow(premierX, 3));
    }
     @Override
    protected double ExecutePolynome(double entree){
        return (_a * Math.pow(entree, 3)) + (_b * Math.pow(entree, 2)) + (_c * entree) + _d;
    }
    
}
