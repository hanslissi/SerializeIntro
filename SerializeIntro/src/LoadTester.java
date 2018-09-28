
import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author johannesriedmueller
 */
public class LoadTester {

    public static void main(String[] args) {
        SchuelerBL bl = new SchuelerBL();

        try {
            bl.load(new File("./klasse.ser"));
            for (int i = 0; i < bl.getSize(); i++) {
                System.out.println(bl.getElementAt(i).getName()+" "+bl.getElementAt(i).getBirthday().toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
    }
}
