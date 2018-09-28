
import com.sun.corba.se.impl.io.IIOPOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
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
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        for (Schueler schueler : klasse) {
            bw.write(schueler.getName());
            bw.write(";");
            bw.write(schueler.getBirthday().toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    
    public void load(File f) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line;
        while((line=br.readLine())!=null){
            String data[] = line.split(";");
            add(new Schueler(data[0],LocalDate.parse(data[1])));
        }
        fireIntervalAdded(klasse, 0, klasse.size()-1);
        
    }
    
    public void saveSerialize(File f) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        for (Schueler schueler : klasse) {
            oos.writeObject(schueler);
        }
        oos.flush();
        oos.close();
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
