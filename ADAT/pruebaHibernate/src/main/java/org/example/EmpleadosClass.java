package org.example;

import java.sql.Date;
import java.util.Objects;

public class EmpleadosClass {
    private short empNo;
    private String apellido;
    private String oficio;
    private Short dir;
    private Date fechaAlt;
    private Double salario;
    private Double comision;
    private byte deptNo;
    private DepartamentosClass departamentosByDeptNo;

    public short getEmpNo() {
        return empNo;
    }

    public void setEmpNo(short empNo) {
        this.empNo = empNo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public Short getDir() {
        return dir;
    }

    public void setDir(Short dir) {
        this.dir = dir;
    }

    public Date getFechaAlt() {
        return fechaAlt;
    }

    public void setFechaAlt(Date fechaAlt) {
        this.fechaAlt = fechaAlt;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public byte getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(byte deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpleadosClass that = (EmpleadosClass) o;
        return empNo == that.empNo && deptNo == that.deptNo && Objects.equals(apellido, that.apellido) && Objects.equals(oficio, that.oficio) && Objects.equals(dir, that.dir) && Objects.equals(fechaAlt, that.fechaAlt) && Objects.equals(salario, that.salario) && Objects.equals(comision, that.comision);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, apellido, oficio, dir, fechaAlt, salario, comision, deptNo);
    }

    public DepartamentosClass getDepartamentosByDeptNo() {
        return departamentosByDeptNo;
    }

    public void setDepartamentosByDeptNo(DepartamentosClass departamentosByDeptNo) {
        this.departamentosByDeptNo = departamentosByDeptNo;
    }
}
