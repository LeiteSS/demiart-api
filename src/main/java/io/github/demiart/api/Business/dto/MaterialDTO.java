package io.github.demiart.api.Business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDTO
{
    private Long id;

    @NotNull
    private String materialName;

    @NotNull
    private String materialDescription;

    @NotNull
    private String materialImgUrl;

    @NotNull
    private String materialDownloadUrl;

    @NotNull
    private String materialType;

    private Long disciplineId;

}
