package model;

public class Area {

    private String officeDirection;
    private Collaborator responsibleCollaborator;
    private String areaName;
    private String code;

    public Area(String officeDirection, Collaborator responsibleCollaborator, String areaName, String code) {
        this.officeDirection = officeDirection;
        this.responsibleCollaborator = responsibleCollaborator;
        this.areaName = areaName;
        this.code = code;
    }

    public String getOfficeDirection() {
        return officeDirection;
    }

    public void setOfficeDirection(String officeDirection) {
        this.officeDirection = officeDirection;
    }

    public Collaborator getResponsibleCollaborator() {
        return responsibleCollaborator;
    }

    public void setResponsibleCollaborator(Collaborator responsibleCollaborator) {
        this.responsibleCollaborator = responsibleCollaborator;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
