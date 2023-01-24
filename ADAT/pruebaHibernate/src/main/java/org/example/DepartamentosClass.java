package org.example;

import java.util.Collection;
import java.util.Objects;

public class DepartamentosClass {
    private byte deptNo;
    private String dnombre;
    private String loc;
    private Collection<EmpleadosClass> empleadosByDeptNo;

    public byte getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(byte deptNo) {
        this.deptNo = deptNo;
    }

    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartamentosClass that = (DepartamentosClass) o;
        return deptNo == that.deptNo && Objects.equals(dnombre, that.dnombre) && Objects.equals(loc, that.loc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptNo, dnombre, loc);
    }

    public Collection<EmpleadosClass> getEmpleadosByDeptNo() {
        return empleadosByDeptNo;
    }

    public void setEmpleadosByDeptNo(Collection<EmpleadosClass> empleadosByDeptNo) {
        this.empleadosByDeptNo = empleadosByDeptNo;
    }
}
