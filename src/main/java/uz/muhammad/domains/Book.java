package uz.muhammad.domains;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Book implements Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false)
    private String title;

    private String author;

    private int pageCount;

    @Column(columnDefinition = " bool default false")
    private boolean deleted;
}
