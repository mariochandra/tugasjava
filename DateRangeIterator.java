package tugasjava;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DateRangeIterator implements Iterator<LocalDate> {
    LocalDate pertama,terakhir,sekarang;
    
    public DateRangeIterator(LocalDate pertama, LocalDate terakhir){
        this.pertama = pertama;
        this.terakhir = terakhir;
        this.sekarang = pertama;
    }

    public boolean hasNext() {
        return sekarang.plusDays(1).isBefore(terakhir);
    }

    public LocalDate next() {
        if (!hasNext()) throw new NoSuchElementException();
        LocalDate now = this.sekarang;
        this.sekarang = this.sekarang.plusDays(1);
        return now;
    }
    
}
