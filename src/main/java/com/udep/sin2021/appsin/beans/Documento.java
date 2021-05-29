/* Capa bean:*/
// Lleva y trae información, sin otra lógica*/
//PIERINA HOLAAAAAAAAAAAAAAAA
//Atributos privados no pueden modificarse directamente, se debe usar métodos accesores como Refactor - Encapsulate Fields
//holi
package com.udep.sin2021.appsin.beans;

public class Documento {
    
    private String codigo;
    private String nombre;
    private String version;
    private String fecha;
    private String ruta;
    private String icono;
    private String tipo;
    private String area;
    private String unidad_negocio;

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the unidad_negocio
     */
    public String getUnidad_negocio() {
        return unidad_negocio;
    }

    /**
     * @param unidad_negocio the unidad_negocio to set
     */
    public void setUnidad_negocio(String unidad_negocio) {
        this.unidad_negocio = unidad_negocio;
    }

    /**
     * @return the icono
     */
    public String getIcono() {
        return icono;
    }

    /**
     * @param icono the icono to set
     */
    public void setIcono(String icono) {
        this.icono = icono;
    }
    
}
