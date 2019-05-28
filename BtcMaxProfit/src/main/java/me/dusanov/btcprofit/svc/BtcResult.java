package me.dusanov.btcprofit.svc;
public class BtcResult {
 		private Bpi[] BpiObject;
 		private String disclaimer;
 		private Time TimeObject;
 		public Bpi[] getBpi() {return BpiObject;}
 		public String getDisclaimer() {return disclaimer;}
 		public Time getTime() {return TimeObject;}
 		public void setBpi(Bpi[] bpiObject) {this.BpiObject = bpiObject;}
 		public void setDisclaimer(String disclaimer) {this.disclaimer = disclaimer;}
 		public void setTime(Time timeObject) {this.TimeObject = timeObject;}
	class Time {
 		private String updated;
 		private String updatedISO;
 		public String getUpdated() {return updated;}
 		public String getUpdatedISO() {return updatedISO;}
 		public void setUpdated(String updated) {this.updated = updated;}
 		public void setUpdatedISO(String updatedISO) {this.updatedISO = updatedISO;}
	}
	class Bpi {
		private String date;
		private double value;
		public String getDate(){return date;}
		public double getValue(){return value;}
	}
}
