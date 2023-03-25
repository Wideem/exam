package chessApi;

import chessApi.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class ChessApi {

    @Autowired
    private PlayerService playerService;

    public static void main(String[] args) {
        SpringApplication.run(ChessApi.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        this.playerService.loadTestData();
        tests();
    }

    public void tests() {
        System.out.println("--------------------------------------");
        System.out.println("TEST: printAllStudents");
        this.playerService.printAllPlayers();
        System.out.println("--------------------------------------");
    }
}
