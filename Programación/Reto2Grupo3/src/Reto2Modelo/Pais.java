package Reto2Modelo;

public class Pais {
	private String PaisCodigo;
	private String DescripcionPais;

	public Pais(String paisCodigo, String descripcionPais) {
		super();
		PaisCodigo = paisCodigo;
		DescripcionPais = descripcionPais;
	}

	public String getPaisCodigo() {
		return PaisCodigo;
	}

	public void setPaisCodigo(String paisCodigo) {
		PaisCodigo = paisCodigo;
	}

	public String getDescripcionPais() {
		return DescripcionPais;
	}

	public void setDescripcionPais(String descripcionPais) {
		DescripcionPais = descripcionPais;
	}

	@Override
	public String toString() {
		return "Pais [PaisCodigo=" + PaisCodigo + ", DescripcionPais=" + DescripcionPais + "]";
	}
}
