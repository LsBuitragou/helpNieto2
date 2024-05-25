package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.lang.Math;

public class Application implements Calculable {

    private Calendar registerDate;
    private String issue;
    private String description;
    private String nameOfResponsible;
    private String applicantName;
    private Area area;
    private Status status;
    private Calendar clasificationDate;

    public Application(String issue, String description, String nameOfResponsible,
            String applicantName, Area area) {
        registerDate = Calendar.getInstance();
        this.issue = issue;
        this.description = description;
        this.nameOfResponsible = nameOfResponsible;
        this.applicantName = applicantName;
        this.area = area;
        status = Status.PENDANT;
        clasificationDate = Calendar.getInstance();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNameOfResponsible() {
        return nameOfResponsible;
    }

    public void setNameOfResponsible(String nameOfResponsible) {
        this.nameOfResponsible = nameOfResponsible;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Calendar getRegisterDate() {
        return registerDate;
    }

    public Calendar getClasificationDate() {
        return clasificationDate;
    }

    public void setClasificationDate(Calendar clasificationDate) {
        this.clasificationDate = clasificationDate;
    }

    @Override
    public String toString() {
        String msg = "";
        msg += "\nASUNTO: " + issue;
        msg += "\nDESCRIPCIÓN: " + description;
        msg += "\nNOMBRE DE RESPONSABLE: " + nameOfResponsible;
        msg += "\nNOMBRE DE SOLICITANTE: " + applicantName;
        msg += "\nAREA: " + area.getAreaName();
        return msg;
    }

    /**
     * Descripción: El metodo calculateEffectiveness Calcula la efectividad de la
     * gestión de las solicitudes y lo organiza con informacion extra de la
     * solicitud.
     * 
     * @return msg String efectividad de la gestión de las solicitudes
     *         junto a informacion de la misma
     * 
     */
    @Override
    public String calculateEffectiveness() {
        String msg = "";
        double effectiveness = 0;
        long date1 = 0;
        long date2 = 0;

        if ((status == Status.ACCEPTED)
                || (status == Status.DECLINED)) {

            Calendar newRegisterDate = (Calendar) registerDate.clone();
            date1 = (clasificationDate.getTimeInMillis());
            newRegisterDate.add(Calendar.DAY_OF_YEAR, 20);
            date2 = newRegisterDate.getTimeInMillis();

            effectiveness = (1 - (Math.abs((date1 - date2) * 1.0 / miliseconds) / 100)) * 100;
            msg += "\nSolicitante:" + applicantName +
                    "\nAsunto: " + issue +
                    "\nArea: " + area.getAreaName() +
                    "\nEstado: " + status +
                    "\nFecha de registro: "
                    + new SimpleDateFormat("dd/MM/yyyy").format(registerDate.getTime()) +
                    "\n Fecha de clasificación"
                    + new SimpleDateFormat("dd/MM/yyyy")
                            .format(clasificationDate.getTime())
                    +
                    "\nEFECTIVIDAD DE LA GESTION DE LA SOLICITUD: " + effectiveness;
        }

        return msg;
    }

}
