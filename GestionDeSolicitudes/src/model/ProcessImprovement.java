package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.lang.Math;

public class ProcessImprovement extends Project implements Calculable {

    private Calendar estimateDate;
    private Calendar endingDate;

    public ProcessImprovement(Application application, Collaborator leader, Priority priority, String code,
            Calendar estimateDate) {
        super(application, leader, priority, code);

        this.estimateDate = estimateDate;
        this.endingDate = Calendar.getInstance();
    }

    public Calendar getEstimateDate() {
        return estimateDate;
    }

    public void setEstimateDate(Calendar estimateDate) {
        this.estimateDate = estimateDate;
    }

    public Calendar getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Calendar endingDate) {
        this.endingDate = endingDate;
    }

    @Override
    public String toString() {
        String msg = "";
        msg += "\nLIDER: " + getLeader().getName();
        msg += "\nPRIORIDAD: " + getPriority();
        msg += "\nCODIGO: " + getCode();
        msg += "\nFECHA DE CLASIFICACION: "
                + new SimpleDateFormat("dd/MM/yyyy").format(getClasificationDate().getTime());
        msg += "\nFECHA ESTIMADA DE CIERRE:" + new SimpleDateFormat("dd/MM/yyyy").format(estimateDate.getTime());

        return msg;
    }

    /**
     * Descripción: El metodo calculateEffectiveness Calcula la efectividad de la
     * gestión del proyecto
     * 
     * @return msg String efectividad de la
     *         gestión del proyecto
     */
    @Override
    public String calculateEffectiveness() {
        String msg = "";
        double effectiveness = 0;
        long date1 = 0;
        long date2 = 0;

        if (getStatus() == ProjectStatus.FINISHED) {

            date1 = getEndingDate().getTimeInMillis();
            date2 = getEstimateDate().getTimeInMillis();
            effectiveness = (1 - (Math.abs((date1 - date2) * 1.0 / miliseconds) / 100)) * 100;
            msg += toString() +
                    "\nEFECTIVIDAD DE LA GESTION DEL PROYECTO: " + effectiveness;
        }

        return msg;
    }

}
