package shop.mtcoding.ajax.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.dynamic.TypeResolutionStrategy.Lazy;

@NoArgsConstructor
@Setter
@Getter
@Table(name = "tech_tb")
@Entity
public class Tech {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name; // Spring, Java, Javascript, React, HTML

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
}
