
import java.io.File;
import java.time.LocalDate;
import java.time.Month;

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
        bl.add(new Schueler("Johannes", LocalDate.of(2002, Month.JUNE, 8)));
        bl.add(new Schueler("Jonny", LocalDate.of(2002, Month.AUGUST, 19)));
        try{
        bl.save(new File("./klasse.ser"));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
