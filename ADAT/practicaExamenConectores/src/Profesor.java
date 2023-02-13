import java.sql.Date;

public class Profesor {

	//atrib
	private double cod_prof;
	private String nombre_pro;
	private String espe_pro;
	private Date fecha_nac;
	private	char sexo;
	private double salario;
	private double cod_centro;
	
	//contr
	public Profesor() {}
	
	public Profesor(double cod_prof, String nombre_pro, String espe_pro, Date fecha_nac, char sexo, double salario,
			double cod_centro) {
		super();
		this.cod_prof = cod_prof;
		this.nombre_pro = nombre_pro;
		this.espe_pro = espe_pro;
		this.fecha_nac = fecha_nac;
		this.sexo = sexo;
		this.salario = salario;
		this.cod_centro = cod_centro;
	}



	//get and set
	public double getCod_prof() {
		return cod_prof;
	}
	public void setCod_prof(double cod_prof) {
		this.cod_prof = cod_prof;
	}
	public String getNombre_pro() {
		return nombre_pro;
	}
	public void setNombre_pro(String nombre_pro) {
		this.nombre_pro = nombre_pro;
	}
	public String getEspe_pro() {
		return espe_pro;
	}
	public void setEspe_pro(String espe_pro) {
		this.espe_pro = espe_pro;
	}
	public Date getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public double getCod_centro() {
		return cod_centro;
	}
	public void setCod_centro(double cod_centro) {
		this.cod_centro = cod_centro;
	}
	
	
	
	
}
