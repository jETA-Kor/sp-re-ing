package net.jetalab.spreinglab09.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoardDTO {
    private int seq;
    private String title;
    private String contents;
    private String author;
    private String password;
    private int reads = 0;
    private String deleted = "N";
}