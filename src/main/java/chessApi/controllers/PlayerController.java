package chessApi.controllers;

import chessApi.converters.PlayerConverter;
import chessApi.dto.AddPlayerDTO;
import chessApi.dto.PlayerDTO;
import chessApi.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<PlayerDTO> getAllPlayers() {
        return PlayerConverter.convertPlayerEntityListToDto(this.playerService.getAllPlayers());
    }

    @PostMapping
    public void addPlayer(@RequestBody AddPlayerDTO studentDTO){
        this.playerService.addPlayer(PlayerConverter.convertAddPlayerDtoToEntity(studentDTO));
    }

    @DeleteMapping("/{id}")
    public void deletePlayerById(@PathVariable Long id){
        this.playerService.deletePlayerById(id);
    }

    @GetMapping("/{id}")
    public AddPlayerDTO getPlayerById(@PathVariable Long id) {
        return PlayerConverter.convertAddPlayerEntityToDto(this.playerService.getPlayerById(id));
    }

    @PatchMapping("/{id}")
    public void editStudentById(@PathVariable Long id, @RequestBody AddPlayerDTO studentDTO) {
        this.playerService.editPlayerById(id, PlayerConverter.convertAddPlayerDtoToEntity(studentDTO));
    }

    @PutMapping("/{id}")
    public void replaceStudentById(@PathVariable Long id, @RequestBody AddPlayerDTO studentDTO) {
        this.playerService.replacePlayerById(id, PlayerConverter.convertAddPlayerDtoToEntity(studentDTO));
    }

}
