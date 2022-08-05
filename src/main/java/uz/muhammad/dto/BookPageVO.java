package uz.muhammad.dto;

import lombok.*;
import uz.muhammad.domains.Book;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BookPageVO {
    private long currentPage;
    private long totalPages;
    private List<Book> books;
    private boolean hasPrevious;
    private boolean hasNext;
    private long previous;
    private long next;
}
