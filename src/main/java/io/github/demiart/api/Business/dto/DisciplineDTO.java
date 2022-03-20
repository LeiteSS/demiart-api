package io.github.demiart.api.Business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DisciplineDTO
{
    private Long id;

    @NotNull
    private String disciplineName;

    @NotNull
    private String disciplineDescription;

    @NotNull
    private String disciplineImgUrl;

    @NotNull
    private String disciplineCategory;
}
