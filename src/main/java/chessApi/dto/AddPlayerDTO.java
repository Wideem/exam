package chessApi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class AddPlayerDTO {
    private Long id;
    private String name;
    private String lastname;

    private String email;
    private Long personCode;
    private LocalDate startDate;

}
