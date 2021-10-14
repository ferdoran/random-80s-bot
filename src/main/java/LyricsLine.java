import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LyricsLine {
    @CsvBindByName
    private String artist;
    @CsvBindByName
    private String song;
    @CsvBindByName
    private String line;
}
