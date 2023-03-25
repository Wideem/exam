package chessApi.services;

import chessApi.entities.Player;
import chessApi.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void addPlayer(Player player) {
        this.playerRepository.saveAndFlush(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public void replacePlayerById(Long id, Player player) {
        if (!playerRepository.existsById(id)) {
            return;
        }
        player.setId(id);
        this.playerRepository.saveAndFlush(player);
    }

    public void editPlayerById(Long id, Player player) {
        Optional<Player> oldStudentOptional = playerRepository.findById(id);

        if (!oldStudentOptional.isPresent()) {
            return;
        }

        Player oldPlayer = oldStudentOptional.get();

        if (player.getName() != null && !oldPlayer.getName().equals(player.getName())){
            oldPlayer.setName(player.getName());
        }

        if (player.getLastName() != null && !oldPlayer.getLastName().equals(player.getLastName())){
            oldPlayer.setLastName(player.getLastName());
        }

        playerRepository.saveAndFlush(oldPlayer);
    }

    public Player getPlayerById(Long id) {
        Optional<Player> student = playerRepository.findById(id);

        if (!student.isPresent()) {
            return null;
        }

        return student.get();
    }




    private void addTestPlayers() {
        for (int i = 0; i < 10; i++) {
            Player player = new Player();
            player.setAge(10 * i + 1);
            player.setName("Vardas-" + i);
            player.setLastName("Pavarde-" + i);
            player.setEmail("vardas.pavarde" + i + "@gmail.com");
            player.setPersonCode(Long.valueOf("3234567890" + i));
            player.setStartDate(LocalDate.parse("201"+ i + "-0" + i + "-0" + i));
            this.playerRepository.saveAndFlush(player);
        }
    }

    public void loadTestData() {
        addTestPlayers();
    }



    public void printAllPlayers() {
        for (Player s : getAllPlayers()) {
            System.out.println(s);
        }
    }


}
