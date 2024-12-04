package com.ec.afsotec.sms;

import java.util.ArrayList;

public class RequestSms {
	   public String phoneNumber;
	    public int messageId;
	    public String transactionId;
	    public ArrayList<String> dataVariable;
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public int getMessageId() {
			return messageId;
		}
		public void setMessageId(int messageId) {
			this.messageId = messageId;
		}
		public String getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}
		public ArrayList<String> getDataVariable() {
			return dataVariable;
		}
		public void setDataVariable(ArrayList<String> dataVariable) {
			this.dataVariable = dataVariable;
		}
	    
	    
}
