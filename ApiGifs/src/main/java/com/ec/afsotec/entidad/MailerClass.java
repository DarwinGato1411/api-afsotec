/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.afsotec.entidad;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import javax.mail.BodyPart;
import javax.mail.Transport;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeUtility;

/**
 * Clase que permite el envio de e-mails utilizando el API javamail.
 *
 */
public class MailerClass {

//	String asunto = asuntoInf;
	String host = "smtp.gmail.com";
	String port = "587";
	String from = "docs.defact@gmail.com";
	String protocol = "smtp";
	String usuarioSmpt = "docs.defact@gmail.com";
	String password = "mjpjmkzrsedgzxcq";

//    private Tipoambiente amb = new Tipoambiente();
//    ServicioTipoAmbiente servicioTipoAmbiente = new ServicioTipoAmbiente();

	/**
	 * Recupera el nombre del catálogo descrito en la enumeración
	 *
	 * @param categoria nombre del parametroa a buscar
	 * @return
	 */
	public String getConfiguracionCorreo(String categoria) {
//        Set<BeCatalogo> dato = ofertaServicio.getCatalogo1(categoria);
//        if (dato.iterator().hasNext()) {
//            return dato.iterator().next().getNbCatalogo();
//        }
		return null;
	}

	/**
	 * Método que envía al mail las credenciales de acceso al sistema
	 *
	 * @param address Dirección de correo electronico
	 * @param mensaje Contenido del mensaje
	 * @return
	 * @throws java.rmi.RemoteException
	 */

	class SmtpAuthenticator extends Authenticator {

		public SmtpAuthenticator() {

			super();
		}

		@Override
		public PasswordAuthentication getPasswordAuthentication() {
//            amb = servicioTipoAmbiente.FindALlTipoambiente();
//            String username = "";
//            String password = "";

			return new PasswordAuthentication(usuarioSmpt, password);

		}
	}

	// envio de mail simple
//    
//      m.setRecipients(Message.RecipientType.TO,
//                    InternetAddress.parse(address));
	public String sendMailSimple(String address, String asuntoInf, String nombreCliente,
			Integer valor) throws java.rmi.RemoteException {

		try {
//                        String usuarioSmpt = "deckxelec@gmail.com";
//            String password = "metalicas366";

//            amb = servicioTipoAmbiente.FindALlTipoambiente();

//            String asunto = asuntoInf;
//            String host = "smtp.gmail.com";
//            String port = "587";
//            String protocol = "smtp";
//            String usuarioSmpt = "deckxelec@gmail.com";
//            String password = "Dereckandre02";
//            String asunto = "";
//            String host = amb.getAmHost();
//            String port = amb.getAmPort();
//            String protocol = amb.getAmProtocol();
//            String usuarioSmpt = amb.getAmUsuarioSmpt().trim();
//            String password = amb.getAmPassword().trim();
			String pattern = "dd/MM/yyyy";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			// Propiedades de la conexión
			// Get system properties
			Properties properties = System.getProperties();

			// Setup mail server
			properties.setProperty("mail.smtp.host", host);
			properties.setProperty("mail.smtp.user", usuarioSmpt);
			properties.setProperty("mail.smtp.password", password);
			properties.setProperty("mail.smtp.port", port);
			properties.setProperty("mail.smtp.starttls.enable", "true");
			properties.setProperty("mail.smtp.auth", "true");
			properties.setProperty("mail.debug", "false");
			properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
			// Setup Port
			properties.put("mail.smtp.ssl.trust", host);
//            properties.put("mail.smtp.starttls.enable", "true");
			SmtpAuthenticator auth = new SmtpAuthenticator();
			// Get the default Session object.
			Session session = Session.getInstance(properties, auth);
			MimeMessage m = new MimeMessage(session);
			String nickFrom = MimeUtility.encodeText("AFSOTEC - Cooperativa ......");
//            String nickTo = MimeUtility.encodeText(amb.getAmNombreComercial());
			Address addressfrom = new InternetAddress(usuarioSmpt, nickFrom);

			m.setFrom(addressfrom);

			BodyPart texto = new MimeBodyPart();
			String HTMLENVIO = "<body style=\"color: #666; font-size: 14px; font-family: 'Open Sans',Helvetica,Arial,sans-serif;\">\n"
					+ "<div class=\"box-content\" style=\"width: 80%; margin: 20px auto; max-width: 800px; min-width: 600px;\">\n"
					+ "    <div class=\"header-tip\" style=\"font-size: 10px;\n"
					+ "                                   color: #010e07;\n"
					+ "                                   text-align: right;\n"
					+ "                                   padding-right: 25px;\n"
					+ "                                   padding-bottom: 10px;\">\n" + "      \n" + "    </div>\n"
					+ "    <div class=\"info-top\" style=\"padding: 15px 25px;\n"
					+ "                                 border-top-left-radius: 10px;\n"
					+ "                                 border-top-right-radius: 10px;\n"
					+ "                                 background: #007ff7;\n"
					+ "                                 color: #fff;\n"
					+ "                                 overflow: hidden;\n"
					+ "                                 line-height: 32px;\">\n"
					+ "        <div style=\"color:#00000;font-size:18px\"><strong>\n" + "		 NOTIFICACION "
					+ sdf.format(new Date()) + "</strong></div>\n"
					+ "		<div style=\"color:#00000;font-size:11px\"><strong>\n"
					+ "		NOTIFICACION ELECTRONICA  </strong></div>\n" + "    </div>\n"
					+ "    <div class=\"info-wrap\" style=\"border-bottom-left-radius: 10px;\n"
					+ "                                  border-bottom-right-radius: 10px;\n"
					+ "                                  border:1px solid #ddd;\n"
					+ "                                  overflow: hidden;\n"
					+ "                                  padding: 15px 15px 20px;\">\n"
					+ "        <div class=\"tips\" style=\"padding:15px;\">\n"
					+ "            <p style=\" list-style: 160%; margin: 10px 0;\">Estimado socio,</p>\n"
					+ "            <p style=\" list-style: 160%; margin: 10px 0;\">" + nombreCliente + "</p>\n"
//					+ "			<p style=\" list-style: 160%; margin: 10px 0;\">Su documento electronico se ha generado correctamente</p>\n"
//					+ "			<p style=\" list-style: 160%; margin: 10px 0;\">Numero de documento:"
//					+ "                 <strong style=\"color:#010e07\"> " + numTransaccion + "</strong></p>\n"
//                        + "			<p style=\" list-style: 160%; margin: 10px 0;\">Clave de acceso:"
//                        + "                 <strong style=\"color:#010e07\"> " + acceso + "</strong></p>\n"
//                        + "            <p style=\" list-style: 160%; margin: 10px 0;\">Sus archivos PDF y XML se enviaron de forma adjunta, por favor reviselos</p>\n"
					+ "        </div>\n"
					+ "        <div class=\"time\" style=\"text-align: right; color: #999; padding: 0 15px 15px;\">Valor total:"
					+ "<strong style=\"color:#010e07\"> $" + valor + "</strong> </div>\n" + "        <br>\n"
					+ "        <table class=\"list\" style=\"width: 100%; border-collapse: collapse; border-top:1px solid #eee\">\n"
					+ "            <thead>\n"
					+ "            <tr style=\" background: #fafafa; color: #333; border-bottom: 1px solid #eee\">\n"
					+ "                Si tienes alguna consulta con respecto a esta informacion no dudes en comunicarte con nosotros, "
					+ "caso contrario no es necesario responder a este correo electronico.\n" + "            </tr>\n"
					+ "            </thead>\n" + "            <tbody>\n" + "	\n"
					+ "			  <tr style=\" background: #fafafa; color: #333; border-bottom: 1px solid #eee;;font-size:7px\n"
					+ "				align-items: center;display: flex;justify-content: center;\">\n"
					+ "			  <td style=\" font-size:9px\">Copyright © 2022 DECKXEL, All rights reserved.</td>\n"
					+ "\n" + "			 </tr>\n"
					+ "			 <tr style=\" background: #fafafa; color: #333; border-bottom: 1px solid #eee;;font-size:7px\n"
					+ "				align-items: center;display: flex;justify-content: center;\">\n"
					+ "			  <td style=\" font-size:9px\">DECKXEL - Tlf. 0993530018</td>\n" + "\n"
					+ "			 </tr>\n" + "\n"
					+ "			  <tr style=\" background: #fafafa; color: #333; border-bottom: 1px solid #eee;;font-size:7px\n"
					+ "				align-items: center;display: flex;justify-content: center;\">\n"
					+ "			  <td style=\" font-size:9px\">Tabacundo - Ecuador</td>\n" + "\n"
					+ "			 </tr>\n" + "\n" + "            </tbody>\n" + "        </table>\n" + "    </div>\n"
					+ "</div>\n" + "</body>\n" + "";

			texto.setContent(HTMLENVIO, "text/html");

			MimeMultipart multiParte = new MimeMultipart();
			// inicio adjunto
//            if (attachFiles != null && attachFiles.length > 0) {
//                for (String filePath : attachFiles) {
//                    MimeBodyPart attachPartDoc = new MimeBodyPart();
//                    try {
//                        if (!filePath.equals("")) {
//                            attachPartDoc.attachFile(filePath);
//                        }
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }
//                    multiParte.addBodyPart(attachPartDoc);
//                }
//            }
			m.setRecipients(Message.RecipientType.TO, InternetAddress.parse(address));
			multiParte.addBodyPart(texto);

//            m.setRecipients(Message.RecipientType.TO, addresTto);
//            m.setRecipients(Message.RecipientType.BCC, from);
			m.setSubject(asuntoInf);
			m.setSentDate(new java.util.Date());
//             m.setContent(dirDatos, "text/plain");
			m.setContent(multiParte);

			Transport t = session.getTransport(protocol);
//             t.connect();
			t.connect(host, usuarioSmpt, password);
			t.send(m);
			t.close();
			return "Envio correcto";
		} catch (javax.mail.MessagingException e) {
			System.out.println("error" + e);
			e.printStackTrace();

			return "Error:" + e.getMessage();
		} catch (UnsupportedEncodingException ex) {
			Logger.getLogger(MailerClass.class.getName()).log(Level.SEVERE, null, ex);
			return "Error:" + ex.getMessage();
		}
	}
}
