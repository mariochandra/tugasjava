package tugasjava;
import java.time.LocalDate;
import java.util.Iterator;

public class DateRange implements Iterable<LocalDate> {
    
    LocalDate pertama , terakhir, now,sekarang;
        
    public DateRange(LocalDate pertama, LocalDate trakhir){
        this.pertama = pertama;
        this.terakhir = terakhir;  
        this.sekarang = pertama;
    }

    public Iterator<LocalDate> iterator() {
        return new DateRangeIterator(this.pertama,this.terakhir);
    }
    
    public boolean contains(LocalDate localdate){
        return (localdate.isAfter(pertama) && localdate.isBefore(terakhir)) || localdate.equals(pertama) || localdate.equals(terakhir);
    }
    
    public boolean overlap(DateRange daterange){
        return contains(daterange.pertama) || contains(daterange.terakhir) || (daterange.pertama.isBefore(this.pertama) && daterange.terakhir.isAfter(this.terakhir));
    }
        
}
