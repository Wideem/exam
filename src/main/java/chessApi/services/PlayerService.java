package chessApi.services;

import chessApi.entities.Player;
import chessApi.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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
        for (int i = 1; i < 10; i++) {
            Player player = new Player();
            player.setAge(10 * i + 1);
            player.setName("Vardas-" + i);
            player.setLastName("Pavarde-" + i);
            player.setEmail("vardas.pavarde" + i + "@gmail.com");
            player.setPersonCode(Long.valueOf(generateRandomPersonalCode()));
            player.setStartDate(LocalDate.parse("201"+ i + "-0" + i + "-0" + i));
            this.playerRepository.saveAndFlush(player);
        }
    }

    private static String generateRandomPersonalCode() {
        
        Random rand = new Random();
        int gender = rand.nextInt(2) + 3;

        int birthYear = rand.nextInt(100); 
        int birthMonth = rand.nextInt(12) + 1; 
        int maxDays = LocalDate.of(1900 + birthYear, birthMonth, 1).lengthOfMonth(); 
        int birthDay = rand.nextInt(maxDays) + 1; 

        int randomNum = rand.nextInt(899) + 100; 

        String genderStr = String.valueOf(gender); 
        String yearStr = String.format("%02d", birthYear); 
        String monthStr = String.format("%02d", birthMonth); 
        String dayStr = String.format("%02d", birthDay); 
        String randomStr = String.valueOf(randomNum); 
        String personalCode = genderStr + yearStr + monthStr + dayStr + randomStr;

        return personalCode;
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
