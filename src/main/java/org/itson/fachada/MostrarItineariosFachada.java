/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.fachada;

import static ObjNegocio.Dias.DOMINGO;
import static ObjNegocio.Dias.JUEVES;
import static ObjNegocio.Dias.LUNES;
import static ObjNegocio.Dias.MARTES;
import static ObjNegocio.Dias.MIERCOLES;
import static ObjNegocio.Dias.SABADO;
import static ObjNegocio.Dias.VIERNES;
import ObjNegocio.Itinerario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author JORGE
 */
public class MostrarItineariosFachada implements IMostrarItinerarios{
MostrarItinerario visor= new MostrarItinerario();
    
    @Override
    public void reporteItinerario(Itinerario itinerario) {
        visor.reporteItinerario(itinerario);
    }
    
    protected class MostrarItinerario implements JRDataSource {

        private String[] infoItinerario;
        private List<Itinerario> listaItinerario;
        private int index;

        public MostrarItinerario(){};
        
        public void reporteItinerario(Itinerario itinerario) {
            List<Itinerario> reporte = new ArrayList<Itinerario>();
            reporte.add(itinerario);
            MostrarItinerario reporteJasper = new MostrarItinerario(reporte);
            try {
                JasperReport report = (JasperReport) JRLoader.loadObjectFromFile("src\\main\\java\\reporte\\Itinerario.jasper");
                JasperPrint jPrint = JasperFillManager.fillReport(report, null, reporteJasper.getDataSource());
                JasperViewer view = new JasperViewer(jPrint, false);
                view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                view.setVisible(true);
            } catch (JRException ex) {
                ex.getMessage();
            }
        }
        public String listaDias() {
            String dias = "";
            if (listaItinerario.get(0).getDias().contains(LUNES)) {
                dias += "Lunes\n";
            }
            if (listaItinerario.get(0).getDias().contains(MARTES)) {
                dias += "Martes\n";
            }
            if (listaItinerario.get(0).getDias().contains(MIERCOLES)) {
                dias += "Miercoles\n";
            }
            if (listaItinerario.get(0).getDias().contains(JUEVES)) {
                dias += "Jueves\n";
            }
            if (listaItinerario.get(0).getDias().contains(VIERNES)) {
                dias += "Viernes\n";
            }
            if (listaItinerario.get(0).getDias().contains(SABADO)) {
                dias += "Sabado\n";
            }
            if (listaItinerario.get(0).getDias().contains(DOMINGO)) {
                dias += "Domingo\n";
            }
            return dias;
        }

        public String Animales() {
            String animales = "";
            for (int i = 0; i < this.listaItinerario.get(0).getEspecies().size(); i++) {
                animales += this.listaItinerario.get(0).getEspecies().get(i).getNomEspanol() + "\n";
            }
            return animales;
        }

        public MostrarItinerario(List<Itinerario> listaItinerario) {
            this.listaItinerario = listaItinerario;
            this.infoItinerario = new String[7];
            index = -1;
            for (int i = 0; i < this.listaItinerario.size(); i++) {
                infoItinerario[0] = this.listaItinerario.get(i).getNombre();
                infoItinerario[1] = String.valueOf(this.listaItinerario.get(i).getEspecies().size());
                infoItinerario[2] = String.valueOf(this.listaItinerario.get(i).getLongitud());
                infoItinerario[3] = String.valueOf(this.listaItinerario.get(i).getMaxVisitantes());
                infoItinerario[4] = this.listaDias();
                infoItinerario[5] = this.listaItinerario.get(i).getHoraInicio() + " - " + this.listaItinerario.get(0).getHoraFin();
                infoItinerario[6] = this.Animales();
            }
        }

        @Override
        public boolean next() throws JRException {
            index++;
            return (index < this.infoItinerario.length);
        }

        @Override
        public Object getFieldValue(JRField jrf) throws JRException {
            Object value = null;

            String fieldName = jrf.getName();
            switch (fieldName) {
                case "nombre":
                    value = this.infoItinerario[0];
                    break;
                case "noEspecies":
                    value = infoItinerario[1];
                    break;
                case "longitud":
                    value = infoItinerario[2];
                    break;
                case "maxVisitantes":
                    value = infoItinerario[3];
                    break;
                case "dias":
                    value = infoItinerario[4];
                    break;
                case "horario":
                    value = infoItinerario[5];
                    break;
                case "especies":
                    value = infoItinerario[6];
                    break;
            }
            return value;
        }

        public JRDataSource getDataSource() {
            return new MostrarItinerario(this.listaItinerario);
        }

    }
    
}
