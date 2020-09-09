package com.example.assigment2.Model;

public class Translator {

    private Person person;
    private RandomFactor rf = new RandomFactor();

    public Translator(Person person) {
        this.person = person;
    }

    public Translator() {
	}

	public Translator(Person person, RandomFactor rf) {
        this.person = person;
        this.rf = rf;
	}

	public String getDuration(int i){
        if (i <= 3) {
            return  " day";
        }else if (i <= 6){
            return " week";
        }else if (i <= 9){
            return " month";
        }else {
            return " year"; } }
    public String getFirstPart(){
        String a = person.getName().substring(0, 1).toLowerCase();
        String mes;
        if ("abcdef".contains(a)){
            mes = "Next week will happen something which you have waited for more than a";
        }else if ("ghijkl".contains(a)){
            mes = "You will have more bud luck next week then you had it for the entire";
        }else if ("mnopqr".contains(a)){
            mes = "Good luck shall be yours for the entire";
        }else{
            mes = "You shall receive more money than you expect for the next";
        }
        mes += getDuration(rf.getRF());
        return mes+"\n"; }
    public String getSecondPart(){
        String mes;
        int i = rf.getRF();
        int gender = person.getGender();
        int birth = person.getBirth();
        if (gender == 1){
            if (i <= 5){
                mes = "Your training shall be twice as effective for the next";
            } else {
                mes = "Something bad shall happen in the next"; }
        }else if (gender == 2){
            if (i <= 5){
                mes = "Your popularity shall raise much greater than expected for the next";
            }else {
                mes = "Something bad shall happen in the next"; }
        }else {
            mes = "Something bad shall happen in the next";
        }

        String end ="";
        if (birth % 2 == 0 && birth <= 15){
            end= " day.";
        }
        if (birth % 2 == 0 && birth > 15){
            end= " week.";
        }
        if (birth % 2 != 0 && birth <= 15){
            end= " month.";
        }
        if (birth % 2 != 0 && birth > 15){
            end= " year.";
        }
        mes = mes+end;
        
        
        return mes+"\n"; }
    public String getThirdPart(){
        String a = person.getEthnicity().substring(0, 1).toLowerCase();
        String b = person.getNationality().substring(0,1).toLowerCase();
        String mes;
        if ("abcdefghijkl".contains(a)){
            mes = "Something bad shall happen to you next"+getDuration(rf.getRF());
        }else{
            mes = "Something bad shall happen to your friend next"+getDuration(rf.getRF()); }
        if ("abcdefghijkl".contains(b)){
            mes += ", but with enough effort you can convert it into a good thing.";
        }else{
            mes += ", but with enough effort your friend can convert it into a good thing."; }
        return mes+"\n"; }

	public void setPerson(Person person) {
        this.person = person;
	}

	public Object getPerson() {
		return person;
	}

	public Object getRf() {
		return rf;
	}

	public void setRf(RandomFactor rf) {
        this.rf = rf;
	}
}
