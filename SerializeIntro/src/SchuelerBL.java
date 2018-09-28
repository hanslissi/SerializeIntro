
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author johannesriedmueller
 */
public class SchuelerBL extends AbstractListModel<Schueler>{
    ArrayList<Schueler> klasse = new ArrayList<>();
    
    public void add(Schueler s){
        klasse.add(s);
        fireIntervalAdded(klasse, klasse.size()-1, klasse.size()-1);
    }
    
    public void save(File f) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        for (Schueler schueler : klasse) {
            oos.writeObject(schueler);
        }
        oos.flush();
        oos.close();
    }
    
    public void load(File f) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        try {
            Object obj;
            while ((obj = ois.readObject()) != null) {
                if (obj instanceof Schueler) {
                    add((Schueler) obj);
                }
            }
        } catch (EOFException eOFException) {
            //only to determine the end of file
        } 
        ois.close();
    }

    

    @Override
    public int getSize() {
        return klasse.size();
    }

    @Override
    public Schueler getElementAt(int index) {
        return klasse.get(index);
    }
}
