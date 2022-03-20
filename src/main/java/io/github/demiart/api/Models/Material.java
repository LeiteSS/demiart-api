package io.github.demiart.api.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "material_tb")
public class Material
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_id")
    private Long id;

    @Column(name = "material_name")
    private String materialName;

    @Column(name = "material_description")
    private String materialDescription;

    @Column(name = "material_img_url")
    private String materialImgUrl;

    @Column(name = "material_download_url")
    private String materialDownloadUrl;

    @Column(name = "id_discipline")
    private Long disciplineId;
}
