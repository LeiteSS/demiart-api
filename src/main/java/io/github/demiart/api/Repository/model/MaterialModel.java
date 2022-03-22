package io.github.demiart.api.Repository.model;

public interface MaterialModel
{
    Long getmaterial_id();
    String getmaterial_name();
    String getmaterial_description();
    String getmaterial_img_url();
    String getmaterial_download_url();
    //Long getdiscipline_id();
    String getmaterial_type();
}
