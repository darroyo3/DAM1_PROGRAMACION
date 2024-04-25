package mensajeria.principal;

import mensajeria.accesodatos.JDBCMensajeriaDAO;

public class Principal {
	
	public static void main(String[] args) {
		
		try {
			JDBCMensajeriaDAO.conectar();
			PantallaInicio frame = new PantallaInicio();
			frame.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha podido conectar a la BBDD");
			e.printStackTrace();
		}

		
		
	}
}
