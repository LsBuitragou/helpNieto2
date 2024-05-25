package model;

import java.text.SimpleDateFormat;

public class KnowledgeManagement extends Project {

    private String processName;
    private TypeProjects typeProject;
    private Community community;

    public KnowledgeManagement(Application application, Collaborator leader, Priority priority,
            String processName, TypeProjects typeProject, Community community, String code) {
        super(application, leader, priority, code);
        this.processName = processName;
        this.typeProject = typeProject;
        this.community = community;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public TypeProjects getTypeProject() {
        return typeProject;
    }

    public void setTypeProject(TypeProjects typeProject) {
        this.typeProject = typeProject;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public String toString() {
        String msg = "";
        msg += "\nLIDER: " + getLeader().getName();
        msg += "\nPRIORIDAD: " + getPriority();
        msg += "\nCODIGO: " + getCode();
        msg += "\nNOMBRE DEL PROCESO: " + processName;
        msg += "\nTIPO DE PROYECTO: " + typeProject;
        msg += "\nCOMUNIDAD A LA QUE IMPACTA: " + community;
        msg += "\nFECHA DE CLASIFICACION: "
                + new SimpleDateFormat("dd/MM/yyyy").format(getClasificationDate().getTime());

        return msg;
    }

}
