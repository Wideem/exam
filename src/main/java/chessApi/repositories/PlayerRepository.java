package chessApi.repositories;

import chessApi.entities.Player;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PlayerRepository extends JpaRepository<Player, Long> {

}
