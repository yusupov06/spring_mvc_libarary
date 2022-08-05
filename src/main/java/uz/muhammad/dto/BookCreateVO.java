package uz.muhammad.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookCreateVO {

    private String title;
    private String author;
    private int pageCount;

}
