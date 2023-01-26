package org.example;

import org.example.DepartamentosClass;
import org.example.EmpleadosClass;
import org.example.HibernateUtil;
import org.hibernate.*;
import org.hibernate.exception.ConstraintViolationException;

public class MainEmpleado {
	public static void main(String[] args) {
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Inserto un EMPLEADO EN EL DEPARTAMENTO 10.");

		Float salario = new Float(1500);// inicializo el salario
		Float comision = new Float(10); // inicializo la comisi�n

		EmpleadosClass em = new EmpleadosClass(); // creo un objeto empleados
		em.setEmpNo((short) 4456); // el numero de empleado es 4455
		em.setApellido("PEPE");
		em.setDir((short) 7499); // el director es el numero de empleado 7499
		em.setOficio("VENDEDOR");
		em.setSalario(564.0);
		em.setComision(145.515145);

		DepartamentosClass d = new DepartamentosClass(); // creo un objeto Departamentos
		d.setDeptNo((byte) 19); // el n�mero de dep es 10
		em.setDepartamentosByDeptNo(d);

		// fecha de alta
		java.util.Date hoy = new java.util.Date();
		java.sql.Date fecha = new java.sql.Date(hoy.getTime());
		em.setFechaAlt(fecha);

		try {
			session.save(em);
			try {
				tx.commit();
			} catch (ConstraintViolationException e) {
				System.out.println("EMPLEADO DUPLICADO");
				System.out.printf("MENSAJE: %s%n", e.getMessage());
				System.out.printf("COD ERROR: %d%n", e.getErrorCode());
				System.out.printf("ERROR SQL: %s%n", e.getSQLException().getMessage());
			}
		} catch (TransientPropertyValueException e) {
			System.out.println("EL DEPARTAMENTO NO EXISTE");
			System.out.printf("MENSAJE: %s%n", e.getMessage());
			System.out.printf("Propiedad: %s%n", e.getPropertyName());
		} catch (Exception e) {
			System.out.println("ERROR NO CONTROLADO....");
			e.printStackTrace();
		}

		session.close();
		System.exit(0);
	}
}
