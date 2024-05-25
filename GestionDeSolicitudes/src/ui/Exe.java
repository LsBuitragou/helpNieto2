package ui;

import java.util.Scanner;
import model.Controller;

public class Exe {

    private Scanner input;
    private Controller ctrl;

    public static void main(String[] args) {

        Exe exe = new Exe();
        exe.menu();

    }

    public Exe() {
        input = new Scanner(System.in);
        ctrl = new Controller();
    }

    /**
     * Descripción: El metodo menu despliega las opciones de ingresar a otros menus
     * o salir de la aplicación.
     * pre: Scanner input inicializado
     */

    public void menu() {

        boolean flag = true;
        System.out.println("Bienvenido al sistema de la COP16");

        do {
            System.out.println("------------------------------------");
            System.out.println("MENU PRINICIPAL");
            System.out.println("Escoja una opcion");
            System.out.println("1]Entrar al menu de registros");
            System.out.println("2]Entrar al menu administrativo");
            System.out.println("3]Salir");
            int option = input.nextInt();

            switch (option) {

                case 1:
                    applicantMenu();
                    break;

                case 2:
                    adminMenu();
                    break;

                case 3:
                    System.out.println("MUCHAS GRACIAS POR VISITAR");
                    flag = false;
                    break;

                default:

                    break;

            }

        } while (flag);

    }

    /**
     * Descripción: El metodo applicantMenu despliega las opciones de registro de
     * todos los objetos.
     * pre: Scanner input inicializado
     */
    public void applicantMenu() {
        boolean flag = true;

        do {
            System.out.println("------------------------------------");
            System.out.println("Escoja una opcion");
            System.out.println("1]Registrar solicitud");
            System.out.println("2]Registrar colaborador");
            System.out.println("3]Registrar area");
            System.out.println("0]Volver al Menu principal");
            int option = input.nextInt();

            switch (option) {

                case 1:
                    applicationLog();
                    break;
                case 2:
                    collaboratorLog();
                    break;
                case 3:
                    registerArea();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("ERROR: Porfavor ingresar una opcion valida");
                    break;

            }

        } while (flag);
    }

    /**
     * Descripción: El metodo adminMenu despliega las opciones de registrar y
     * modificar.
     * pre: Scanner input inicializado
     */
    public void adminMenu() {
        boolean flag = true;

        do {
            System.out.println("------------------------------------");
            System.out.println("Escoja una opcion");
            System.out.println("1]Gestion de solicitudes");
            System.out.println("2]Registrar proyecto");
            System.out.println("3]Finalizar proyecto");
            System.out.println("4]Efectividad de gestion de las solicitudes");
            System.out.println("5]Efectividad de proyectos de Transformación y mejora de procesos");
            System.out.println("6]Efectividad de colaboradores");
            System.out
                    .println("7]Indicadores globales de trabajo del área de Transformación y Mejoramiento de procesos");
            System.out.println("8]Consulta de los últimos 5 proyectos asignados a cada colaborador");
            System.out.println("0]Volver al Menu principal");
            int option = input.nextInt();

            switch (option) {

                case 1:
                    applicationManagement();
                    break;
                case 2:
                    projectClassification();
                    break;
                case 3:
                    endProject();
                    break;
                case 4:
                    viewApplicationRegEffectiveness();
                    break;
                case 5:
                    viewProccessImprovEffectiveness();
                    break;
                case 6:
                    viewColaboratorEffectiveness();
                    break;
                case 7:
                    globalIndicators();
                    break;
                case 8:
                    consultLastFiveProjects();
                    break;
                case 0:
                    flag = false;
                    break;
            }

        } while (flag);

    }

    /**
     * Descripción: El metodo applicationLog permite el registro de una solicitud .
     * pre: Scanner input inicializado
     */
    public void applicationLog() {
        input.nextLine();

        System.out.println("REGISTRO DE SOLICITUD");
        System.out.println("ASUNTO:");
        String issue = input.nextLine();
        System.out.println("DESCRIPCION:");
        String description = input.nextLine();
        System.out.println("NOMBRE DEL SOLICITANTE:");
        String solicitantName = input.nextLine();
        System.out.println("NOMBRE DEL RESPONSABLE");
        String responsibleName = input.nextLine();
        System.out.println("AREA SOLICITANTE(codigo):");
        System.out.println(ctrl.listAreas());
        String area = input.nextLine();

        if (ctrl.addApplication(issue, description, solicitantName, responsibleName, area)) {
            System.out.println("La solicitud ha sido registrada con exito");
        } else {
            System.out.println("ERROR: La solicitud no ha sido registrada");
        }
    }

    /**
     * Descripción: El metodo collaboratorLog permite el registro de un colaborador
     * a cualquier area existente.
     * pre: Scanner input inicializado
     */
    public void collaboratorLog() {
        input.nextLine();
        System.out.println("REGISTRO DE COLABORADOR");
        System.out.println("NUMERO DE IDENTIFICACION:");
        String id = input.nextLine();
        System.out.println("NOMBRE:");
        String name = input.nextLine();
        System.out.println("EMAIL:");
        String email = input.nextLine();
        System.out.println("NUMERO DE EXTENSION:");
        String extensionNumber = input.nextLine();
        System.out.println(ctrl.listAreas());
        System.out.println("Ingrese el codigo del area al que pertenece:");
        String areaCode = input.nextLine();
        if (ctrl.addCollaborator(id, name, email, extensionNumber, areaCode)) {
            System.out.println("El colaborador ha sido registrado con exito");
        } else {
            System.out.println("ERROR: El colaborador no ha sido registrado");
        }
    }

    /**
     * Descripción: El metodo registerArea permite el registro de un area de la
     * universidad.
     * pre: Scanner input inicializado
     */
    public void registerArea() {
        input.nextLine();

        System.out.println("REGISTRO DE AREA");
        System.out.println("DIRECCION DE LA OFICINA:");
        String officeDirection = input.nextLine();
        System.out.println("ID DE COLABORADOR RESPONSABLE:");
        System.out.println(ctrl.listTransformationCollaborators());
        String responsibleCollaborator = input.nextLine();
        System.out.println("NOMBRE DEL AREA:");
        String areasName = input.nextLine();
        System.out.println("CODIGO:");
        String code = input.nextLine();

        if (ctrl.addArea(officeDirection, responsibleCollaborator, areasName, code)) {
            System.out.println("El area ha sido registrado con exito");
        } else {
            System.out.println("ERROR: El area no ha sido registrado");
        }

    }

    /**
     * Descripción: El metodo applicationManagement permite cambiar el estado de una
     * solicitud de pendiente a ceptada, rechazada, o dejada en pendiente.
     * pre: Scanner input inicializado
     */
    public void applicationManagement() {
        input.nextLine();
        boolean flag = true;

        System.out.println("GESTION DE SOLICITUDES");
        do {
            System.out.println(ctrl.listApplications());
            System.out.println("Ingrese el numero de la solicitud que desea actualizar");
            System.out.println("Presione 0 si desea volver al menu");
            int i = input.nextInt();

            switch (i) {
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("");
                    System.out.println(ctrl.showApplication(i - 1));
                    System.out.println("");
                    System.out.println("1]ACEPTAR");
                    System.out.println("2]RECHAZAR");
                    System.out.println("3]PENDIENTE");
                    int option = input.nextInt();
                    ctrl.changeStatus(option, i - 1);
                    break;
            }
        } while (flag);
    }

    /**
     * Descripción: El metodo projectClassification permite clasificar las
     * solicitues aceptadas entre Gestion de conocimiento y
     * Transformacion/Mejoramiento de proces y recolecta la informacion para la
     * creacion del proyecto (Project).
     * pre: Scanner input inicializado
     */
    private void projectClassification() {
        input.nextLine();
        boolean flag = true;

        System.out.println("REGISTRO DE PROYECTO");
        do {
            System.out.println(ctrl.listAcceptedApplications());
            System.out.println("Ingrese el numero de la solicitud que desee registrar como proyecto");
            System.out.println("Presione 0 si desea volver al menu");
            int i = input.nextInt();
            input.nextLine();
            switch (i) {
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("");
                    System.out.println(ctrl.showApplication(i - 1));
                    System.out.println("");
                    System.out.println("RECOLECCION DE INFORMACION DE PROYECTO");
                    System.out.println("TIPO DE PROYECTO:");
                    System.out.println("1]Gestion de conocimiento");
                    System.out.println("2]Transformacion/Mejoramiento de procesos");
                    int type = input.nextInt();
                    input.nextLine();
                    System.out.println(ctrl.listTransformationCollaborators());
                    System.out.println("ID DEL COLABORADOR LIDER:");
                    String leaderId = input.nextLine();
                    System.out.println("PRIORIDAD:");
                    System.out.println("1]ALTA");
                    System.out.println("2]MEDIA");
                    System.out.println("3]BAJA");
                    System.out.println("4]URGENTE");
                    int priority = input.nextInt();
                    input.nextLine();
                    System.out.println("CODIGO (numerico de 4 digitos):");
                    String code = input.nextLine();
                    switch (type) {
                        case 1:
                            System.out.println("NOMBRE DE PROCESO:");
                            String processName = input.nextLine();
                            System.out.println("TIPO DE PROYECTO:");
                            System.out.println("1]DOCUMENTACION");
                            System.out.println("2]ESTANDARIZACION");
                            System.out.println("3]OPTIMIZACION");
                            int typeProject = input.nextInt();
                            System.out.println("COMUNIDAD A LA QUE IMPACTA:");
                            System.out.println("1]ESTUDIANTES");
                            System.out.println("2]PROFESORES");
                            System.out.println("3]SECTOR ADMINISTRATIVO");
                            int community = input.nextInt();
                            if (ctrl.addKnowledgeManagementProyect((i - 1), leaderId, priority, processName,
                                    typeProject,
                                    community, code)) {
                                ctrl.addProjectToCollaborator(code);
                                System.out.println("Se ha agregado el proyecto con exito");
                                System.out.println(ctrl.showProject(code));
                            } else {
                                System.out.println("ERROR: No se registro el proyecto");
                            }
                            break;
                        case 2:
                            if (ctrl.addProccessImprovementProyect((i - 1), leaderId, priority, code)) {
                                ctrl.addProjectToCollaborator(code);
                                System.out.println("Se ha agregado el proyecto con exito");
                                System.out.println(ctrl.showProject(code));
                            } else {
                                System.out.println("ERROR: No se registro el proyecto");

                            }

                            break;
                    }
                    break;
            }
        } while (flag);
    }

    /**
     * Descripción: El metodo endProject permite el cierre de un proyecto, cambiando
     * su ProjectStatus a FINISHED y registrando su fecha de cierre.
     * pre: Scanner input inicializado
     */
    public void endProject() {
        input.nextLine();

        System.out.println("CIERRE DE PROYECTO");
        System.out.println(ctrl.listProjects());
        System.out.println("Ingrese el codigo del proyecto que desee desplegar:");
        String code = input.nextLine();
        System.out.println(ctrl.showProject(code));
        System.out.println("DESEA CERRAR ESTE PROYECTO?");
        System.out.println("1]SI");
        System.out.println("2]NO");
        int option = input.nextInt();
        switch (option) {
            case 1:
                ctrl.endProject(code);
                System.out.println("EL PROYECTO HA SIDO FINALIZADO CON EXITO");
                break;
            case 2:
                System.out.println("El proyecto sigue en curso, volviendo al menú principal...");
                break;
        }
    }

    /**
     * Descripción: El metodo viewApplicationRegEffectiveness despliega el calculo
     * de la efectividad de la gestion de solicitudes.
     * pre: Scanner input inicializado
     */
    public void viewApplicationRegEffectiveness() {
        input.nextLine();
        System.out.println("CALCULO DE GESITON DE SOLICITUD");

        System.out.println("\n" + ctrl.calculateApplicationRegEffectiveness() + "%");
    }

    /**
     * Descripción: El metodo viewProccessImprovEffectiveness despliega el calculo
     * de la efectividad de la gestion de procesos.
     * pre: Scanner input inicializado
     */
    public void viewProccessImprovEffectiveness() {
        input.nextLine();
        System.out.println("CALCULO DE LA EFICIENCIA DE PORYECTOS DEL AREA DE TRANSFORMACION/MEJORA DE PROCESOS");

        System.out.println("\n" + ctrl.calculateProccessImprovEffectiveness() + "%");
    }

    /**
     * Descripción: El metodo viewColaboratorEffectiveness despliega el calculo de
     * la efectividad de los colaboradores.
     * pre: Scanner input inicializado
     */
    public void viewColaboratorEffectiveness() {
        input.nextLine();
        System.out.println("CALCULO DE LA EFICIENCIA DE LOS COLABORADORES");

        System.out.println("\n" + ctrl.calculateColaboratorEffectiveness() + "%");
    }

    /**
     * Descripción: El metodo globalIndicators despliega los Indicadores globales de
     * trabajo del área de Transformación y Mejoramiento de procesos.
     * pre: Scanner input inicializado
     */
    public void globalIndicators() {
        System.out.println("Cantidad de proyectos por cada tipo");

        System.out.println("GESTION DE CONOCIMIENTO: " + ctrl.countKMProjects() + " proyectos en total.");
        System.out.println("De las cuales:");
        System.out.println(ctrl.countKMProjectsPriority());
        System.out.println("");
        System.out
                .println("TRANSFORMACION/MEJORAMIENTO DE PROCESOS: " + ctrl.countPIProjects() + " proyectos en total.");
        System.out.println("De las cuales:");
        System.out.println(ctrl.countPIProjectsPriority());
        System.out.println("");

        System.out.println("Cantidad de proyectos liderados por cada colaborador del área.");
        System.out.println(ctrl.showAmountProjectsPerCollaborator());

    }

    /**
     * Descripción: El metodo consultLastFiveProjects despliega los ultimos 5
     * proyectos de cada colaborador del area de Transformacion y mejoramiento de
     * procesos por orden de prioridad de forma matricial.
     * pre: Scanner input inicializado
     */
    public void consultLastFiveProjects() {
        System.out.println("Ultimos 5 proyectos por colaborador");

        System.out.println(ctrl.consultLastFiveProjects());
    }
}