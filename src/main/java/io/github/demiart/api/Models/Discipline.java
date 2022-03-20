package io.github.demiart.api.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "discipline_tb")
public class Discipline
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discipline_id")
    private Long id;

    @Column(name = "discipline_name", nullable = false)
    private String disciplineName;

    @Column(name = "discipline_description", nullable = false)
    private String disciplineDescription;

    @Column(name = "discipline_img_url", nullable = false)
    private String disciplineImgUrl;

    @Column(name = "discipline_category", nullable = false)
    private String disciplineCategory;
}
