package chessApi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PlayerDTO {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String gender;
    private int age;
    private String experience;

}
