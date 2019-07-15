package testcsv;


import java.nio.file.Path;
import java.util.List;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;



public class CSV_man implements CSV<Manusia>{
    
    
    @Override
    public void write(Path path, List<Manusia> items){
        try (PrintWriter writer = new PrintWriter(path.toString());){
            StringBuilder s = new StringBuilder();
            for(Manusia m : items){
                s.append(String.format("%s,%d,%f,%b\n",m.getNama(),m.getUmur(),m.getBerat(),m.getJenisKelamin()));
            }
      
            writer.write(s.toString());
            
        } catch (IOException e) {
            System.err.println("I/O exception occured when reading file");
        }
        
    }
    

    @Override
    public List<Manusia> read(Path path) {
        
        List<Manusia> manusia = new ArrayList<Manusia>();
        
        try(BufferedReader reader = new BufferedReader(new FileReader(path.toString()))){
            String baris;
            while((baris = reader.readLine()) != null){
                String[] man = baris.split(",");
                manusia.add(new Manusia(man[0],Integer.parseInt(man[1]),
                        Double.parseDouble(man[2]),Boolean.parseBoolean(man[3])));
            }
        } catch (IOException e) {
            System.err.println("I/O exception occured when reading file");
        }
        
        return manusia;
            
            
    }
}
