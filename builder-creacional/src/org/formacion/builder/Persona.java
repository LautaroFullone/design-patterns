package org.formacion.builder;

public class Persona {

	private String nombre;
	private int edad;
	private String municipio;
	private String colegio;
	private String lugarTrabajo;
	
	private Persona() {}

	@Override
	public String toString() {
		return "Persona{" +
				"nombre='" + nombre + '\'' +
				", edad=" + edad +
				", municipio='" + municipio + '\'' +
				", colegio='" + colegio + '\'' +
				", lugarTrabajo='" + lugarTrabajo + '\'' +
				'}';
	}

	//TODO se debe crear un builder mayor y un builder menor (para la persona)

	public static class Builder {
		private Persona persona;
		
		public Builder(String nombre) {
			persona = new Persona();
			persona.nombre = nombre;
		}
		
		public Builder setMunicipio (String municipio) {
			persona.municipio = municipio;
			return this;
		}
		
		public Builder setMayor(int edad) {
			if (edad < 18) throw new IllegalArgumentException("es menor de edad " + edad);
			persona.edad = edad;
			return this;
		}

		public Builder setLugarTrabajo(String lugarTrabajo){
			if(lugarTrabajo.strip().isBlank() || lugarTrabajo==null)
				throw new IllegalArgumentException("el lugar de trabajo es invalido");
			else
				persona.lugarTrabajo=lugarTrabajo;
			return this;
		}
		
		public Builder setMenor(int edad) {
			if (edad >= 18) throw new IllegalArgumentException("es mayor de edad " + edad);
			persona.edad = edad;
			return this;
		}

		public Builder setColegio(String colegio) {
			if(colegio.strip().isBlank() || colegio==null)
				throw new IllegalArgumentException("el colegio es invalido");
			else if (persona.colegio != null || persona.edad < 18)  //no es responsabilidad de este metodo evaluar otro atributo
				throw new IllegalArgumentException("ya estas grandecito para el colegio");
			else
				persona.colegio=colegio;
			return this;

		}
		public Persona build() {
			return persona;
		}

		@Override
		public String toString() {
			return "Builder{" +
					"persona=" + persona +
					'}';
		}
	}
	
}
