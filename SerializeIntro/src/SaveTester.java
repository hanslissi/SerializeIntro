
import java.io.File;
import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author johannesriedmueller
 */
public class SaveTester {
    
    public static void main(String[] args) {
        SchuelerBL bl = new SchuelerBL();
        bl.add(new Schueler("Johannes", LocalDate.now()));
        bl.add(new Schueler("Jonny", LocalDate.now()));
        try{
        bl.save(new File("./klasse.csv"));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
