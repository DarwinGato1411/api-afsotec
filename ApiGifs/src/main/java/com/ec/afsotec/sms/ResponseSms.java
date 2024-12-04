package com.ec.afsotec.sms;

public class ResponseSms {
	   public int codError;
	    public String desError;
	    public String transactionId;
		public int getCodError() {
			return codError;
		}
		public void setCodError(int codError) {
			this.codError = codError;
		}
		public String getDesError() {
			return desError;
		}
		public void setDesError(String desError) {
			this.desError = desError;
		}
		public String getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}
	    
}
