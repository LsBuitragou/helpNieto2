package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Controller {

    private ArrayList<Collaborator> collaborators;
    private ArrayList<Area> areas;
    private ArrayList<Application> applications;
    private ArrayList<Project> projects;

    public Controller() {

        collaborators = new ArrayList<Collaborator>();
        areas = new ArrayList<Area>();
        applications = new ArrayList<Application>();
        projects = new ArrayList<Project>();
        testCases();

    }

    /**
     * Descripción: El metodo testCases crea casos de prueba para cada uno de los
     * objetos del programa.
     * pre: arreglos collaborators, areas, applications, projects inicializados.
     * post: Se guarda en cada uno de los arreglos de la clase objetos de prueba.
     */
    public void testCases() {

        addArea("Al lado de rectoria", "987", "Transformación y mejora de procesos",
                "111");
        addCollaborator("123", "Ricardo Montaner", "richimontaner@gmail.com", "987", "111");
        addCollaborator("234", "Samuel Emilio Diaz", "samulovesharry@hotmail.com", "035", "111");
        addCollaborator("345", "Juan David Delgado", "juanito@gmail.com", "333", "111");
        addCollaborator("456", "Carlos Melendez", "carlosmsanchez@gmail.com", "874", "111");
        addApplication("Numero de colaboradores", "Se requiere mayor numero de colaboradores para una gestion adecauda",
                "Eduardo Rincon", "Smauel Emilio Diaz", "111");
        addApplication("Actualizacion de software de entrada",
                "Se requiere actualizar el software de entrada de solicitudes en el area",
                "Valentina Mendoza", "Carlos Melendez", "111");
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DAY_OF_YEAR, 50);
        applications.get(0).setClasificationDate(date);
        applications.get(0).setStatus(Status.ACCEPTED);
        Calendar date2 = Calendar.getInstance();
        date.add(Calendar.DAY_OF_YEAR, 5);
        applications.get(0).setClasificationDate(date2);
        applications.get(0).setStatus(Status.ACCEPTED);
        addProccessImprovementProyect(1, "234", 2, "3434");
        addProjectToCollaborator("3434");
        addKnowledgeManagementProyect(0, "123", 2, "Contratacion de colaboradores", 2, 3, "2323");
        addProjectToCollaborator("2323");
    }

    /**
     * Descripción: El metodo addApplication recibe la información de una solicitud
     * y lo convierte a un objeto de clase Application.
     * 
     * @param issue           String Asunto de la solicitud
     * @param description     String Descripcion de la solicitud
     * @param solicitantName  String Nombre del solicitante
     * @param responsibleName String Nombre del responsable del area solicitante
     * @param solicitantArea  String Codigo del area solicitante
     * @return true boolean si la solicitud ha sido guardada/false si no
     *         pre: Arreglo applications inicializado.
     *         post: Objeto de clase Application almacenado en el arreglo
     *         applications.
     */
    public boolean addApplication(String issue, String description, String solicitantName, String responsibleName,
            String solicitantArea) {
        Area area = null;
        for (int i = 0; i < areas.size(); i++) {
            if (solicitantArea.equals(areas.get(i).getCode())) {
                area = areas.get(i);
                return applications.add(new Application(issue, description, solicitantName, responsibleName, area));
            }
        }
        return false;
    }

    /**
     * Descripción: El metodo addCollaborator recibe la información de un
     * colaborador y lo convierte a un objeto de clase Collaborator.
     * 
     * @param id              String Id del colaborador
     * @param name            String Nombre del colaborador
     * @param email           String Email del colaborador
     * @param extensionNumber String Numero de extension (En caso de tenerlo) del
     *                        colaborador
     * @param areaCode        String Codigo del area del colaborador
     * @return true boolean si el colaborador ha sido guardado/false si no
     *         pre: Arreglo collaborators inicializado.
     *         post: Objeto de clase Colaborator almacenado en el arreglo
     *         collaborators.
     */
    public boolean addCollaborator(String id, String name, String email, String extensionNumber, String areaCode) {
        Area area = null;
        for (int i = 0; i < areas.size(); i++) {
            if (areaCode.equals(areas.get(i).getCode())) {
                area = areas.get(i);
                return collaborators.add(new Collaborator(id, name, email, extensionNumber, area));
            }
        }
        return false;
    }

    /**
     * Descripción: El metodo addArea recibe la información de un area y lo
     * convierte a un objeto de clase Area.
     * 
     * @param officeDirection         String Dirección de la oficina del area
     * @param responsibleCollaborator String Colaborador responsable del area
     * @param areasName               String Nombre del area
     * @param code                    String Codigo del area
     * @return true boolean si el area ha sido guardado/false si no
     *         pre: Arreglo areas inicializado.
     *         post: Objeto de clase Area almacenado en el arreglo areas.
     */
    public boolean addArea(String officeDirection, String responsibleCollaborator, String areasName,
            String code) {
        Collaborator collaborator = null;
        for (int i = 0; i < collaborators.size(); i++) {
            if (responsibleCollaborator.equals(collaborators.get(i).getId())) {
                collaborator = collaborators.get(i);
            }
        }
        for (int i = 0; i < areas.size(); i++) {
            if (code.equals(areas.get(i).getCode())) {
                return false;
            }
        }
        return areas.add(new Area(officeDirection, collaborator, areasName, code));
    }

    /**
     * Descripción: El metodo listAreas forma un String donde se muestren todas las
     * areas registradas con su código.
     * 
     * @return list String La lista de las areas organizada
     *         pre: Arreglo areas inicializado.
     */
    public String listAreas() {
        String list = "";

        for (int i = 0; i < areas.size(); i++) {
            list += "\n[" + areas.get(i).getCode() + "] " + areas.get(i).getAreaName();
        }

        return list;
    }

    /**
     * Descripción: El metodo changeStatus Cambia el status de una solicitud a
     * aceptada, rechazada o pendiente.
     * 
     * @param option int Eleccion de cambio
     * @param index  int indice de la solicitud a modificar
     * @return true boolean si el estado ha sido cambiado/false si no
     *         pre: Arreglo applications inicializado.
     *         post: Objeto de clase Application modificado
     */
    public boolean changeStatus(int option, int index) {
        boolean flag = false;
        switch (option) {
            case 1:
                applications.get(index).setStatus(Status.ACCEPTED);
                flag = true;
                applications.get(index).setClasificationDate(Calendar.getInstance());
                ;
                break;
            case 2:
                applications.get(index).setStatus(Status.DECLINED);
                flag = true;
                applications.get(index).setClasificationDate(Calendar.getInstance());
                break;
            case 3:
                applications.get(index).setStatus(Status.PENDANT);
                flag = true;
                break;
        }
        if (flag) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Descripción: El metodo showApplication Muestra el toString de una solicitud
     * seleccionada.
     * 
     * @param index int indice de la solicitud a mostrar
     * @return applications.get(index).toString() String ToString de la solicitud
     *         pre: Arreglo applications inicializado.
     */
    public String showApplication(int index) {

        return applications.get(index).toString();
    }

    /**
     * Descripción: El metodo listAcceptedApplications forma un String donde se
     * muestren todas las
     * solicitudes aceptadas con su indice y asunto.
     * 
     * @return list String La lista de solicitudes aceptadas organizadas
     *         pre: Arreglo applications inicializado.
     */
    public String listAcceptedApplications() {
        String list = "";
        boolean flag = true;
        for (int i = 0; i < applications.size(); i++) {
            flag = true;
            if (applications.get(i).getStatus() == Status.ACCEPTED) {
                for (int n = 0; n < projects.size(); n++) {
                    if (projects.get(n).getApplication() == applications.get(i)) {
                        flag = false;
                    }
                }
                if (flag) {
                    list += "\n[" + (i + 1) + "]" + "\nASUNTO: " + applications.get(i).getIssue() + "\n";
                }
            }
        }
        return list;

    }

    /**
     * Descripción: El metodo listAcceptedApplications forma un String donde se
     * muestren todas las
     * solicitudes.
     * 
     * @return list String La lista de solicitudes organizadas
     *         pre: Arreglo applications inicializado.
     */
    public String listApplications() {
        String list = "";
        for (int i = 0; i < applications.size(); i++) {
            if (applications.get(i).getStatus() == Status.PENDANT) {
                list += "\n[" + (i + 1) + "]" + "\nASUNTO: " + applications.get(i).getIssue();
            }
        }
        return list;
    }

    /**
     * Descripción: El metodo addKnowledgeManagementProyect recibe la información de
     * un proyecto de tipo Gestion de conocimiento
     * y lo convierte a un objeto de clase KnowledgeManagement.
     * 
     * @param i            int Indice de la solicitud correspondiente a el proyecto
     * @param leaderId     String Id del lider del proyecto
     * @param priorityInt  int Indicador de la prioridad del proyecto
     * @param processName  String Nombre del proceso del proyecto
     * @param typeProject  int Indicador del tipo de proyecto
     * @param communityInt int Indicador de la comunidad a la que impacta
     * @param code         String Codigo del proyecto
     * @return true boolean si el proyecto ha sido guardado/false si no
     *         pre: Arreglo projects inicializado.
     *         post: Objeto de clase KnowledgeManagement almacenado en el arreglo
     *         projects.
     */
    public boolean addKnowledgeManagementProyect(int i, String leaderId, int priorityInt, String processName,
            int typeProject,
            int communityInt, String code) {
        TypeProjects projectType = TypeProjects.DOCUMENTATION;
        switch (typeProject) {
            case 1:
                projectType = TypeProjects.DOCUMENTATION;
                break;
            case 2:
                projectType = TypeProjects.ESTANDARIZATION;
                break;
            case 3:
                projectType = TypeProjects.OPTIMIZATION;
                break;
        }

        Community community = Community.STUDENTS;
        switch (communityInt) {
            case 1:
                community = Community.STUDENTS;
                break;
            case 2:
                community = Community.TEACHERS;
                break;
            case 3:
                community = Community.ADMIN;
                break;
        }

        Priority priority = Priority.LOW;
        switch (priorityInt) {
            case 1:
                priority = Priority.HIGH;
                break;
            case 2:
                priority = Priority.MEDIUM;
                break;
            case 3:
                priority = Priority.LOW;
                break;
            case 4:
                priority = Priority.URGENT;
                break;
        }

        Application application = applications.get(i);
        Collaborator leader = searchCollaborator(leaderId);
        if (leader != null) {
            return projects
                    .add(new KnowledgeManagement(application, leader, priority, processName, projectType, community,
                            code));
        } else {
            return false;
        }

    }

    /**
     * Descripción: El metodo addProccessImprovementProyect recibe la información de
     * un proyecto de tipo Transformación/Mejora de procesos
     * y lo convierte a un objeto de clase ProccessImprovement.
     * 
     * @param i           int Indice de la solicitud correspondiente a el proyecto
     * @param leaderId    String Id del lider del proyecto
     * @param priorityInt int Indicador de la prioridad del proyecto
     * @param code        String Codigo del proyecto
     * @return true boolean si el proyecto ha sido guardado/false si no
     *         pre: Arreglo projects inicializado.
     *         post: Objeto de clase ProccessImprovement almacenado en el arreglo
     *         projects.
     */
    public boolean addProccessImprovementProyect(int i, String leaderId, int priorityInt, String code) {
        Calendar estimatedDate = Calendar.getInstance();

        Priority priority = Priority.LOW;
        switch (priorityInt) {
            case 1:
                priority = Priority.HIGH;
                estimatedDate.add(Calendar.DAY_OF_YEAR, 10);
                break;
            case 2:
                priority = Priority.MEDIUM;
                estimatedDate.add(Calendar.DAY_OF_YEAR, 30);
                break;
            case 3:
                priority = Priority.LOW;
                estimatedDate.add(Calendar.DAY_OF_YEAR, 60);
                break;
            case 4:
                priority = Priority.URGENT;
                estimatedDate.add(Calendar.DAY_OF_YEAR, 5);
                break;
        }

        for (int n = 0; n < areas.size(); n++) {
            if (code.equals(areas.get(n).getCode())) {
                return false;
            }
        }
        Collaborator leader = searchCollaborator(leaderId);
        if (leader != null) {
            Project project = new ProcessImprovement(applications.get(i), leader, priority, code, estimatedDate);
            return projects.add(project);
        } else {
            return false;
        }
    }

    /**
     * Descripción: El metodo searchCollaborator busca un colaborador en el arreglo
     * de collaborators usando su id.
     * 
     * @param id String Id del colaborador a buscar
     * @return Collaborator Collaborador encontrado o null en
     *         caso de no ser encontrado
     *         pre: Arreglo collaborators inicializado.
     */
    public Collaborator searchCollaborator(String id) {
        for (int n = 0; n < collaborators.size(); n++) {
            if (collaborators.get(n).getId().equals(id)) {
                return collaborators.get(n);
            }
        }
        return null;
    }

    /**
     * Descripción: El metodo addProjectToCollaborator Agrega un proyecto a el
     * arrego¿lo del colaborador lider.
     * 
     * @param code String Codigo del proyecto en cuestion
     * @return Boolean true en caso de ser
     *         agregado con exito, false si no.
     *         pre: Arreglo collaborators y projects inicializados.
     */
    public boolean addProjectToCollaborator(String code) {
        Project project = searchProject(code);
        if (project != null && project.getLeader() != null) {
            return project.getLeader().addProjects(project);
        }
        return false;
    }

    /**
     * Descripción: El metodo listTransformationCollaborators forma un String donde
     * se
     * muestren todos los colaboradores del area de transformacion y mejora de
     * procesos.
     * 
     * @return list String La lista de los colaboradores del area de transformacion
     *         y mejora de procesos.
     *         pre: Arreglo collaborators inicializado.
     */
    public String listTransformationCollaborators() {
        String list = "";

        for (int i = 0; i < collaborators.size(); i++) {
            if (collaborators.get(i).getArea().getCode().equals("111")) {
                list += "\n[" + collaborators.get(i).getId() + "] " + collaborators.get(i).getName();
            }
        }

        return list;
    }

    /**
     * Descripción: El metodo listProjects forma un String donde
     * se
     * muestren todos los proyectos registrados
     * 
     * @return list String La lista de los proyectos registrados
     *         pre: Arreglo projects inicializado.
     */
    public String listProjects() {
        String list = "";
        String type = "";
        for (int i = 0; i < projects.size(); i++) {
            type = "";
            if (projects.get(i).getStatus() == ProjectStatus.INCOURSE) {
                list += "\n[" + projects.get(i).getCode() + "]";
                list += "\nClasificación: "
                        + new SimpleDateFormat("dd/MM/yyyy").format(projects.get(i).getClasificationDate().getTime());
                if (projects.get(i) instanceof KnowledgeManagement) {
                    type += "Gestion de conocimiento";
                } else if (projects.get(i) instanceof ProcessImprovement) {
                    type += "Transformacion/Mejora de procesos";
                }
                list += "\nTipo: " + type;
            }
        }

        return list;
    }

    /**
     * Descripción: El metodo searchProject busca un proyecto en el arreglo
     * de projects usando su codigo.
     * 
     * @param code Codigo del proyecto a buscar
     * @return Project Proyecto encontrado o null en
     *         caso de no ser encontrado
     *         pre: Arreglo projects inicializado.
     */
    public Project searchProject(String code) {
        for (int i = 0; i < projects.size(); i++) {
            if (code.equals(projects.get(i).getCode())) {
                return projects.get(i);
            }
        }
        return null;
    }

    /**
     * Descripción: El metodo endProject cambia en ProjectStatus de un proyecto a
     * FINISHED.
     * 
     * @param code Codigo del proyecto a terminar
     * @return true Boolean
     *         pre: Arreglo projects inicializado.
     */
    public boolean endProject(String code) {

        searchProject(code).setEndingDate(Calendar.getInstance());
        searchProject(code).setStatus(ProjectStatus.FINISHED);

        return true;
    }

    /**
     * Descripción: El metodo showProject Muestra el toString de una proyecto
     * seleccionado.
     * 
     * @param code String indice del proyecto a mostrar
     * @return searchProject(code).toString() String ToString del proyecto
     *         pre: Arreglo porjects inicializado.
     */
    public String showProject(String code) {
        return searchProject(code).toString();
    }

    /**
     * Descripción: El metodo calculateApplicationRegEffectiveness Organiza el
     * mesaje a desplegar
     * de la efectividad de la gestion de las solicitudes en porcentaje junto a su
     * solicitud correspondiente.
     * 
     * @return msg String efectividad de la gestion de las solicitudes en porcentaje
     *         junto a su solicitud correspondiente
     *         pre: Arreglo applications inicializado.
     */
    public String calculateApplicationRegEffectiveness() {
        String msg = "";
        double effectiveness = 0;
        int miliseconds = 86400000;
        long date1 = 0;
        long date2 = 0;

        for (int i = 0; i < applications.size(); i++) {
            if ((applications.get(i).getStatus() == Status.ACCEPTED)
                    || (applications.get(i).getStatus() == Status.DECLINED)) {

                Calendar newRegisterDate = (Calendar) applications.get(i).getRegisterDate().clone();
                date1 = (applications.get(i).getClasificationDate().getTimeInMillis());
                newRegisterDate.add(Calendar.DAY_OF_YEAR, 20);
                date2 = newRegisterDate.getTimeInMillis();

                effectiveness = 1 - (((date1 - date2) * 1.0 / miliseconds) / 100);
                msg += "SOLICITUD #" + i +
                        "\nSolicitante:" + applications.get(i).getApplicantName() +
                        "\nAsunto: " + applications.get(i).getIssue() +
                        "\nArea: " + applications.get(i).getArea().getAreaName() +
                        "\nEstado: " + applications.get(i).getStatus() +
                        "\nFecha de registro: "
                        + new SimpleDateFormat("dd/MM/yyyy").format(applications.get(i).getRegisterDate().getTime()) +
                        "\n Fecha de clasificación"
                        + new SimpleDateFormat("dd/MM/yyyy")
                                .format(applications.get(i).getClasificationDate().getTime())
                        +
                        "\nEFECTIVIDAD DE LA GESTION DE LA SOLICITUD: " + effectiveness;
            }

        }

        return msg;
    }

    /**
     * Descripción: El metodo calculateProccessImprovEffectiveness Organiza el
     * mesaje a desplegar
     * de la efectividad de la gestion de proyectos en porcentaje junto a su
     * proyecto correspondiente.
     * 
     * @return msg String efectividad de la gestion de proyectos en porcentaje
     *         junto a su proyecto correspondiente
     *         pre: Arreglo projects inicializado.
     */
    public String calculateProccessImprovEffectiveness() {
        String msg = "";
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i) instanceof ProcessImprovement) {
                msg += "PROYECTO #" + i + "\n" +
                        ((ProcessImprovement) projects.get(i)).calculateEffectiveness();
            }
        }
        return msg;
    }

    /**
     * Descripción: El metodo calculateColaboratorEffectiveness Organiza el mensaje
     * de la efectividad de los colaboradores y lo
     * organiza junto a su colaborador correspondiente.
     * 
     * @return msg String efectividad de los colaboradores
     *         junto a su colaborador correspondiente
     *         pre: Arreglo collaborators inicializado.
     */
    public String calculateColaboratorEffectiveness() {
        String list = "";
        for (int i = 0; i < collaborators.size(); i++) {
            list += "\nCOLABORADOR #" + i;
            if (collaborators.get(i).getProjects().isEmpty()) {
                list += "\n El colaborador no tiene proyectos";
            } else {
                list += "\n" + collaborators.get(i).calculateEffectiveness();
            }

        }
        return list;
    }

    /**
     * Descripción: El metodo countKMProjects Cuenta los proyectos de tipo
     * KnowledgeManagement.
     * 
     * @return n int Numero de proyectos de tipo KnowledgeManagement
     *         pre: Arreglo projects inicializado.
     */
    public int countKMProjects() {
        int n = 0;
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i) instanceof KnowledgeManagement) {
                n++;
            }
        }
        return n;
    }

    /**
     * Descripción: El metodo countPIProjects Cuenta los proyectos de tipo
     * ProcessImprovement.
     * 
     * @return n int Numero de proyectos de tipo ProcessImprovement
     *         pre: Arreglo projects inicializado.
     */
    public int countPIProjects() {
        int n = 0;
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i) instanceof ProcessImprovement) {
                n++;
            }
        }
        return n;
    }

    /**
     * Descripción: El metodo countKMProjectsPriority Cuenta los proyectos de tipo
     * KnowledgeManagement de cada prioridad y los organiza en un String.
     * 
     * @return n int Numero de proyectos de tipo KnowledgeManagement de cada
     *         prioridad
     *         pre: Arreglo projects inicializado.
     */
    public String countKMProjectsPriority() {
        int a = 0;
        int m = 0;
        int b = 0;
        int u = 0;
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i) instanceof KnowledgeManagement) {
                if (projects.get(i).getPriority() == Priority.HIGH) {
                    a++;
                } else if (projects.get(i).getPriority() == Priority.MEDIUM) {
                    m++;
                } else if (projects.get(i).getPriority() == Priority.LOW) {
                    b++;
                } else if (projects.get(i).getPriority() == Priority.URGENT) {
                    u++;
                }
            }
        }
        return a + " son alta\n" + m + " son media\n" + b + " son baja\n" + u + " son urgentes\n";
    }

    /**
     * Descripción: El metodo countPIProjectsPriority Cuenta los proyectos de tipo
     * ProcessImprovement de cada prioridad y los organiza en un String.
     * 
     * @return n int Numero de proyectos de tipo ProcessImprovement de cada
     *         prioridad
     *         pre: Arreglo projects inicializado.
     */
    public String countPIProjectsPriority() {
        int a = 0;
        int m = 0;
        int b = 0;
        int u = 0;
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i) instanceof ProcessImprovement) {
                if (projects.get(i).getPriority() == Priority.HIGH) {
                    a++;
                } else if (projects.get(i).getPriority() == Priority.MEDIUM) {
                    m++;
                } else if (projects.get(i).getPriority() == Priority.LOW) {
                    b++;
                } else if (projects.get(i).getPriority() == Priority.URGENT) {
                    u++;
                }
            }
        }
        return a + " son alta\n" + m + " son media\n" + b + " son baja\n" + u + " son urgentes\n";
    }

    /**
     * Descripción: El metodo showAmountProjectsPerCollaborator Cuenta la cantidad
     * de proyectos liderado por cada colaborador y lo organiza en un mensaje.
     * 
     * @return msg String Mensaje de la cantidad de proyectos liderado por cada
     *         colaborador
     *         pre: Arreglo collaborators inicializado.
     */
    public String showAmountProjectsPerCollaborator() {
        String msg = "";
        int z = 0;

        for (int i = 0; i < collaborators.size(); i++) {
            z = 0;
            ArrayList<Project> tempArray = collaborators.get(i).getProjects();
            for (int n = 0; n < tempArray.size(); n++) {
                z++;
            }
            msg += "\nColaborador #" + i +
                    "\n Nombre: " + collaborators.get(i).getName() +
                    "\n Area: " + collaborators.get(i).getArea().getAreaName() +
                    "\n Numero de proeyctos liderados: " + z;

        }

        return msg;
    }

    /**
     * Descripción: El metodo consultLastFiveProjects organiza los ultimos 5
     * proyectos de cada colaborador del area de Transformacion y mejoramiento de
     * procesos por orden de prioridad de forma matricial.
     * 
     * @return msg String Matriz generada
     *         pre: Arreglo collaborators y projects inicializado.
     */
    public String consultLastFiveProjects() {
        String msg = "";
        int c = 0;
        for (int i = 0; i < collaborators.size(); i++) {
            if (collaborators.get(i).getArea().getCode() == "111") {
                c++;
            }
        }
        int z = 0;
        int n = 0;
        int j = 0;
        Project p1 = null;
        Project p2 = null;
        Project p3 = null;
        Project p4 = null;
        Project p5 = null;
        String priorityInitial = "";
        String[][] matrix = new String[c][6];
        ArrayList<Project> array = new ArrayList<>();

        for (int i = 0; i < collaborators.size(); i++) {
            if (collaborators.get(i).getArea().getCode() == "111") {
                p1 = null;
                p2 = null;
                p3 = null;
                p4 = null;
                p5 = null;
                array.clear();

                ArrayList<Project> tempArray = collaborators.get(i).getProjects();
                z = tempArray.size();

                if (tempArray.size() >= 5) {
                    j = 5;
                } else {
                    j = tempArray.size();
                }
                for (; j > 0; j--) {
                    if ((tempArray.get(z - j)).getPriority() == Priority.URGENT) {
                        if (p1 == null) {
                            p1 = tempArray.get(z - j);
                            array.add(p1);
                        } else if (p2 == null) {
                            p2 = tempArray.get(z - j);
                            array.add(p2);
                        } else if (p3 == null) {
                            p3 = tempArray.get(z - j);
                            array.add(p3);
                        } else if (p4 == null) {
                            p4 = tempArray.get(z - j);
                            array.add(p4);
                        } else if (p5 == null) {
                            p5 = tempArray.get(z - j);
                            array.add(p5);
                        }
                    }
                }
                if (tempArray.size() >= 5) {
                    j = 5;
                } else {
                    j = tempArray.size();
                }
                for (; j > 0; j--) {

                    if ((tempArray.get(z - j)).getPriority() == Priority.HIGH) {
                        if (p1 == null) {
                            p1 = tempArray.get(z - j);
                            array.add(p1);
                        } else if (p2 == null) {
                            p2 = tempArray.get(z - j);
                            array.add(p2);
                        } else if (p3 == null) {
                            p3 = tempArray.get(z - j);
                            array.add(p3);
                        } else if (p4 == null) {
                            p4 = tempArray.get(z - j);
                            array.add(p4);
                        } else if (p5 == null) {
                            p5 = tempArray.get(z - j);
                            array.add(p5);
                        }
                    }
                }
                if (tempArray.size() >= 5) {
                    j = 5;
                } else {
                    j = tempArray.size();
                }
                for (; j > 0; j--) {

                    for (; j > 0; j--) {
                        if ((tempArray.get(z - j)).getPriority() == Priority.MEDIUM) {
                            if (p1 == null) {
                                p1 = tempArray.get(z - j);
                                array.add(p1);
                            } else if (p2 == null) {
                                p2 = tempArray.get(z - j);
                                array.add(p2);
                            } else if (p3 == null) {
                                p3 = tempArray.get(z - j);
                                array.add(p3);
                            } else if (p4 == null) {
                                p4 = tempArray.get(z - j);
                                array.add(p4);
                            } else if (p5 == null) {
                                p5 = tempArray.get(z - j);
                                array.add(p5);
                            }
                        }
                    }
                }
                if (tempArray.size() >= 5) {
                    j = 5;
                } else {
                    j = tempArray.size();
                }
                for (; j > 0; j--) {

                    for (; j > 0; j--) {
                        if ((tempArray.get(z - j)).getPriority() == Priority.LOW) {
                            if (p1 == null) {
                                p1 = tempArray.get(z - j);
                                array.add(p1);
                            } else if (p2 == null) {
                                p2 = tempArray.get(z - j);
                                array.add(p2);
                            } else if (p3 == null) {
                                p3 = tempArray.get(z - j);
                                array.add(p3);
                            } else if (p4 == null) {
                                p4 = tempArray.get(z - j);
                                array.add(p4);
                            } else if (p5 == null) {
                                p5 = tempArray.get(z - j);
                                array.add(p5);
                            }
                        }

                    }
                }

                for (n = 0; n < array.size(); n++) {

                    if (array.get(n).getPriority() == Priority.URGENT) {
                        priorityInitial = "U";
                    } else if (array.get(n).getPriority() == Priority.HIGH) {
                        priorityInitial = "A";
                    } else if (array.get(n).getPriority() == Priority.MEDIUM) {
                        priorityInitial = "M";
                    } else if (array.get(n).getPriority() == Priority.LOW) {
                        priorityInitial = "B";
                    }
                    matrix[i][n + 1] = "[" + array.get(n).getCode() + "]-" + priorityInitial;
                }
                matrix[i][0] = "Colaborador #" + (i + 1) + "\n" + collaborators.get(i).getName();
            }
        }
        for (int p = 0; p < matrix.length; p++) { // filas numbers.length
            for (int s = 0; s < matrix[0].length; s++) { // columnas numbers[0].length
                if (matrix[p][s] != null) {
                    msg += matrix[p][s] + " ";
                } else {
                    msg += " ";
                }

            }
            msg += "\n";
        }

        return msg;
    }

}
