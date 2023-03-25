package chessApi.converters;

import chessApi.dto.AddPlayerDTO;
import chessApi.dto.PlayerDTO;
import chessApi.entities.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class PlayerConverter {




    /**
     * Converts AddPlayerDTO to Player entity
     *
     * @param playerDTO
     * @return Player
     */
    public static Player convertAddPlayerDtoToEntity(AddPlayerDTO playerDTO) {

        Player player = null;
        if (playerDTO != null) {
            player = new Player();
            player.setName(playerDTO.getName());
            player.setLastName(playerDTO.getLastname());
            player.setEmail(playerDTO.getEmail());
            player.setPersonCode(playerDTO.getPersonCode());
            player.setStartDate(playerDTO.getStartDate());
        }
        return player;
    }
    /**
     * Converts Player entity to AddPlayerDTO
     *
     * @param player
     * @return AddPlayerDTO
     */
    public static AddPlayerDTO convertAddPlayerEntityToDto(Player player) {
        AddPlayerDTO playerDTO = null;
        if (player != null) {
            playerDTO = new AddPlayerDTO();
            playerDTO.setId(player.getId());
            playerDTO.setName(player.getName());
            playerDTO.setLastname(player.getLastName());
            playerDTO.setEmail(player.getEmail());
            playerDTO.setPersonCode(player.getPersonCode());
            playerDTO.setStartDate(player.getStartDate());
        }
        return playerDTO;
    }

    /**
     * Converts Player entity to PlayerDTO
     *
     * @param player
     * @return PlayerDTO
     */
    public static List<PlayerDTO> convertPlayerEntityListToDto(List<Player> playerList) {
        List<PlayerDTO> playerDTOList = null;
        for (Player s : playerList) {
            if (playerDTOList == null) {
                playerDTOList = new ArrayList<>();
            }
            playerDTOList.add(PlayerConverter.convertPlayerEntityToDto(s));
        }
        return playerDTOList;
    }

    private static PlayerDTO convertPlayerEntityToDto(Player player) {
        PlayerDTO playerDTO = null;
        if (player != null) {
            playerDTO = new PlayerDTO();
            playerDTO.setId(player.getId());
            playerDTO.setName(player.getName());
            playerDTO.setLastname(player.getLastName());
            playerDTO.setEmail(player.getEmail());
            playerDTO.setAge(Utils.calculateAge(player.getPersonCode()));
            playerDTO.setGender(Utils.calculateGender(player.getPersonCode()));
            playerDTO.setExperience(Utils.calculateExperience(player.getStartDate()));
        }
        return playerDTO;
    }


}
