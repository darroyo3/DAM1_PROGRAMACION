package mensajeria.accesodatos;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mensajeria.modelo.Carta;
import mensajeria.modelo.Envio;
import mensajeria.modelo.Mensajero;
import mensajeria.modelo.Paquete;

public class JDBCMensajeriaDAO implements MensajeriaDAO{

	static Connection conn;
	static Statement sentenciaSQL;
	static ResultSet rs;

	
	public JDBCMensajeriaDAO() {
	}
	
	public static void conectar() throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		conn=(Connection)DriverManager.getConnection("jdbc:mariadb://localhost/mensajeria","root","");
		sentenciaSQL=conn.createStatement();
		
	}
	
	public static void desconectar() throws Exception {
		rs.close();
		sentenciaSQL.close();
		conn.close();
	}
	
	@Override
	public void altaMensajero(Mensajero mensajero) throws SQLException {
		// TODO Auto-generated method stub
		String sentencia="INSERT INTO MENSAJERO("+
		"NOMBRE,SUELDO,MAXIMO_ENVIOS) "+
		"VALUES ('"+
		mensajero.getNombre()+"','"+
		mensajero.getSueldo()+"','"+
		mensajero.getNumMax()+"');";
		System.out.println(sentencia);
		sentenciaSQL.executeUpdate(sentencia);
	}

	@Override
	public void bajaMensajero(int codigo) throws SQLException{
		// TODO Auto-generated method stub
		String sentencia="DELETE FROM MENSAJERO"
				+ " WHERE CODIGOM="+codigo;
		sentenciaSQL.executeUpdate(sentencia);		
	}

	@Override
	public int buscarMensajero(String nombre) throws SQLException{
		// TODO Auto-generated method stub
		String sentencia="SELECT CODIGOM FROM MENSAJERO"
				+ " WHERE NOMBRE='"+nombre+"'";
		System.out.println(sentencia);
		rs=sentenciaSQL.executeQuery(sentencia);
		int codigo=-1;
		if (rs.next()) {
			codigo=rs.getInt("CODIGOM");
		}
		return codigo;
	}

	@Override
	public List<Mensajero> obtenerMensajeros() throws SQLException {
		// TODO Auto-generated method stub

//		String sentencia="SELECT A.CODIGOM, NOMBRE, SUELDO, MAXIMO_ENVIOS, "+
//		"COUNT(*) ENVIOS_ACTUALES "+	
//		"FROM MENSAJERO A LEFT JOIN ASIGNAR B ON A.CODIGOM=B.CODIGOM "+
//		"GROUP BY A.CODIGOM";
//		String sentencia="SELECT A.CODIGOM CODIGOM, NOMBRE, SUELDO, MAXIMO_ENVIOS, "+
//		" ENVIOS_REALIZADOS.NUMERO ENVIOS_ACTUALES "+
//		"FROM MENSAJERO A LEFT JOIN "+
//		"(SELECT COUNT(*) NUMERO, CODIGOM "+
//		" FROM ASIGNAR GROUP BY CODIGOM ) ENVIOS_REALIZADOS " +
//		" ON A.CODIGOM = ENVIOS_REALIZADOS.CODIGOM "+
//		"GROUP BY A.CODIGOM";

		String sentencia="SELECT CODIGOM, NOMBRE, SUELDO, "+
		"MAXIMO_ENVIOS, NUM_ENVIOS FROM MENSAJERO";
		rs=sentenciaSQL.executeQuery(sentencia);
		List<Mensajero> mensajeros=new ArrayList<>();
		while(rs.next()) {
			int codigo=rs.getInt("CODIGOM");
			String nombre=rs.getString("NOMBRE");
			double sueldo=rs.getFloat("SUELDO");
			int maxEnvio=rs.getInt("MAXIMO_ENVIOS");
			int numEnvios=rs.getInt("NUM_ENVIOS");
			mensajeros.add(new Mensajero(
					codigo,nombre,sueldo,maxEnvio,numEnvios));
		}
		
		return mensajeros;
	}

	@Override
	public void altaCarta(Carta carta) throws SQLException{
		// TODO Auto-generated method stub
		String sentencia="INSERT INTO ENVIO("+
		"FECHA,DIR_ORIGEN,DIR_DESTINO,PRECIO) "+
		"VALUES ('"+
		carta.getFecha()+"','"+
		carta.getDireccionOrigen()+"','"+
		carta.getDireccionDestino()+"',"+
		carta.getPrecio()+
		");";
		System.out.println(sentencia);
		sentenciaSQL.executeUpdate(sentencia);

	}

	@Override
	public void bajaCarta(Carta carta) throws SQLException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void altaPaquete(Paquete paquete) throws SQLException {
		// TODO Auto-generated method stub
		String sentencia="INSERT INTO ENVIO("+
		"FECHA,DIR_ORIGEN,DIR_DESTINO,PESO,PRECIOKILO) "+
		"VALUES ('"+
		paquete.getFecha()+"','"+
		paquete.getDireccionOrigen()+"','"+
		paquete.getDireccionDestino()+"',"+
		paquete.getPeso()+","+
		paquete.getPrecioKilo()+
		");";
		System.out.println(sentencia);
		sentenciaSQL.executeUpdate(sentencia);

	}

	@Override
	public void bajaPaquete(Paquete paquete) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Carta> obtenerCartas() throws SQLException {
		// TODO Auto-generated method stub
		String sentencia="SELECT * FROM ENVIO WHERE ESTADO = 0 "+
		" AND PRECIO IS NOT NULL";
		rs=sentenciaSQL.executeQuery(sentencia);
		List<Carta> cartas=new ArrayList<>();
		while(rs.next()) {
			int codigo=rs.getInt("CODIGOE");
			String fecha=rs.getString("FECHA");
			String origen=rs.getString("DIR_ORIGEN");
			String destinio=rs.getString("DIR_DESTINO");
			float precio=rs.getFloat("PRECIO");
			cartas.add(new Carta(
					codigo,fecha,origen,destinio,precio));
		}
		
		return cartas;

	}

	@Override
	public List<Paquete> obtenerPaquetes() throws SQLException {
		// TODO Auto-generated method stub
		String sentencia="SELECT * FROM ENVIO WHERE ESTADO = 0 "+
		"AND PESO IS NOT NULL";
		rs=sentenciaSQL.executeQuery(sentencia);
		List<Paquete> paquetes=new ArrayList<>();
		while(rs.next()) {
			int codigo=rs.getInt("CODIGOE");
			String fecha=rs.getString("FECHA");
			String origen=rs.getString("DIR_ORIGEN");
			String destinio=rs.getString("DIR_DESTINO");
			float peso=rs.getFloat("PESO");
			float preciokilo=rs.getFloat("PRECIOKILO");
			paquetes.add(new Paquete(
					codigo,fecha,origen,destinio,peso,preciokilo));
		}
		
		return paquetes;

	}

	@Override
	public List<Carta> obtenerCartasAsignadas() throws SQLException {
		// TODO Auto-generated method stub

		String sentencia="SELECT * FROM ENVIO WHERE ESTADO = 1 "+
		" AND PRECIO IS NOT NULL"+
		" ORDER BY CODIGOE ";
		rs=sentenciaSQL.executeQuery(sentencia);
		List<Carta> cartas=new ArrayList<>();
		while(rs.next()) {
			int codigo=rs.getInt("CODIGOE");
			String fecha=rs.getString("FECHA");
			String origen=rs.getString("DIR_ORIGEN");
			String destinio=rs.getString("DIR_DESTINO");
			float precio=rs.getFloat("PRECIO");
			cartas.add(new Carta(
					codigo,fecha,origen,destinio,precio));
		}
		
		return cartas;

	}

	@Override
	public List<Paquete> obtenerPaquetesAsignados() throws SQLException {
		// TODO Auto-generated method stub
		String sentencia="SELECT * FROM ENVIO WHERE ESTADO = 1 "+
		" AND PESO IS NOT NULL "+
		" ORDER BY CODIGOE";
		rs=sentenciaSQL.executeQuery(sentencia);
		List<Paquete> paquetes=new ArrayList<>();
		while(rs.next()) {
			int codigo=rs.getInt("CODIGOE");
			String fecha=rs.getString("FECHA");
			String origen=rs.getString("DIR_ORIGEN");
			String destinio=rs.getString("DIR_DESTINO");
			float peso=rs.getFloat("PESO");
			float preciokilo=rs.getFloat("PRECIOKILO");
			paquetes.add(new Paquete(
					codigo,fecha,origen,destinio,peso,preciokilo));
		}
		
		return paquetes;

	}

	@Override
	public List<Carta> obtenerCartasEntregados() throws SQLException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String sentencia="SELECT * FROM ENVIO WHERE ESTADO = 2 "+
		" AND PRECIO IS NOT NULL";
		rs=sentenciaSQL.executeQuery(sentencia);
		List<Carta> cartas=new ArrayList<>();
		while(rs.next()) {
			int codigo=rs.getInt("CODIGOE");
			String fecha=rs.getString("FECHA");
			String origen=rs.getString("DIR_ORIGEN");
			String destinio=rs.getString("DIR_DESTINO");
			float precio=rs.getFloat("PRECIO");
			cartas.add(new Carta(
					codigo,fecha,origen,destinio,precio));
		}
		
		return cartas;


	}

	@Override
	public List<Paquete> obtenerPaquetesEntregados() throws SQLException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String sentencia="SELECT * FROM ENVIO WHERE ESTADO = 2 "+
		"AND PESO IS NOT NULL";
		rs=sentenciaSQL.executeQuery(sentencia);
		List<Paquete> paquetes=new ArrayList<>();
		while(rs.next()) {
			int codigo=rs.getInt("CODIGOE");
			String fecha=rs.getString("FECHA");
			String origen=rs.getString("DIR_ORIGEN");
			String destinio=rs.getString("DIR_DESTINO");
			float peso=rs.getFloat("PESO");
			float preciokilo=rs.getFloat("PRECIOKILO");
			paquetes.add(new Paquete(
					codigo,fecha,origen,destinio,peso,preciokilo));
		}
		
		return paquetes;
	}

	@Override
	public int comprobarEnvioEnEspera(int codigoE) throws SQLException {
		// TODO Auto-generated method stub
		String sentencia="SELECT COUNT(*) VALOR FROM ENVIO "+
		" WHERE ESTADO = 0 "+
		"AND CODIGOE = "+codigoE;
		rs=sentenciaSQL.executeQuery(sentencia);
		rs.next();
		return rs.getInt("VALOR");
	}

	@Override
	public int comprobarMensajeroLibre(int codigoM) throws SQLException {
		// TODO Auto-generated method stub
		String sentencia="SELECT COUNT(*) VALOR FROM MENSAJERO "+
		" WHERE ESTADO = 0 "+
		"AND CODIGOM = "+codigoM;
		rs=sentenciaSQL.executeQuery(sentencia);
		rs.next();
		return rs.getInt("VALOR");
	}

	@Override
	public List<String> obtenerMensajerosCartasAsignadas() throws SQLException {
		// TODO Auto-generated method stub
		String sentencia="SELECT C.NOMBRE "+
		" FROM ENVIO A, ASIGNAR B, MENSAJERO C "+
		" WHERE A.CODIGOE=B.CODIGOE AND "+
		" B.CODIGOM=C.CODIGOM AND A.ESTADO = 1 "+
		" AND A.PRECIO IS NOT NULL "+
		" ORDER BY A.CODIGOE ";
		rs=sentenciaSQL.executeQuery(sentencia);
		List<String> nombres=new ArrayList<>();
		while(rs.next()) {
			String nombre=rs.getString("NOMBRE");
			nombres.add(nombre);
		}
		
		return nombres;

	}

	@Override
	public List<String> obtenerMensajerosPaquetesAsignados() throws SQLException {
		// TODO Auto-generated method stub
		String sentencia="SELECT C.NOMBRE "+
		" FROM ENVIO A, ASIGNAR B, MENSAJERO C "+
		" WHERE A.CODIGOE=B.CODIGOE AND "+
		" B.CODIGOM=C.CODIGOM AND A.ESTADO = 1 "+
		" AND A.PESO IS NOT NULL "+
		" ORDER BY A.CODIGOE ";
		rs=sentenciaSQL.executeQuery(sentencia);
		List<String> nombres=new ArrayList<>();
		while(rs.next()) {
			String nombre=rs.getString("NOMBRE");
			nombres.add(nombre);
		}
		
		return nombres;

	}

	@Override
	public void asignarEnvio(int codigoE, int codigoM) throws SQLException {
		// TODO Auto-generated method stub
		String sentencia="INSERT INTO ASIGNAR("+
		"CODIGOE,CODIGOM) "+
		"VALUES ("+
		codigoE+","+
		codigoM+");";
		sentenciaSQL.executeUpdate(sentencia);		
		// Se modifica el estado del envio.
		sentencia="UPDATE ENVIO SET ESTADO=1 WHERE CODIGOE="+codigoE;
		sentenciaSQL.executeUpdate(sentencia);		
		// Se aumenta el numero de envios al mensajero
		sentencia="UPDATE MENSAJERO SET NUM_ENVIOS=NUM_ENVIOS+1 "+
		" WHERE CODIGOM="+codigoM;
		sentenciaSQL.executeUpdate(sentencia);		

	}

	@Override
	public int comprobarEnvioAsignado(int codigoE) throws SQLException {
		// TODO Auto-generated method stub
		String sentencia="SELECT COUNT(*) VALOR FROM ENVIO "+
		" WHERE ESTADO = 1 "+
		"AND CODIGOE = "+codigoE;
		rs=sentenciaSQL.executeQuery(sentencia);
		rs.next();
		return rs.getInt("VALOR");
	}

	@Override
	public void entregarEnvio(int codigoE) throws SQLException {
		// TODO Auto-generated method stub
		String sentencia="UPDATE ENVIO SET ESTADO=2 WHERE CODIGOE="+codigoE;
		sentenciaSQL.executeUpdate(sentencia);		
		// Se disminuye el numero de envios cuando se entrega un envio.
		sentencia="UPDATE MENSAJERO A, ASIGNAR B "+
		" SET A.NUM_ENVIOS=A.NUM_ENVIOS-1 "+
		" WHERE B.CODIGOM=A.CODIGOM "+
		" AND B.CODIGOE="+codigoE;
		sentenciaSQL.executeUpdate(sentencia);		
	}

}
