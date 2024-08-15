package hackathon.hackathon.dto;

import lombok.*;

@AllArgsConstructor
@Getter
public class QuestResponseDto {
    private String name;

    private String content;

    private int exp;

    private String place;
}
