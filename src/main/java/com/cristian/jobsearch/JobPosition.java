package com.cristian.jobsearch;

import lombok.Data;

import com.google.gson.annotations.SerializedName;

@Data
public class JobPosition {

    private String id;

    private String type;

    private String url;

    @SerializedName(("created_at"))
    private String createdAt;

    private String company;

    @SerializedName("company_url")
    private String companyUrl;

    private String title;

    private String location;

    private String description;

    @SerializedName("company_logo")
    private String companyLogo;

    //No se agregan ni los getter o setter ni tampoco los siguientes
    // métodos porque se ha agregado @Data de lombok

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        JobPosition that = (JobPosition) o;
//        return Objects.equals(id, that.id) && Objects.equals(type, that.type) && Objects.equals(url, that.url) && Objects.equals(createdAt, that.createdAt) && Objects.equals(company, that.company) && Objects.equals(companyUrl, that.companyUrl) && Objects.equals(title, that.title) && Objects.equals(location, that.location) && Objects.equals(description, that.description) && Objects.equals(companyLogo, that.companyLogo);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, type, url, createdAt, company, companyUrl, title, location, description, companyLogo);
//    }
//
//    @Override
//    public String toString() {
//        return "JobPosition{" +
//                "id='" + id + '\'' +
//                ", type='" + type + '\'' +
//                ", url='" + url + '\'' +
//                ", createdAt='" + createdAt + '\'' +
//                ", company='" + company + '\'' +
//                ", companyUrl='" + companyUrl + '\'' +
//                ", title='" + title + '\'' +
//                ", location='" + location + '\'' +
//                ", description='" + description + '\'' +
//                ", companyLogo='" + companyLogo + '\'' +
//                '}';
//    }
}
