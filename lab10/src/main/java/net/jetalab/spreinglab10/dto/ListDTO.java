package net.jetalab.spreinglab10.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ListDTO {
    private int lastSeq = 0;
    private int size = 10;
    private int page = 1;

    public int getSkip() {
        return (page - 1) * size;
    }
}
