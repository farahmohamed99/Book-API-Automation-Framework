package models;

import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.annotation.Nullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode
@ToString(callSuper = true)
public class Book {
    private Integer id;
    @Nullable
    private String title;
    @Nullable
    private String description;
    private Integer pageCount;
    @Nullable
    private String excerpt;
    private String publishDate;
}
