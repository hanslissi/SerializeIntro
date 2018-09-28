
import java.io.File;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author johannesriedmueller
 */
public class SchuelerBL {
    ArrayList<Schueler> klasse = new ArrayList<>();
    
    public void add(Schueler s){
        klasse.add(s);
    }
    
    public void save(File f) throws Exception{
        
    }
    
    public void load(File f) throws Exception{
        
    }
}
