package models;

public class APIAccidentType {
	
	public int atropelamento;
	public int tombamento;
	public int queda;
	public int abalroamento;
	public int colisao;
	public int eventual;
	public int choque;
	public int capotagem;
	public int outros;

	public void insertValue(APIAccientAllTypeParser type) {
		
		switch (type.tipoAcid) {
		case 0:
			atropelamento += 1;
			break;
		case 1:
			tombamento += 1;
			break;
		case 2:
			queda += 1;
			break;
		case 3:
			abalroamento += 1;
			break;
		case 4:
			colisao += 1;
			break;
		case 5:
			eventual += 1;
			break;
		case 6:
			choque += 1;
			break;
		case 7:
			capotagem += 1;
			break;
		case 8:
			outros += 1;
			break;
			
		}
		
	}

	public void insertValue(APIFatalAccidentTypeParser type) {
		
		switch (type.tipoAcid) {
		case "0":
			atropelamento += 1;
			break;
		case "1":
			tombamento += 1;
			break;
		case "2":
			queda += 1;
			break;
		case "3":
			abalroamento += 1;
			break;
		case "4":
			colisao += 1;
			break;
		case "5":
			eventual += 1;
			break;
		case "6":
			choque += 1;
			break;
		case "7":
			capotagem += 1;
			break;
		case "8":
			outros += 1;
			break;
			
		}
		
	}

}

//0 - Atropelamento
//1 - Tombamento
//2 - Queda
//3 - Abalroamento
//4 - Colisão
//5 - Eventual
//6 - Choque
//7 - Capotagem
//8 - Não Cadastrado
