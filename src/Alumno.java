
public class Alumno {
	
	private int codigo;
	private String nombre;
	private String apellidos;
	
	public Alumno(int codigo, String nombre, String apellidos) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	

}
