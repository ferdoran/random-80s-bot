import com.opencsv.bean.CsvToBeanBuilder;
import com.slack.api.bolt.App;
import com.slack.api.bolt.jetty.SlackAppServer;
import com.slack.api.model.event.Event;

import java.io.FileReader;
import java.util.List;
import java.util.Random;

public class Random80sBot {
    public static void main(String[] args) throws Exception {
        final Random rand = new Random();
        final List<LyricsLine> lines = new CsvToBeanBuilder<LyricsLine>(new FileReader("src/main/resources/lines.csv"))
                .withType(LyricsLine.class)
                .build()
                .parse();

        final App app = new App();

        app.command("/hello", (req, ctx) -> {
                final LyricsLine line = lines.get(rand.nextInt(lines.size()));
                return ctx.ack(String.format("%s -- by %s - %s", line.getLine(), line.getArtist(), line.getSong()));
            }
        );

        final SlackAppServer server = new SlackAppServer(app);
        server.start();
    }
}
