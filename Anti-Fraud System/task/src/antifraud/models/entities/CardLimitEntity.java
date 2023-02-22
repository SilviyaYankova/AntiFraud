package antifraud.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cards_limit")
public class CardLimitEntity {
    @Id
    @GeneratedValue
    Long id;
    @Column
    String number;
    @Column
    long allowed;
    @Column
    long manual;
}
