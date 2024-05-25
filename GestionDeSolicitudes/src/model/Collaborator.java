package model;

import java.util.Calendar;
import java.util.ArrayList;

public class Collaborator implements Calculable {

    private String id;
    private String name;
    private String email;
    private String extentionNumber;
    private Area area;
    private ArrayList<Project> projects;

    public Collaborator(String id, String name, String email, String extentionNumber, Area area) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.extentionNumber = extentionNumber;
        this.area = area;
        projects = new ArrayList<Project>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExtentionNumber() {
        return extentionNumber;
    }

    public void setExtentionNumber(String extentionNumber) {
        this.extentionNumber = extentionNumber;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public boolean addProjects(Project newProject) {
        return projects.add(newProject);
    }

    /**
     * Descripción: El metodo calculateEffectiveness Calcula la efectividad de los
     * colaboradores y lo organiza con informacion extra del colaborador.
     * 
     * @return msg String efectividad de los colaboradores
     *         junto a informacion del mismo
     *         pre: Arreglo projects inicializado.
     */
    @Override
    public String calculateEffectiveness() {
        String msg = "";
        double effectiveness = 0;
        int finished = 0;
        int projectsInMonth = 0;
        Calendar today = Calendar.getInstance();
        for (int i = 0; i < projects.size(); i++) {
            if (today.get(Calendar.MONTH) == projects.get(i).getClasificationDate().get(Calendar.MONTH)) {
                projectsInMonth++;
                if (projects.get(i).getStatus() == ProjectStatus.FINISHED) {
                    finished++;
                }
            }
        }

        effectiveness = (finished / projectsInMonth);
        msg += "\nNombre del colaborador: " + name +
                "\nId: " + id +
                "\nNumero de proyectos este mes: " + projectsInMonth +
                "\nNumero de proyectos finalizados " + finished +
                "\nEFECTIVIDAD: " + effectiveness;
        return msg;
    }
}
