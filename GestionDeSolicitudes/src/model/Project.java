package model;

import java.util.Calendar;

public abstract class Project {

    private Application application;
    private Calendar clasificationDate;
    private Collaborator leader;
    private Priority priority;
    private ProjectStatus status;
    private String code;
    private Calendar endingDate;

    public Project(Application application, Collaborator leader, Priority priority, String code) {
        this.application = application;
        clasificationDate = Calendar.getInstance();
        this.leader = leader;
        this.priority = priority;
        status = ProjectStatus.INCOURSE;
        this.code = code;
        endingDate = Calendar.getInstance();
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Calendar getClasificationDate() {
        return clasificationDate;
    }

    public void setClasificationDate(Calendar clasificationDate) {
        this.clasificationDate = clasificationDate;
    }

    public Collaborator getLeader() {
        return leader;
    }

    public void setLider(Collaborator leader) {
        this.leader = leader;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Calendar getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Calendar endingDate) {
        this.endingDate = endingDate;
    }

}
