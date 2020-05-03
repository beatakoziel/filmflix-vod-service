package com.filmflix.vodservice.db.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StreamingPlan {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String description;
}
